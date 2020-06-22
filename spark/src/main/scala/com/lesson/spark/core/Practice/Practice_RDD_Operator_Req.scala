package com.lesson.spark.core.Practice

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
 * @author LiuJing
 * @create 2020-06-06 10:58
 */
object Practice_RDD_Operator_Req {
  def main(args: Array[String]): Unit = {
    val sparkConf: SparkConf = new SparkConf().setMaster("local[*]").setAppName("File-RDD")
    val sc = new SparkContext(sparkConf)

    //TODO 统计出每一个省份每个广告被点击数量排行的Top3
    val fileRDD: RDD[String] = sc.textFile("input/agent.log")

    val mapRDD = fileRDD.map(
      line => {
        val data: Array[String] = line.split(" ")
        (data(1)+"-"+data(4), 1)
      }
    )

    val reduceRDD: RDD[(String, Int)] = mapRDD.reduceByKey(_+_)

    val mapRDD1: RDD[(String, (String, Int))] = reduceRDD.map(
      line => {
        val words: Array[String] = line._1.split("-")
        (words(0), (words(1), line._2))
      }
    )

    val groupRDD: RDD[(String, Iterable[(String, Int)])] = mapRDD1.groupByKey()

    val result: RDD[(String, List[(String, Int)])] = groupRDD.mapValues(
      iter => {
        iter.toList.sortWith(
          (left, right) => {
            left._2 > right._2
          }
        ).take(3)
      }
    )
    result.collect.foreach(println)

    sc.stop()
  }
}
