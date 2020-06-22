package com.lesson.spark.core.Practice

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
 * @author LiuJing
 * @create 2020-06-07 22:11
 */
object Practice_RDD_Serial {
  def main(args: Array[String]): Unit = {
    //序列化
    val sparkConf: SparkConf = new SparkConf().setMaster("local").setAppName("Memory-RDD")

    val sc = new SparkContext(sparkConf)

    //序列化案例
    val rdd: RDD[Int] = sc.makeRDD(
      List(1, 2, 3, 4), 2
    )

    rdd.map(
      elem => {
        new User().age + elem
      }
    ).foreach(println)

    //闭包检测
    val rdd1: RDD[Nothing] = sc.makeRDD(Nil)
    val user = new User
    rdd1.map(
      elem => {
        user.age + elem
      }
    ).foreach(println)

    sc.stop()

  }

  class User(val age:Int = 20)  {

  }
}
