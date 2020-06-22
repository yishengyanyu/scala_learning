package com.lesson.spark.core.rdd.operator

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
 * @author LiuJing
 * @create 2020-06-05 14:42
 */
object Spark37_RDD_Operator19 {
  def main(args: Array[String]): Unit = {

    //TODO Spark - RDD - 算子

    val sparkConf = new SparkConf().setMaster("local[*]").setAppName("File-RDD")

    val sc = new SparkContext(sparkConf)

    //TODO reduceByKey : 根据数据的key进行分组,然后对value进行聚合
    val rdd: RDD[(String, Int)] = sc.makeRDD(
      List(("hello", 1), ("scala", 1), ("hello", 1))
    )

    //word => (word,1)
    //reduceByKey第一个参数表示相同的key的value进行聚合
    //reduceByKey第二个参数表示
    val rdd1: RDD[(String, Int)] = rdd.reduceByKey(_+_,2)

    println(rdd1.collect().mkString(","))

    sc.stop()
  }
}
