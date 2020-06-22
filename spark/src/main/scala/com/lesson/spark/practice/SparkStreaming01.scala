package com.lesson.spark.practice

import org.apache.spark.SparkConf
import org.apache.spark.streaming.{Seconds, StreamingContext}

/**
 * @author LiuJing
 * @create 2020-06-14 19:40
 */
object SparkStreaming01 {
  def main(args: Array[String]): Unit = {
    val conf: SparkConf = new SparkConf().setMaster("local[*]").setAppName("Practice1")

    val ssc = new StreamingContext(conf,Seconds(3))


  }
}
