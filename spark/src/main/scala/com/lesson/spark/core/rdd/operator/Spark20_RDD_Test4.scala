package com.lesson.spark.core.rdd.operator

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
 * @author LiuJing
 * @create 2020-06-05 9:07
 */
object Spark20_RDD_Test4 {
  def main(args: Array[String]): Unit = {
    //TODO Spark - RDD - 算子(方法)

    val sparkConf = new SparkConf().setMaster("local[*]").setAppName("File-RDD")
    val sc = new SparkContext(sparkConf)

    //glom
    //计算所有分区最大值并求和(分区内取最大值,分区间最大值求和)
    val dataRDD = sc.makeRDD(List(1,2,3,4,5,6),3)

    //将每个分区的数据转换为数组
    val glomRDD: RDD[Array[Int]] = dataRDD.glom()

    //取出每个分区数据的最大值
    //array => max
    val maxRDD: RDD[Int] = glomRDD.map(_.max)

    //对这些最大值进行求和
    val array: Array[Int] = maxRDD.collect()

    println(array.sum)

    sc.stop()
  }
}
