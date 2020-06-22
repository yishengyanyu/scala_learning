package com.lesson.spark.core.rdd.operator

import org.apache.spark.rdd.RDD
import org.apache.spark.{HashPartitioner, SparkConf, SparkContext}

/**
 * @author LiuJing
 * @create 2020-06-05 14:36
 */
object Spark36_RDD_Operator18 {
  def main(args: Array[String]): Unit = {
    val sparkConf = new SparkConf().setMaster("local[*]").setAppName("File-RDD")

    val sc = new SparkContext(sparkConf)

    //TODO 自定义分区器
    //cba,wnba,nba
    val rdd: RDD[(String, String)] = sc.makeRDD(
      List(("cba", "消息1"), ("nba", "消息2"), ("cba", "消息3"),
        ("nba", "消息4"), ("wnba", "消息5"), ("wnba", "消息6"))
    )

    //
    val rdd1: RDD[(String, String)] = rdd.partitionBy(new HashPartitioner(3))
    val rdd2: RDD[(String, String)] = rdd1.partitionBy(new HashPartitioner(3))
  }
}
