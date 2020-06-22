package com.lesson.spark.core.rdd.action

import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.rdd.RDD

/**
 * @author LiuJing
 * @create 2020-06-06 11:51
 */
object Spark48_RDD_Operator_Action2 {
  def main(args: Array[String]): Unit = {
    //TODO Spark - 行动算子

    val sparkConf = new SparkConf().setMaster("local[*]").setAppName("File-RDD")

    val sc = new SparkContext(sparkConf)

    val rdd: RDD[Int] = sc.makeRDD(List(2,1,4,3),2)

    //TODO takeOrdered
    //先排序,再取前三
    val array: Array[Int] = rdd.takeOrdered(3)

    println(array.mkString(","))

    sc.stop()
  }
}
