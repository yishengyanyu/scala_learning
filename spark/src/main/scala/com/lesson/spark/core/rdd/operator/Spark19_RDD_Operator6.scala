package com.lesson.spark.core.rdd.operator

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
 * @author LiuJing
 * @create 2020-06-03 16:39
 */
object Spark19_RDD_Operator6 {
  def main(args: Array[String]): Unit = {
    //TODO Spark - RDD - 算子(方法)

    //glom => 将每个分区的数据转换为数组

    val sparkConf = new SparkConf().setMaster("local[*]").setAppName("File-RDD")
    val sc = new SparkContext(sparkConf)

    val dataRDD = sc.makeRDD(List(1,2,3,4),2)

    val rdd: RDD[Array[Int]] = dataRDD.glom()

    rdd.foreach(
      array => {
        println(array.mkString(","))
      }
    )

    sc.stop()
  }
}
