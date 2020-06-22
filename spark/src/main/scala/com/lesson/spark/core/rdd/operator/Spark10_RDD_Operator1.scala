package com.lesson.spark.core.rdd.operator

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
 * @author LiuJing
 * @create 2020-06-03 14:50
 */
object Spark10_RDD_Operator1 {
  def main(args: Array[String]): Unit = {

    //TODO Spark - RDD - 算子(方法) - map

    val sparkConf = new SparkConf().setMaster("local[*]").setAppName("wordCount")
    val sc = new SparkContext(sparkConf)

    //分区: 12,34
    val rdd: RDD[Int] = sc.makeRDD(List(1,2,3,4),2)

    //TODO 分区问题
    //RDD中有分区列表
    //默认分区数量不变,数据会转换后输出
    //分区不变,分区的数据进行函数运算,对应的值存在原来的分区中
    val rdd1: RDD[Int] = rdd.map(_*2)

    //24, 68
    rdd1.saveAsTextFile("output")

    sc.stop()
  }
}
