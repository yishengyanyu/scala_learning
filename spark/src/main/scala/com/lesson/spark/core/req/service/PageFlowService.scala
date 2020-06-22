package com.lesson.spark.core.req.service

import java.text.SimpleDateFormat

import com.lesson.spark.core.req.bean
import com.lesson.spark.core.req.dao.PageFlowDao
import com.lesson.summer.framework.core.{TDao, TService}
import org.apache.spark.rdd.RDD

/**
 * @author LiuJing
 * @create 2020-06-10 11:15
 */
class PageFlowService extends TService {

  private val flowDao = new PageFlowDao
  /**
   * 数据分析
   *
   * @return
   */
  override def analysis()= {
    // TODO  获取原始用户行为日志数据
    val actionRDD: RDD[bean.UserVisitAction] =
      flowDao.getUserVisitAction("input/user_visit_action.txt")
    actionRDD.cache()

    //TODO 获取分母
    //  分母为每个页面的各自总访问次数
    val pageToOneRDD: RDD[(Long, Int)] = actionRDD.map(
      action => (action.page_id, 1)
    )
    val pageToSumRDD: RDD[(Long, Int)] = pageToOneRDD.reduceByKey(_+_)
    val pageCountArray: Array[(Long, Int)] = pageToSumRDD.collect()

    //TODO 获取分子
    //TODO 将数据根据用户Session进行分组
    val sessionRDD: RDD[(String, Iterable[(String, String, Long)])] = actionRDD.map(
      action => (action.session_id, action.action_time, action.page_id)
    ).groupBy(_._1)

    val sessionPageIdsRDD: RDD[(String, List[(String, Int)])] = sessionRDD.mapValues(
      iter => {
        //排序后的list
        val list: List[(String, String, Long)] = iter.toList.sortBy(_._2)
        //按照排序, 将相邻的两个页面ID关联在一起
        val list1: List[((String, String, Long), (String, String, Long))] = list.zip(list.tail)
        list1.map {
          case (x, y) => (x._3 + "-" + y._3, 1)
        } //结构形式: (id1-id2, 1)
      }
    )

    val pageIdsSumRDD: RDD[(String, Int)] = sessionPageIdsRDD.flatMap(_._2)

    //TODO 结构形式: (id1-id2, sum)
    val reduceRDD: RDD[(String, Int)] = pageIdsSumRDD.reduceByKey(_+_)

    reduceRDD.foreach{
      case (ids, sum) => {
        val id1: String = ids.split("-")(0)
        val value: Int = pageCountArray.toMap.getOrElse(id1.toLong, 1)
        println("页面跳转【"+ids+"】的转换率为: " + (sum.toDouble / value))
      }
    }
  }

  override def analysis1() = {

    // TODO 对指定的页面流程进行页面单跳转换率的统计
    // 1，2，3，4，5，6，7
    // 1-2，2-3，3-4，4-5，5-6，6-7/
    val flowIds = List(1,2,3,4,5,6,7)
    val okFlowIds = flowIds.zip(flowIds.tail).map( t => (t._1 + "-" + t._2) )

    //TODO  获取原始用户行为日志数据
    val actionRDD: RDD[bean.UserVisitAction] =
      flowDao.getUserVisitAction("input/user_visit_action.txt")
    actionRDD.cache()

    //TODO 获取分母
    //  分母为每个页面的各自总访问次数
    val pageToOneRDD: RDD[(Long, Int)] = actionRDD.map(
      action => (action.page_id, 1)
    )
    val pageToSumRDD: RDD[(Long, Int)] = pageToOneRDD.reduceByKey(_+_)
    val pageCountArray: Array[(Long, Int)] = pageToSumRDD.collect()

    //TODO 获取分子
    //TODO 将数据根据用户Session进行分组
    val sessionRDD: RDD[(String, Iterable[(String, String, Long)])] = actionRDD.map(
      action => (action.session_id, action.action_time, action.page_id)
    ).groupBy(_._1)

    val sessionPageIdsRDD: RDD[(String, List[(String, Int)])] = sessionRDD.mapValues(
      iter => {
        //排序后的list
        val list: List[(String, String, Long)] = iter.toList.sortBy(_._2)
        //按照排序, 将相邻的两个页面ID关联在一起
        val list1: List[((String, String, Long), (String, String, Long))] = list.zip(list.tail)
        list1.map {
          case (x, y) => (x._3 + "-" + y._3, 1) //结构形式: (id1-id2, 1)
        }.filter{
          case(k, v) => { okFlowIds.contains(k) }
        }

      }
    )

    val pageIdsSumRDD: RDD[(String, Int)] = sessionPageIdsRDD.flatMap(_._2)

    //TODO 结构形式: (id1-id2, sum)
    val reduceRDD: RDD[(String, Int)] = pageIdsSumRDD.reduceByKey(_+_)

    reduceRDD.foreach{
      case (ids, sum) => {
        val id1: String = ids.split("-")(0)
        val value: Int = pageCountArray.toMap.getOrElse(id1.toLong, 1)
        println("页面跳转【"+ids+"】的转换率为: " + (sum.toDouble / value))
      }
    }
  }

  override def analysis2() = {

    //TODO 需求: 页面连续跳转的平均停留时间

    //TODO  获取原始用户行为日志数据
    val actionRDD: RDD[bean.UserVisitAction] =
      flowDao.getUserVisitAction("input/user_visit_action.txt")
    actionRDD.cache()

    //分母:  (1-2) * n
    //分子    (time2-time1)*n

    //TODO 将数据根据用户Session进行分组
    val sessionRDD: RDD[(String, Iterable[(String, String, Long)])] = actionRDD.map(
      action => (action.session_id, action.action_time, action.page_id)
    ).groupBy(_._1)

    val sessionPageTimeRDD: RDD[(String, List[(Long, (Long,Int))])] =
      sessionRDD.mapValues(
      iter => {
        //排序后的list
        val list: List[(String, String, Long)] = iter.toList.sortBy(_._2)
        //按照排序, 将相邻的两个页面ID关联在一起
        val list1: List[((String, String, Long), (String, String, Long))] =
          list.zip(list.tail)
        list1.map {
          case (x, y) => {
            (x._3 , (timeTransfer(y._2) - timeTransfer(x._2), 1))
          }
        }

      }
    )
    val flatMapRDD: RDD[(Long, (Long, Int))] = sessionPageTimeRDD.flatMap(_._2)


    //TODO
    val countRDD: RDD[(Long, (Long, Int))] = flatMapRDD.reduceByKey {
      case (x, y) => {
        (x._1 + y._1, x._2 + y._2)
      }
    }
    countRDD.foreach{
      case (id, (time, count)) => {
        val l: Long = time/count
        println("页面【"+id+"】的平均停留时间为: " + l + "ms")
      }
    }

  }
}
