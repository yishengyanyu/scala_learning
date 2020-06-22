package com.lesson.spark.core.req.service

import java.io

import com.lesson.spark.core.req.bean.HotCategory
import com.lesson.spark.core.req.dao.HotCategoryAnalysisTop10Dao
import com.lesson.spark.core.req.helper.HotCategoryAccumulator
import com.lesson.summer.framework.core.TService
import com.lesson.summer.framework.util.EnvUtil
import org.apache.spark.rdd.RDD

import scala.collection.mutable
import scala.collection.mutable.ArrayOps

/**
 * @author LiuJing
 * @create 2020-06-09 15:38
 */
class HotCategoryAnalysisTop10Service extends TService{
  private val hotDao = new HotCategoryAnalysisTop10Dao

  /**
   * 数据分析
   *
   * @return
   */
  override def analysis() ={
    //TODO 获取电商数据
    val actionRDD: RDD[String] = hotDao.readFile("input/user_visit_action.txt")

    //TODO 对品类进行点击的统计
    val clickRDD: RDD[(String, Int)] = actionRDD.map(
      line => {
        val words: ArrayOps.ofRef[String] = line.split("_")
        (words(6), 1)
      }
    ).filter(_._1 != "-1")
    val clickCountRDD: RDD[(String, Int)] = clickRDD.reduceByKey(_+_)

    //TODO 对品类进行下单的统计
    val orderRDD = actionRDD.map(
      line => {
        val words: ArrayOps.ofRef[String] = line.split("_")
        words(8)
      }
    ).filter(_ != "null")
    val orderToOneRDD: RDD[(String, Int)] = orderRDD.flatMap(
      t => {
        val ids: Array[String] = t.split(",")
        ids.map((_, 1))
      }
    )
    val orderCountRDD: RDD[(String, Int)] = orderToOneRDD.reduceByKey(_+_)

    //TODO TODO 对品类进行支付的统计
    val payRDD = actionRDD.map(
      line => {
        val words: ArrayOps.ofRef[String] = line.split("_")
        words(10)
      }
    ).filter(_ != "null")
    val payToOneRDD: RDD[(String, Int)] = payRDD.flatMap(
      t => {
        val ids = t.split(",")
        ids.map((_, 1))
      }
    )
    val payCountRDD: RDD[(String, Int)] = payToOneRDD.reduceByKey(_+_)

    //TODO 将上面统计的结果转换结构
    val joinRDD: RDD[(String, (Int, Int))] = clickCountRDD.join(orderCountRDD)
    val joinRDD1: RDD[(String, ((Int, Int), Int))] = joinRDD.join(payCountRDD)


    //TODO 将转换结构后的数据进行排序（降序）
    val mapRDD: RDD[(String, (Int, Int, Int))] = joinRDD1.mapValues {
      case ((clickCount, orderCount), payCount) => {
        (clickCount, orderCount, payCount)
      }
    }

    val sortRDD: RDD[(String, (Int, Int, Int))] = mapRDD.sortBy(_._2, false)

    //TODO 将排序后的结果取前10名
    val array: Array[(String, (Int, Int, Int))] = sortRDD.take(10)

    array
  }

  //优化一:避免使用join
  override def analysis1() = {
    //TODO 获取数据
    val actionRDD: RDD[String] = hotDao.readFile("input/user_visit_action.txt")

    //TODO 获取(品类,clickCount),(品类,orderCount),(品类,orderCount)
    //  获取(品类,clickCount)
    val clickOneRDD: RDD[(String, Int)] = actionRDD.map(
      line => {
        val words: Array[String] = line.split("_")
        (words(6), 1)
      }
    ).filter(_._1 != "-1")
    val clickCountRDD: RDD[(String, Int)] = clickOneRDD.reduceByKey(_+_)

    //获取(品类,orderCount)
    val orderIterRDD: RDD[String] = actionRDD.map(
      line => {
        val words: Array[String] = line.split("_")
        words(8)
      }
    ).filter(_ != "null")
    val orderOneRDD: RDD[(String, Int)] = orderIterRDD.flatMap(
      iter => {
        val array: Array[String] = iter.split(",")
        array.map((_,1))
      }
    )
    val orderCountRDD: RDD[(String, Int)] = orderOneRDD.reduceByKey(_+_)

    //获取(品类,payCount)
    val payIterRDD: RDD[String] = actionRDD.map(
      line => {
        val words: Array[String] = line.split("_")
        words(10)
      }
    ).filter(_ != "null")
    val payOneRDD: RDD[(String, Int)] = payIterRDD.flatMap(
      iter => {
        val array: Array[String] = iter.split(",")
        array.map((_,1))
      }
    )
    val payCountRDD: RDD[(String, Int)] = payOneRDD.reduceByKey(_+_)

    //不使用join
    //转换为最终形式: (品类,(click,0,0))/(品类,(0,order,0))/(品类,(0,0,pay))
    val newClickCountRDD: RDD[(String, (Int, Int, Int))] = clickCountRDD.map {
      case (k, v) => {
        (k, (v, 0, 0))
      }
    }
    val newOrderCountRDD: RDD[(String, (Int, Int, Int))] = orderCountRDD.map {
      case (k, v) => {
        (k, (0, v, 0))
      }
    }
    val newPayCountRDD: RDD[(String, (Int, Int, Int))] = payCountRDD.map {
      case (k, v) => {
        (k, (0, 0, v))
      }
    }

    //合并三者
    val unionRDD: RDD[(String, (Int, Int, Int))] =
      newClickCountRDD.union(newOrderCountRDD.union(newPayCountRDD))

    val reduceCountRDD: RDD[(String, (Int, Int, Int))] = unionRDD.reduceByKey(
      (x, y) => {
        (x._1 + y._1, x._2 + y._2, x._3 + y._3)
      }
    )
    val sortRDD: RDD[(String, (Int, Int, Int))] = reduceCountRDD.sortBy(_._2, false)

    sortRDD.take(10)
  }

  //优化二: 读取数据和切片这些操作重复了3次, 可以写在一起进行优化
  override def analysis2()= {
    val actionRDD: RDD[String] = hotDao.readFile("input/user_visit_action.txt")

    //将数据切分,获取品类, click, order, pay
    val flatMapRDD: RDD[(String, (Int, Int, Int))] = actionRDD.flatMap(
      line => {
        val datas: Array[String] = line.split("_")
        if (datas(6) != "-1") {
          List( ( datas(6), (1, 0, 0) ) )
        } else if (datas(8) != "null") {
          val ids: Array[String] = datas(8).split(",")
          ids.map(id => (id , (0,1,0)))
        } else if (datas(10) != "null") {
          val ids: Array[String] = datas(10).split(",")
          ids.map(id => (id , (0,0,1)))
        } else {
          Nil
        }
      }
    )
    val reduceRDD: RDD[(String, (Int, Int, Int))] = flatMapRDD.reduceByKey(
      (x, y) => {
        (x._1 + y._1, x._2 + y._2, x._3 + y._3)
      }
    )
    val sortRDD: RDD[(String, (Int, Int, Int))] = reduceRDD.sortBy(_._2, false)

    sortRDD.take(10)
  }

  //优化三: 使用样例类
  override def analysis3() = {
    val actionRDD: RDD[String] = hotDao.readFile("input/user_visit_action.txt")

    //将数据切分,获取品类, click, order, pay
    val flatMapRDD: RDD[(String, HotCategory)] = actionRDD.flatMap(
      line => {
        val datas: Array[String] = line.split("_")
        if (datas(6) != "-1") {
          List((datas(6), HotCategory(datas(6), 1, 0, 0)))
        } else if (datas(8) != "null") {
          val ids: Array[String] = datas(8).split(",")
          ids.map(id => (id, HotCategory(id, 0, 1, 0)))
        } else if (datas(10) != "null") {
          val ids: Array[String] = datas(10).split(",")
          ids.map(id => (id, HotCategory(id, 0, 0, 1)))
        } else {
          Nil
        }
      }
    )
    val reduceRDD: RDD[(String, HotCategory)] = flatMapRDD.reduceByKey(
      (x, y) => {
        x.clickCount = x.clickCount + y.clickCount
        x.orderCount = x.orderCount + y.orderCount
        x.payCount = x.payCount + y.payCount
        x
      }
    )

    //可以自定义排序工具
    val sortRDD: Array[(String, HotCategory)] = reduceRDD.collect().sortWith(
      (left, right) => {
        val leftHC = left._2
        val rightHC = right._2
        if (leftHC.clickCount > rightHC.clickCount) {
          true
        } else if (leftHC.clickCount == rightHC.clickCount) {
          if (leftHC.orderCount > rightHC.orderCount) {
            true
          } else if (leftHC.orderCount == rightHC.orderCount) {
            leftHC.payCount > rightHC.payCount
          } else {
            false
          }
        } else {
          false
        }
      }
    )
    sortRDD.take(10)
  }

  //优化四: 使用累加器对数据进行聚合
  override def analysis4() = {
    val actionRDD: RDD[String] = hotDao.readFile("input/user_visit_action.txt")

    //声明累加器变量
    val acc = new HotCategoryAccumulator
    EnvUtil.getEnv().register(acc,"hotCategory")

    actionRDD.foreach(
      action => {
        val datas: Array[String] = action.split("_")
        if (datas(6) != "-1") {
          acc.add(datas(6),"click")
        } else if (datas(8) != "null") {
          val ids: Array[String] = datas(8).split(",")
          ids.map(id => acc.add(id, "order"))
        } else if (datas(10) != "null") {
          val ids: Array[String] = datas(10).split(",")
          ids.map(id => acc.add(id, "pay"))
        } else {
          Nil
        }
      }
    )

    //获取累加器的值
    val value: mutable.Map[String, HotCategory] = acc.value
    val categories: mutable.Iterable[HotCategory] = value.map((_._2))

    val result: List[HotCategory] = categories.toList.sortWith(
      (leftHC, rightHC) => {
        if (leftHC.clickCount > rightHC.clickCount) {
          true
        } else if (leftHC.clickCount == rightHC.clickCount) {
          if (leftHC.orderCount > rightHC.orderCount) {
            true
          } else if (leftHC.orderCount == rightHC.orderCount) {
            leftHC.payCount > rightHC.payCount
          } else {
            false
          }
        } else {
          false
        }
      }
    ).take(10)
    result
  }
}
