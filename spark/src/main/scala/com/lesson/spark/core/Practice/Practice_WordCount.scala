package com.lesson.spark.core.Practice

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
 * @author LiuJing
 * @create 2020-06-06 20:58
 */
object Practice_WordCount {
  def main(args: Array[String]): Unit = {
    val conf: SparkConf = new SparkConf().setMaster("local").setAppName("WordCount")

    val sc = new SparkContext(conf)

    val rdd: RDD[String] = sc.makeRDD(
      List("hello scala spark", "hello spark hive","hello hive")
    )

    wordCount1(rdd)
    println("=================")
    wordCount2(rdd)
    println("=================")
    wordCount3(rdd)
    println("=================")
    wordCount4(rdd)
    println("=================")
    wordCount5(rdd)
    println("=================")
    wordCount6(rdd)
    println("=================")
    wordCount7(rdd)
    println("=================")
    wordCount8(rdd)
    println("=================")
    wordCount9(rdd)
    println("=================")
    wordCount10(rdd)
    println("=================")
    wordCount11(rdd)
    println("=================")
    wordCount12(rdd)
    println("=================")

    sc.stop()


  }
  def wordCount1(rdd:RDD[String]) ={

    rdd.flatMap(_.split(" "))
       .map((_,1))
       .reduceByKey(_+_)
       .collect()
       .foreach(println)
  }

  def wordCount2(rdd:RDD[String]) ={
    rdd.flatMap(_.split(" "))
       .groupBy(word => word)
       .map(kv => (kv._1, kv._2.size))
       .collect()
       .foreach(println)
  }

  def wordCount3(rdd:RDD[String]) ={
    rdd.flatMap(_.split(" "))
      .map((_,1))
      .groupByKey()
      .map(kv => (kv._1,kv._2.size))
      .foreach(println)
  }

  def wordCount4(rdd:RDD[String]) ={
    rdd.flatMap(_.split(" "))
      .map((_,1))
      .aggregateByKey(0)(_ + _ , _ + _)
      .foreach(println)
  }

  def wordCount5(rdd:RDD[String]) ={
    rdd.flatMap(_.split(" "))
      .map((_,1))
      .foldByKey(0)(_ + _)
      .foreach(println)
  }

  def wordCount6(rdd:RDD[String]) ={
    rdd.flatMap(_.split(" "))
       .map((_, 1))
       .combineByKey(
          v => (v,1),
          (t:(Int,Int),v) => (t._1+v, t._2),
          (t1:(Int,Int), t2:(Int,Int)) => (t1._1+t1._1, t1._2+t2._2)
        )
       .map(kv => (kv._1, kv._2._1))
       .foreach(println)
  }

  def wordCount7(rdd:RDD[String]) ={

    val rdd1: RDD[(String, Int)] = rdd.flatMap(_.split(" ")).map((_, 1))

    rdd1.cogroup(rdd1)
        .map(k => (k._1,k._2._1.size))
        .foreach(println)
  }

  def wordCount8(rdd:RDD[String]) ={
    rdd.flatMap(_.split(" "))
      .map((_, 1))
      .countByValue()
      .map { case (k, v) => (k._1, v) }
      .foreach(println)
  }

  def wordCount9(rdd:RDD[String]) ={
    rdd.flatMap(_.split(" "))
      .map((_, 1))
      .countByKey()
      .foreach(println)
  }

  def wordCount10(rdd:RDD[String]) ={
    rdd.flatMap(_.split(" "))
      .countByValue()
      .foreach(println)
  }

  def wordCount11(rdd:RDD[String]) ={
    val rdd1: RDD[(String, Int)] = rdd.flatMap(_.split(" ")).map((_, 1))

    rdd1.join(rdd1.distinct())
        .countByKey()
        .foreach(println)
  }

  def wordCount12(rdd:RDD[String]) ={
    val rdd1: RDD[String] = rdd.flatMap(_.split(" "))

    rdd1.zip(rdd1)
        .countByKey()
        .foreach(println)
  }

}
