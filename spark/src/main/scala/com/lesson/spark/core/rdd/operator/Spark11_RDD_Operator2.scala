package com.lesson.spark.core.rdd.operator

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
 * @author LiuJing
 * @create 2020-06-03 15:01
 */
object Spark11_RDD_Operator2 {
  def main(args: Array[String]): Unit = {

    //TODO Spark - RDD - 算子(方法) - map

    val sparkConf = new SparkConf().setMaster("local[*]").setAppName("wordCount")
    val sc = new SparkContext(sparkConf)

    val rdd: RDD[Int] = sc.makeRDD(List(1,2,3,4),2)

    // 1,2,3,4 => x map 1(一个分区结束之后再下一个) => x map 2  错误
    // 1 => x map 1(一个数据结束之后再下一个)  => x map 2  => 2  正确

    //0 - (1,2)       1A        1B 2A 2B
    //1 - (3,4) 3A 3B    4A  4B
    //TODO 分区内数据按照顺序依次执行,第一条数据的所有逻辑执行完毕后才执行下一条数据
    //     分区间数据执行没有顺序,分区内有序,而且无需等待

    val rdd1: RDD[Int] = rdd.map(
      x => {
        println("map A = " + x)
        x
      }
    )

    val rdd2: RDD[Int] = rdd1.map(
      x => {
        println("map B = " + x)
        x
      }
    )

    println(rdd2.collect().mkString(","))

    sc.stop()
  }
}
