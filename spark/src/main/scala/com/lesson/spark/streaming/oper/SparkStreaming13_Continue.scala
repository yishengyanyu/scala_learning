package com.lesson.spark.streaming.oper

import org.apache.spark.SparkConf
import org.apache.spark.streaming.dstream.ReceiverInputDStream
import org.apache.spark.streaming.{Seconds, StreamingContext}

/**
 * @author LiuJing
 * @create 2020-06-15 10:33
 */
object SparkStreaming13_Continue {
  def main(args: Array[String]): Unit = {
    val ssc: StreamingContext = StreamingContext.getActiveOrCreate("checkpoint",getStreamingContext)

    ssc.start()
    ssc.awaitTermination()
  }

  def getStreamingContext():StreamingContext ={
    val conf: SparkConf = new SparkConf().setMaster("local[*]").setAppName("Streaming")

    val ssc = new StreamingContext(conf, Seconds(3))

    ssc.sparkContext.setCheckpointDir("checkpoint")

    val ds: ReceiverInputDStream[String] = ssc.socketTextStream("localhost",9999)

    ds.print()

    ssc
  }
}
