package com.lesson.spark.core.rdd.operator

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
 * @author LiuJing
 * @create 2020-06-03 14:42
 */
object Spark09_RDD_Operator {
  def main(args: Array[String]): Unit = {
    //TODO Spark - RDD - 算子(方法) - map

    //转换算子
    //能够将旧的RDD通过方法转换为新的RDD
    val sparkConf: SparkConf = new SparkConf().setMaster("local[*]").setAppName("wordCount")
    val sc = new SparkContext(sparkConf)

    val rdd: RDD[Int] = sc.makeRDD(List(1,2,3,4))

    //旧RDD => 算子 => 新RDD
//    val rdd1: RDD[Int] = rdd.map( (i:Int) => {i * 2})
//    val rdd1: RDD[Int]  = rdd.map( (i:Int) => { i * 2 } )
//    val rdd1: RDD[Int]  = rdd.map( (i:Int) => i * 2 )
//    val rdd1: RDD[Int]  = rdd.map( (i) => i * 2 )
//    val rdd1: RDD[Int]  = rdd.map( i => i * 2 )
    val rdd1: RDD[Int] = rdd.map(_*2)

    //读取数据
    //collect不会转换RDD, 会触发作业的执行
    //所以collect这样的方法称为行动(action)算子
    val array: Array[Int] = rdd1.collect()
  }
}
