package com.lesson.spark.core.Practice

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
 * @author LiuJing
 * @create 2020-06-07 21:17
 */
object Practice_Operator {
  def main(args: Array[String]): Unit = {

    val sparkConf: SparkConf = new SparkConf().setMaster("local").setAppName("Memory-RDD")

    val sc = new SparkContext(sparkConf)

    //join
    val rdd1: RDD[(String, Int)] = sc.makeRDD(List(("a",1),("b",2),("c",3)))

    val rdd2: RDD[(String, Int)] = sc.makeRDD(
      List(("b", 1), ("c", 2), ("d", 3))
    )
    val rdd: RDD[(String, (Int, Int))] = rdd1.join(rdd2)

//    rdd.foreach(println)
//
//    rdd1.leftOuterJoin(rdd2).foreach(println)
//
//    rdd1.rightOuterJoin(rdd2).foreach(println)

    //cogroup
    val rdd3: RDD[(String, Int)] = sc.makeRDD(List(("a",1),("b",2),("a",2)))

    val rdd4: RDD[(String, Int)] = sc.makeRDD(
      List(("b", 1), ("c", 2), ("b", 3))
    )

//    rdd3.cogroup(rdd4).foreach(println)

    //reduce
    val rdd5: RDD[Int] = sc.makeRDD(List(1,2,3,4,3,5),3)

    println(rdd5.reduce(_ + _))

    //count
    println(rdd5.count())

    //first
    println(rdd5.first())

    //take
    rdd5.take(3).foreach(println)

    //takeOrdered
    rdd5.takeOrdered(4)(Ordering.Int.reverse).foreach(println)

    //aggregate
    println(rdd5.aggregate(10)(_ + _, _ + _))

    //fold
    println(rdd5.fold(5)(_ + _))

    //countByKey
    println(rdd3.countByKey())

    //countByValue
    println(rdd3.countByValue())

    sc.stop()
  }
}
