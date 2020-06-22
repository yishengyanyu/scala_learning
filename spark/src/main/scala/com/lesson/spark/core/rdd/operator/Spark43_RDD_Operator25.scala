package com.lesson.spark.core.rdd.operator

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
 * @author LiuJing
 * @create 2020-06-06 9:42
 */
object Spark43_RDD_Operator25 {
  def main(args: Array[String]): Unit = {
    //TODO Spark - 算子(方法) -join
    val sparkConf = new SparkConf().setMaster("local[*]").setAppName("File-RDD")

    val sc = new SparkContext(sparkConf)


    //不论位置,都可以相连
    val rdd1: RDD[(String, Int)] = sc.makeRDD(
      List(
        ("a", 1), ("b", 2), ("a", 3)
      )
    )
    val rdd2: RDD[(String, Int)] = sc.makeRDD(
      List(
        ("a", 6), ("d", 5), ("a", 4)
      )
    )

    //join方法可以将两个RDD中相同的key的value连接在一起,只要有相同的key不管顺序,不论位置
    //如果有一方没有,则不会出现在结果中
    //数据库两张表的连接要求主键不能重复
    //有笛卡尔积
    //有shuffle操作,性能不太高
    //工作中尽量不要用
    val result: RDD[(String, (Int, Int))] = rdd1.join(rdd2)

    result.collect().foreach(println)

    sc.stop()
  }
}
