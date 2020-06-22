package com.lesson.spark.streaming.oper

import org.apache.spark.SparkConf
import org.apache.spark.streaming.dstream.{DStream, ReceiverInputDStream}
import org.apache.spark.streaming.{Seconds, StreamingContext}

/**
 * @author LiuJing
 * @create 2020-06-13 11:39
 */
object SparkStreaming01_WordCount {
  def main(args: Array[String]): Unit = {
    //TODO Spark环境
    //SparkStreaming使用的核数最少是2个
    val conf: SparkConf = new SparkConf().setMaster("local[2]").setAppName("Streaming")
    val ssc = new StreamingContext(conf,Seconds(3))

    //TODO 执行逻辑
    //从socket获取数据是一行一行获取的
    val socketDS: ReceiverInputDStream[String] = ssc.socketTextStream("localhost",9999)

    val wordDS: DStream[String] = socketDS.flatMap(_.split(" "))

    val wordToOneDS: DStream[(String, Int)] = wordDS.map((_,1))

    val wordToSumDS: DStream[(String, Int)] = wordToOneDS.reduceByKey(_+_)

    wordToSumDS.print()

    //TODO 关闭环境
    //Driver在Streaming处理过程中不能结束
    //采集器在正常情况下不应该停止,除非特殊情况:采集规则,采集周期要改变
    //ssc.stop()

    //启动采集器
    ssc.start()
    //等待采集器的结束
    ssc.awaitTermination()
  }
}
