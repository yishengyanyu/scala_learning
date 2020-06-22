package com.lesson.spark.core.rdd.action

import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.rdd.RDD

/**
 * @author LiuJing
 * @create 2020-06-06 11:53
 */
object Spark49_RDD_Operator_Action3 {
  def main(args: Array[String]): Unit = {
    //TODO Spark - 行动算子

    val sparkConf = new SparkConf().setMaster("local[*]").setAppName("File-RDD")

    val sc = new SparkContext(sparkConf)

    val rdd: RDD[Int] = sc.makeRDD(List(2,1,4,3),2)

    //TODO sum
    //返回值为Double类型
    val d: Double = rdd.sum() //10

    //TODO aggregate
    //分区内计算,分区间计算
    //aggregateByKey: 初始值只参与到分区内计算
    //aggregate: 初始值不仅参与分区内计算, 还要参与分区间计算
    val i: Int = rdd.aggregate(10)(_+_,_+_)  //40

    //TODO fold
    val i1: Int = rdd.fold(10)(_+_)

    //TODO countByKey - 7
    val rdd1: RDD[(String, Int)] = sc.makeRDD(
      List(
        ("a", 1), ("a", 2), ("a",3),("b", 3)
      )
    )
    val count: collection.Map[String, Long] = rdd1.countByKey()
    count.foreach(println)  //((a,3),(b,1))

    //TODO countByValue
    val rdd2 = sc.makeRDD(
      List(
        ("a", 1), ("a", 2), ("b", 3)
      )
    )

    //统计集合中相同元素出现的次数
    val count1: collection.Map[(String, Int), Long] = rdd2.countByValue()

    count1.foreach(println)
    //((b,3),1)
    //((a,2),1)
    //((a,1),1)

    println(i + "," + d)

    sc.stop()
  }
}
