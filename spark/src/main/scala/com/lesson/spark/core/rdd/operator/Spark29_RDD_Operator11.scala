package com.lesson.spark.core.rdd.operator

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
 * @author LiuJing
 * @create 2020-06-05 10:20
 */
object Spark29_RDD_Operator11 {
  def main(args: Array[String]): Unit = {
    //TODO Spark - RDD - 算子(方法)

    val sparkConf = new SparkConf().setMaster("local[*]").setAppName("File-RDD")

    val sc = new SparkContext(sparkConf)

    //TODO
    val rdd: RDD[Int] = sc.makeRDD(List(1,1,1,2,2,2),6)

    //[1,1,1],[2,2,2]
    //[],[2,2,2]
    val filterRDD: RDD[Int] = rdd.filter(_%2==0)

    //多 => 少
    //TODO 当数据过滤后,数据不够均匀,可以缩减分区
    val coalesceRDD: RDD[Int] = filterRDD.coalesce(1)

    coalesceRDD.saveAsTextFile("output")

    //TODO 如果发现数据分区不合理,也可以缩减分区
    val coalesceRDD1: RDD[Int] = filterRDD.coalesce(2)
    coalesceRDD1.saveAsTextFile("output1")

    sc.stop()

  }
}
