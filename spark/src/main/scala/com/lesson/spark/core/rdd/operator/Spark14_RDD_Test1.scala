package com.lesson.spark.core.rdd.operator

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
 * @author LiuJing
 * @create 2020-06-03 15:50
 */
object Spark14_RDD_Test1 {
  def main(args: Array[String]): Unit = {
    //TODO Spark - RDD - 算子(方法)

    val sparkConf = new SparkConf().setMaster("local[*]").setAppName("File-RDD")
    val sc = new SparkContext(sparkConf)

    val dataRDD: RDD[Int] = sc.makeRDD(List(1,3,6,2,5),2)

    //获取每个分区数据的最大值
    val rdd: RDD[Int] = dataRDD.mapPartitions(
      iter => {
        List(iter.max).iterator
      }
    )
    println(rdd.collect().mkString(","))  //3,6

    sc.stop()
  }
}
