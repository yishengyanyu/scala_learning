package com.lesson.spark.core.rdd.operator

import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.rdd.RDD

/**
 * @author LiuJing
 * @create 2020-06-06 10:10
 */
object Spark44_RDD_Operator26 {
  def main(args: Array[String]): Unit = {
    //TODO Spark - 算子(方法) -join
    val sparkConf = new SparkConf().setMaster("local[*]").setAppName("File-RDD")

    val sc = new SparkContext(sparkConf)

    val rdd1: RDD[(String, Int)] = sc.makeRDD(
      List(
        ("a", 1), ("b", 2), ("c", 3)
      )
    )
    val rdd2: RDD[(String, Int)] = sc.makeRDD(
      List(
        ("a", 6), ("b", 5), ("b", 4)
      )
    )

    //左外连接
    val result = rdd1.leftOuterJoin(rdd2)
    //右外连接
    val result1 = rdd1.rightOuterJoin(rdd2)

    result.collect().foreach(println)
    result1.collect().foreach(println)

    //cogroup
    //先内部连接,再外部连接
    val result2: RDD[(String, (Iterable[Int], Iterable[Int]))] = rdd1.cogroup(rdd2)

    result2.collect().foreach(println)

    sc.stop()
  }
}
