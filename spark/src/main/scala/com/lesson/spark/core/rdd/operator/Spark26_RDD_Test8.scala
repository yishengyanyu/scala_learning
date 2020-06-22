package com.lesson.spark.core.rdd.operator

import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.rdd.RDD

/**
 * @author LiuJing
 * @create 2020-06-05 9:25
 */
object Spark26_RDD_Test8 {
  def main(args: Array[String]): Unit = {
    // TODO Spark - RDD - 算子（方法）

    val sparkConf = new SparkConf().setMaster("local[*]").setAppName("File - RDD")
    val sc = new SparkContext(sparkConf)

    //从服务器日志数据apache.log中获取2015年5月17日的请求路径
    val fileRDD: RDD[String] = sc.textFile("input/apache.log")

    val timeRDD: RDD[String] = fileRDD.map(
      line => {
        val data: Array[String] = line.split(" ")
        data(3)
      }
    )
    val filterRDD: RDD[String] = timeRDD.filter(
      data => data.substring(0, 10) == "17/05/2015"
    )
    filterRDD.collect().foreach(println)

    sc.stop()
  }
}
