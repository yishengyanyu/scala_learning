package com.lesson.spark.streaming.oper

import org.apache.spark.SparkConf
import org.apache.spark.streaming.dstream.{DStream, ReceiverInputDStream}
import org.apache.spark.streaming.{Seconds, StreamingContext}

/**
 * @author LiuJing
 * @create 2020-06-15 17:49
 */
object SparkStreaming10_Window1 {
  def main(args: Array[String]): Unit = {
    val conf: SparkConf = new SparkConf().setMaster("local[*]").setAppName("Streaming")
    val ssc = new StreamingContext(conf,Seconds(3))
    ssc.sparkContext.setCheckpointDir("checkpoint")

    val ds: ReceiverInputDStream[String] = ssc.socketTextStream("localhost",9999)

    //TODO 窗口

    val wordToOneDS: DStream[(String, Int)] = ds.map( num => ("key",num.toInt) )

    //TODO reduceByKeyAndWindow方法一般用于重复数据的范围比较大的场合，这样可以优化效率
    val result: DStream[(String, Int)] = wordToOneDS.reduceByKeyAndWindow(
      (x, y) => {
        println(s"x = $x, y = $y")
        x + y
      },
      (a, b) => {
        println(s"a = $a, a = $a")
        a - b
      },
      Seconds(9)
    )

    result.foreachRDD(rdd => rdd.foreach(println) )

    ssc.start()

    ssc.awaitTermination()

  }
}
