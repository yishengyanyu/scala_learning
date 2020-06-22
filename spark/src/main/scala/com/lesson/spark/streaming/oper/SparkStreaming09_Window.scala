package com.lesson.spark.streaming.oper

import org.apache.spark.SparkConf
import org.apache.spark.streaming.dstream.{DStream, ReceiverInputDStream}
import org.apache.spark.streaming.{Seconds, StreamingContext}

/**
 * @author LiuJing
 * @create 2020-06-13 16:45
 */
object SparkStreaming09_Window {
  def main(args: Array[String]): Unit = {
    val conf: SparkConf = new SparkConf().setMaster("local[2]").setAppName("Streaming")
    val ssc = new StreamingContext(conf,Seconds(3))

    val ds: ReceiverInputDStream[String] = ssc.socketTextStream("localhost",9999)

    val wordDS: DStream[String] = ds.flatMap(_.split("_"))

    val wordToOneDS: DStream[(String, Int)] = wordDS.map((_,1))

    //TODO 将多个采集周期作为计算的整体
    //默认滑动幅度(步长)为一个采集周期
    //val windowDS: DStream[(String, Int)] = wordToOneDS.window(Seconds(9))
    //窗口的范围应该是采集周期的整数倍
    //窗口的计算周期等同于窗口滑动的步长
    //窗口的范围大小和滑动的步长应该都是采集周期的整数倍
    val windowDS: DStream[(String, Int)] = wordToOneDS.window(Seconds(9),Seconds(6))

    val result: DStream[(String, Int)] = windowDS.reduceByKey(_+_)

    result.print()

    ssc.start()
    ssc.awaitTermination()
  }
}
