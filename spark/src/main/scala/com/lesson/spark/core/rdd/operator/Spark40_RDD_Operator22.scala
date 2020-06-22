package com.lesson.spark.core.rdd.operator

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
 * @author LiuJing
 * @create 2020-06-20 11:51
 */
object Spark40_RDD_Operator22 {
  def main(args: Array[String]): Unit = {
    val conf: SparkConf = new SparkConf().setMaster("local[*]").setAppName("RDD-Operator")
    val sc = new SparkContext(conf)

    val rdd = sc.makeRDD(
      List(
        ("a", 1), ("a",2), ("c",3),
        ("b", 4), ("c",5), ("c",6)
      )
      ,2
    )

    //如果分区内计算规则和分区间的计算规则相同,都是求和,那么可以计算WordCount
    val result: RDD[(String, Int)] = rdd.aggregateByKey(0)(
                  (x, y) => x + y,
                  (x, y) => x + y
              )
    val result1 = rdd.aggregateByKey(0)(_+_, _+_)
    println(result1.collect().mkString(","))

    //如果分区内计算规则和分区间计算规则相同，那么可以将aggregateByKey简化为
    //另外一个方法foldByKey
    val result2: RDD[(String, Int)] = rdd.foldByKey(0)(_+_)

    // scala
    //相似的2种方法
    // List().reduce(_+_)
    // List().fold(0)(_+_)
    // spark
    //相似的2种算子
    // rdd.reduceByKey(_+_)
    // rdd.foldByKey(0)(_+_)

    sc.stop()
  }
}
