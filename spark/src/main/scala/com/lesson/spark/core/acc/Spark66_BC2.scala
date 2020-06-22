package com.lesson.spark.core.acc

import org.apache.spark.broadcast.Broadcast
import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
 * @author LiuJing
 * @create 2020-06-08 16:08
 */
object Spark66_BC2 {
  def main(args: Array[String]): Unit = {
    val sparkConf: SparkConf = new SparkConf().setMaster("local[*]").setAppName("acc")
    val sc = new SparkContext(sparkConf)

    //TODO 广播变量
    //广播变量:分布式共享只读变量
    //包装好之后,只能访问,不能修改

    //TODO 声明广播变量
    val rdd1: RDD[(String, Int)] = sc.makeRDD(List(("a",1),("b",2),("c",3)))
    val list = List(("a",4),("b",5),("c",6))

    val bcList: Broadcast[List[(String, Int)]] = sc.broadcast(list)

    val rdd2: RDD[(String, (Int, Int))] = rdd1.map {
      case (word, count1) => {
        var count2 = 0
        for (kv <- bcList.value) {
          val w = kv._1
          val v = kv._2
          if (w == word) {
            count2 = v
          }
        }

        (word, (count1, count2))
      }
    }
    rdd2.collect().foreach(println)

  }
}
