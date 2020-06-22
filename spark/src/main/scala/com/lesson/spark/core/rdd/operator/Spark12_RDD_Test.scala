package com.lesson.spark.core.rdd.operator

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
 * @author LiuJing
 * @create 2020-06-03 15:31
 */
object Spark12_RDD_Test {
  def main(args: Array[String]): Unit = {
    //TODO Spark - RDD - 算子(方法) - map小练习

    val sparkConf = new SparkConf().setMaster("local[*]").setAppName("File-RDD")
    val sc = new SparkContext(sparkConf)

    //TODO 从服务器日志数据apache.log中获取用户请求URL资源路径
    val fileRDD: RDD[String] = sc.textFile("input/apache.log")

    val urlRDD: RDD[String] = fileRDD.map(
      line => {
        val datas: Array[String] = line.split(" ")
        datas(6)
      }
    )
    urlRDD.collect().foreach(println)

    sc.stop()
  }
}
