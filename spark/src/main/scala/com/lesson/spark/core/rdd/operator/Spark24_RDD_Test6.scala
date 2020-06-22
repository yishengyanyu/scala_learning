package com.lesson.spark.core.rdd.operator

import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.rdd.RDD

/**
 * @author LiuJing
 * @create 2020-06-05 9:19
 */
object Spark24_RDD_Test6 {
  def main(args: Array[String]): Unit = {
    //小功能：从服务器日志数据apache.log中获取每个时间段访问量
    val sparkConf = new SparkConf().setMaster("local[*]").setAppName("File - RDD")
    val sc = new SparkContext(sparkConf)

    val fileRDD: RDD[String] = sc.textFile("input/apache.log")

    val timeRDD: RDD[String] = fileRDD.map {
      line => {
        val data: Array[String] = line.split(" ")
        data(3)
      }
    }
    val hourRDD: RDD[(String, Iterable[String])] = timeRDD.groupBy(
      time => {
        time.substring(11, 13) //不包含13
      }
    )
    println(hourRDD.collect().mkString(","))

    sc.stop()
  }
}
