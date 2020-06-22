package com.lesson.spark.core.rdd.operator

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
 * @author LiuJing
 * @create 2020-06-03 17:06
 */
object Spark22_RDD_Operator8 {
  def main(args: Array[String]): Unit = {

    //TODO Spark - RDD - 算子(方法)

    //TODO 过滤
    //  根据指定的规则对数据进行筛选过滤，满足条件的数据保留，不满足的数据丢弃

    val sparkConf = new SparkConf().setMaster("local[*]").setAppName("File-RDD")

    val sc = new SparkContext(sparkConf)

    val dataRDD = sc.makeRDD(List(1,2,3,4),2)

    val rdd: RDD[Int] = dataRDD.filter(_%2 == 0)

    println(rdd.collect().mkString(","))

    sc.stop()

  }
}
