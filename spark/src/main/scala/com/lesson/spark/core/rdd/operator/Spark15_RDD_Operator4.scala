package com.lesson.spark.core.rdd.operator

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
 * @author LiuJing
 * @create 2020-06-03 16:06
 */
object Spark15_RDD_Operator4 {
  def main(args: Array[String]): Unit = {
    //TODO Spark - RDD - 算子(方法)

    val sparkConf = new SparkConf().setMaster("local[*]").setAppName("File-RDD")
    val sc = new SparkContext(sparkConf)

    //获取每个分区最大值及分区号
    val dataRDD: RDD[Int] = sc.makeRDD(List(1,3,6,2,5),2)

    val rdd: RDD[(Int, Int)] = dataRDD.mapPartitionsWithIndex(
      (index, iter) => {
        List((index, iter.max)).iterator
      }
    )
    println(rdd.collect().mkString(","))  //(0,3).(1,6)

    sc.stop()
  }
}
