package com.lesson.spark.core.rdd.operator

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
 * @author LiuJing
 * @create 2020-06-05 9:12
 */
object Spark23_RDD_Test5 {
  def main(args: Array[String]): Unit = {
    //小练习: 将List("Hello", "hive", "hbase", "Hadoop")根据单词首写字母进行分组

    val sparkConf: SparkConf = new SparkConf().setMaster("local[*]").setAppName("groupBy-Test")
    val sc = new SparkContext(sparkConf)

    val rdd: RDD[String] = sc.makeRDD(List("Hello", "hive", "hbase", "Hadoop"))

    val groupRDD: RDD[(Char, Iterable[String])] = rdd.groupBy(
      word => word(0)
    )
    println(groupRDD.collect().mkString(","))

    sc.stop()
  }
}
