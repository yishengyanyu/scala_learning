package com.lesson.spark.core.rdd.operator

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
 * @author LiuJing
 * @create 2020-06-03 16:21
 */
object Spark18_RDD_Test3 {
  def main(args: Array[String]): Unit = {
    //TODO Spark - RDD - 算子(方法)

    val sparkConf = new SparkConf().setMaster("local[*]").setAppName("File-RDD")
    val sc = new SparkContext(sparkConf)

    val dataRDD = sc.makeRDD(List(List(1,3),3,List(6,5)))

    val rdd: RDD[Any] = dataRDD.flatMap {
      case a: Int => List(a)
      case b: List[_] => b
    }

    println(rdd.collect().mkString(","))

    sc.stop()
  }
}
