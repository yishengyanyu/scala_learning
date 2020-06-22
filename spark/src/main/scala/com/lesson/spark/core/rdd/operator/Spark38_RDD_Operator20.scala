package com.lesson.spark.core.rdd.operator

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
 * @author LiuJing
 * @create 2020-06-05 14:50
 */
object Spark38_RDD_Operator20 {
  def main(args: Array[String]): Unit = {

    //TODO Spark - RDD - 算子

    val sparkConf = new SparkConf().setMaster("local[*]").setAppName("File-RDD")

    val sc = new SparkContext(sparkConf)

    val rdd: RDD[(String, Int)] = sc.makeRDD(
      List(("hello", 1), ("scala", 2), ("hello", 3))
    )

    //TODO groupByKey: 根据数据的key进行分组
    //groupBy: 根据指定的规则对数据进行分组

    //TODO 调用groupByKey后,返回数据的类型为元组
    //  元组的第一个元素表示的是用于分组的key
    //  元组的第二个元素表示的是分组后,相同的key的value集合
    val wordToCount: RDD[(String, Int)] = rdd.groupByKey().map {
      case (word, iter) => {
        (word, iter.sum)
      }
    }
    println(wordToCount.collect().mkString(","))

    sc.stop()
  }
}
