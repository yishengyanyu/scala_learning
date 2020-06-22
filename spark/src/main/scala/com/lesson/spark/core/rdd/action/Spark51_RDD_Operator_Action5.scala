package com.lesson.spark.core.rdd.action

import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.rdd.RDD

/**
 * @author LiuJing
 * @create 2020-06-06 14:22
 */
object Spark51_RDD_Operator_Action5 {
  def main(args: Array[String]): Unit = {
    val sparkConf = new SparkConf().setMaster("local[*]").setAppName("File-RDD")

    val sc = new SparkContext(sparkConf)

    val rdd: RDD[Int] = sc.makeRDD(List(1,2,3,4),2)

    //Driver,Executor

    //TODO foreach为方法
    //集合的方法的代码是在当前节点(Driver)中执行的
    //foreach方法是在当前节点的内存中完成数据的循环
    rdd.collect().foreach(println)

    println("*************")

    //TODO foreach为算子
    //rdd的方法称为算子
    //算子的逻辑代码是在分布式计算节点(Executor)中执行的
    //foreach算子可以将循环在不同的计算节点中完成
    //算子之外的代码在Driver端执行
    rdd.foreach(println)

    sc.stop()
  }
}
