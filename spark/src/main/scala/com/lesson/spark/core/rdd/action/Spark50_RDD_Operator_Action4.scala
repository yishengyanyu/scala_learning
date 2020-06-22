package com.lesson.spark.core.rdd.action

import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.rdd.RDD

/**
 * @author LiuJing
 * @create 2020-06-06 14:04
 */
object Spark50_RDD_Operator_Action4 {
  def main(args: Array[String]): Unit = {
    //TODO Spark - 行动算子

    val sparkConf = new SparkConf().setMaster("local[*]").setAppName("File-RDD")

    val sc = new SparkContext(sparkConf)

    val rdd: RDD[Int] = sc.makeRDD(List(1,2,3,4),2)

    rdd.saveAsTextFile("output")
    //传输对象
    rdd.saveAsObjectFile("output1")
    //目标数据必须是kv类型
    rdd.map((_,1)).saveAsSequenceFile("output2")

    sc.stop()

  }
}
