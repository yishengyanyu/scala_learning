package com.lesson.spark.core.rdd.dependency

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
 * @author LiuJing
 * @create 2020-06-06 16:05
 */
object Spark55_Dept1 {
  def main(args: Array[String]): Unit = {
    val sparkConf = new SparkConf().setMaster("local").setAppName("wordCount")

    val sc = new SparkContext(sparkConf)

    val fileRDD: RDD[String] = sc.textFile("input/w.txt")
    //TODO OneToOneDependency
    //依赖关系中，现在的数据分区和依赖前的数据分区一一对应。
    println(fileRDD.dependencies)
    println("----------------------")

    val wordRDD: RDD[String] = fileRDD.flatMap(_.split(" "))
    println(wordRDD.dependencies)
    println("----------------------")

    //TODO OneToOneDependency(1:1)
    val mapRDD: RDD[(String, Int)] = wordRDD.map((_,1))
    println(mapRDD.dependencies)
    println("----------------------")

    //TODO ShuffleDependency (N:N)
    val resultRDD: RDD[(String, Int)] = mapRDD.reduceByKey(_+_)
    println(resultRDD.dependencies)

    resultRDD.collect()

  }
}
