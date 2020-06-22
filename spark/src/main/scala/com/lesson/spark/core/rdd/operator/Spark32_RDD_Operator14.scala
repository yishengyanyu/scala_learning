package com.lesson.spark.core.rdd.operator

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
 * @author LiuJing
 * @create 2020-06-05 11:07
 */
object Spark32_RDD_Operator14 {
  def main(args: Array[String]): Unit = {
    val sparkConf = new SparkConf().setMaster("local[*]").setAppName("File-RDD")

    val sc = new SparkContext(sparkConf)

    val rdd: RDD[Int] = sc.makeRDD(List(1,4,3,2))

    //TODO sortBy
    //默认排序规则为升序
    //sortBy可以通过传递第二个参数改变排序方式
    //sortBy可以设定第三个参数改变分区
    val sortRDD: RDD[Int] = rdd.sortBy(num => num,false)

    println(sortRDD.collect().mkString(","))

    sc.stop()
  }
}
