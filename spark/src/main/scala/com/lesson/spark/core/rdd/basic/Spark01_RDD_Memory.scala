package com.lesson.spark.core.rdd.basic

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
 * @author LiuJing
 * @create 2020-06-03 18:15
 */
object Spark01_RDD_Memory {
  def main(args: Array[String]): Unit = {

    val sparkConf: SparkConf = new SparkConf().setMaster("local").setAppName("wordCount")
    val sc = new SparkContext(sparkConf)

    //TODO Spark - 从内存中创建RDD
    // 1. parallelize : 并行
    val list = List(1,2,3,4)
    val rdd: RDD[Int] = sc.parallelize(list)  //需要传入Seq参数,可以有隐式参数
    //必须要有collect才能执行
    rdd.collect().foreach(println)

    //TODO makeRDD的底层代码其实就是调用了parallelize方法
    //makeRDD就是对parallelize()做了包装
    val rdd1: RDD[Int] = sc.makeRDD(list)
    println(rdd1.collect.mkString(","))

    sc.stop()
  }
}
