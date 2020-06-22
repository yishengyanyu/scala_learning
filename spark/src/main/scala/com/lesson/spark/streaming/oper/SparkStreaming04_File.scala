package com.lesson.spark.streaming.oper

import org.apache.spark.SparkConf
import org.apache.spark.streaming.dstream.DStream
import org.apache.spark.streaming.{Seconds, StreamingContext}

/**
 * @author LiuJing
 * @create 2020-06-13 14:41
 */
object SparkStreaming04_File {
  def main(args: Array[String]): Unit = {
    val conf: SparkConf = new SparkConf().setMaster("local[*]").setAppName("Streaming")
    val ssc = new StreamingContext(conf,Seconds(10))

    //TODO 执行逻辑
    //无法识别旧的文件
    val dirDS: DStream[String] = ssc.textFileStream("in")

    dirDS.print()

    ssc.start()
    ssc.awaitTermination()
  }
}
