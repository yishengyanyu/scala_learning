package com.lesson.spark.core.rdd.operator

import org.apache.spark.{SparkConf, SparkContext}

/**
 * @author LiuJing
 * @create 2020-06-05 9:22
 */
object Spark25_RDD_Test7 {
  def main(args: Array[String]): Unit = {
    // TODO Spark - RDD - 算子（方法）

    val sparkConf = new SparkConf().setMaster("local[*]").setAppName("File - RDD")
    val sc = new SparkContext(sparkConf)

    val dataRDD = sc.makeRDD(List("Hello Scala", "Hello"))

    println(dataRDD
      .flatMap(_.split(" "))
      .groupBy(word => word)
      .map(kv => (kv._1, kv._2.size))
      .collect()
      .mkString(","))

    sc.stop()

  }
}
