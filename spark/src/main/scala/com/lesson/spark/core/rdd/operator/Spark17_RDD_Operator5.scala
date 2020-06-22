package com.lesson.spark.core.rdd.operator

import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.rdd.RDD

/**
 * @author LiuJing
 * @create 2020-06-03 16:18
 */
object Spark17_RDD_Operator5 {
  def main(args: Array[String]): Unit = {
    //TODO Spark - RDD - 算子(方法) - flatMap

    val sparkConf = new SparkConf().setMaster("local[*]").setAppName("File-RDD")
    val sc = new SparkContext(sparkConf)

    val dataRDD = sc.makeRDD(List(List(1,3),List(6,5)))

    val rdd: RDD[Int] = dataRDD.flatMap(list => list)

    println(rdd.collect().mkString(","))

    sc.stop()
  }
}
