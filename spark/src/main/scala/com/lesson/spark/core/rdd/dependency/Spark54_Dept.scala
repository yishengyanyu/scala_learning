package com.lesson.spark.core.rdd.dependency

import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.rdd.RDD

/**
 * @author LiuJing
 * @create 2020-06-06 15:44
 */
object Spark54_Dept {
  def main(args: Array[String]): Unit = {
    //Spark依赖关系
    val sparkConf = new SparkConf().setMaster("local").setAppName("wordCount")

    val sc = new SparkContext(sparkConf)

    //TODO new ParallelCollectionRDD
    val rdd = sc.makeRDD(List("hello scala","hello spark"))
    println(rdd.toDebugString)
    println("=====================")

    //TODO : new MapPartitionsRDD -> new ParallelCollectionRDD
    val wordRDD: RDD[String] = rdd.flatMap(
      word => word.split(" ")
    )
    println(wordRDD.toDebugString)
    println("=====================")

    //TODO : new MapPartitionsRDD -> new MapPartitionsRDD
    val mapRDD: RDD[(String, Int)] = wordRDD.map(
      word => (word, 1)
    )
    println(mapRDD.toDebugString)
    println("=====================")

    //TODO  new ShuffledRDD -> new MapPartitionsRDD
    //如果Spark的计算过程中某一个节点计算失败,那么框架会尝试重新计算
    //Spark想要重新计算,就需要知道数据的来源,并且还需要知道数据经历了哪些计算
    //RDD不保存计算的数据,但是会保存元数据的信息
    val resultRDD: RDD[(String, Int)] = mapRDD.reduceByKey(_+_)
    println(resultRDD.toDebugString)
    println("=====================")

    println(resultRDD.collect().mkString(","))

    sc.stop()
  }
}
