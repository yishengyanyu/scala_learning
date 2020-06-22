package com.lesson.spark.core.rdd.action

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
 * @author LiuJing
 * @create 2020-06-06 11:35
 */
object Spark46_RDD_Operator_Action {
  def main(args: Array[String]): Unit = {
    //TODO Spark - 行动算子介绍

    val sparkConf = new SparkConf().setMaster("local[*]").setAppName("File-RDD")

    val sc = new SparkContext(sparkConf)

    //所谓的行动算子,不会再产生新的RDD,而是会触发作业的执行
    //行动算子执行后会获取到作业的执行结果
    //转换算子不会触发作业的执行,而是功能的扩展和包装
    val rdd: RDD[Int] = sc.makeRDD(List(1,2,3,4),2)

    //Spark行动算子执行时,会产生job对象,然后提交这个job对象
    val data: Array[Int] = rdd.collect()
    //val results = sc.runJob(this, (iter: Iterator[T]) => iter.toArray)
    //handleJobSubmitted

    data.foreach(println)

    sc.stop()
  }
}
