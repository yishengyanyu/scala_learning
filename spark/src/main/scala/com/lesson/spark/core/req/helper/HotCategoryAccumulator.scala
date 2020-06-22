package com.lesson.spark.core.req.helper

import com.lesson.spark.core.req.bean.HotCategory
import org.apache.spark.util.AccumulatorV2

import scala.collection.mutable

/**
 * @author LiuJing
 * @create 2020-06-09 23:00
 */
class HotCategoryAccumulator extends AccumulatorV2[(String,String), mutable.Map[String,HotCategory]]{
  private val map: mutable.Map[String, HotCategory] = mutable.Map[String, HotCategory]()

  override def isZero: Boolean = {
    map.isEmpty
  }

  override def copy(): AccumulatorV2[(String,String), mutable.Map[String,HotCategory]] = {
    new HotCategoryAccumulator
  }

  override def reset(): Unit = {
    map.clear()
  }

  override def add(v:(String,String)): Unit = {
    val cid: String = v._1
    val actionType: String = v._2
    val hotCategory: HotCategory = map.getOrElse(cid, HotCategory(cid,0,0,0))

    actionType match {
      case "click" => hotCategory.clickCount += 1
      case "order" => hotCategory.orderCount += 1
      case "pay" => hotCategory.payCount += 1
      case _ =>
    }
    map(cid) = hotCategory
  }

  override def merge(other: AccumulatorV2[(String,String), mutable.Map[String,HotCategory]]): Unit = {
    other.value.foreach{
      case (cid, hotCategory ) => {
        val hc: HotCategory = map.getOrElse(cid, HotCategory(cid,0,0,0))

        hc.clickCount += hotCategory.clickCount
        hc.orderCount += hotCategory.orderCount
        hc.payCount += hotCategory.payCount

        map(cid) = hc
      }
    }
  }

  override def value = map
}
