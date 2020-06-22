package com.lesson.spark.core.req.service

import com.lesson.spark.core.req.bean
import com.lesson.spark.core.req.bean.HotCategory
import com.lesson.spark.core.req.dao.HotCategorySessionAnalysisTop10Dao
import com.lesson.summer.framework.core.TService
import com.lesson.summer.framework.util.EnvUtil
import org.apache.spark.broadcast.Broadcast
import org.apache.spark.rdd.RDD

/**
 * @author LiuJing
 * @create 2020-06-20 15:54
 */
class HotCategorySessionAnalysisTop10Service extends TService{

  private val dao = new HotCategorySessionAnalysisTop10Dao

  /**
   * 数据分析
   *
   * @return
   */
  override def analysis(data:Any) = {
    val top10: List[HotCategory] = data.asInstanceOf[List[HotCategory]]

    val top10Ids: List[String] = top10.map(_.categoryId)

    //TODO 使用广播变量实现数据的传播
    val bcList: Broadcast[List[String]] = EnvUtil.getEnv().broadcast(top10Ids)

    //TODO 获取用户行为的数据
    val actionRDD: RDD[bean.UserVisitAction] = dao.getUserVisitAction("input/user_visit_action.txt")

    //TODO 对数据进行过滤
    val filterRDD: RDD[bean.UserVisitAction] = actionRDD.filter(
      action => {
        if (action.click_category_id != -1) {
          bcList.value.contains(action.click_category_id.toString)
        } else {
          false
        }
      }
    )

    //TODO 将过滤后的数据进行处理
    //（ 品类_session,1）=> (品类_session, sum)
    val mapRDD: RDD[(String, Int)] = filterRDD.map(
      action => (action.click_category_id + "_" + action.session_id, 1)
    )

    val reduceRDD: RDD[(String, Int)] = mapRDD.reduceByKey(_+_)

    //TODO 将统计后的结果进行结构的转换
    //(品类_session, sum) => (品类, (session, sum))
    val rdd: RDD[(String, (String, Int))] = reduceRDD.map {
      case (s, i) => {
        val datas: Array[String] = s.split("_")
        (datas(0), (datas(1), i))
      }
    }

    //TODO 将转换结构后的数据对品类进行分组
    //(品类, Iterator[(session1, sum1), (session2, sum2)])
    val groupRDD: RDD[(String, Iterable[(String, Int)])] = rdd.groupByKey()

    //TODO 将分组后的数据进行排序取前10名
    val sortRDD: RDD[(String, List[(String, Int)])] = groupRDD.mapValues(
      iter => {
        iter.toList.sortWith(
          (left, right) => {
            left._2 > right._2
          }
        ).take(10)
      }
    )

    sortRDD.collect()

  }
}
