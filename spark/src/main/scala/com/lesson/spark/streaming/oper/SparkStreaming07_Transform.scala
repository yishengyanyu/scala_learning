package com.lesson.spark.streaming.oper

import org.apache.spark.SparkConf
import org.apache.spark.streaming.{Seconds, StreamingContext}
import org.apache.spark.streaming.dstream.{DStream, ReceiverInputDStream}

/**
 * @author LiuJing
 * @create 2020-06-13 15:51
 */
object SparkStreaming07_Transform {
  def main(args: Array[String]): Unit = {
    val conf: SparkConf = new SparkConf().setMaster("local[2]").setAppName("Streaming")
    val ssc = new StreamingContext(conf,Seconds(3))

    val ds: ReceiverInputDStream[String] = ssc.socketTextStream("localhost",9999)

    //TODO 转换
    //此处代码在Driver中执行,只执行一次
    //例如:
    println("xxxx") //只执行一次,在main线程中执行
    val newDS: DStream[String] = ds.transform(rdd => {
      //此处代码在Driver中执行,执行N次, 周期性执行(原因:不断采集数据并计算)
      rdd.map(
        data => {
          //此处代码在Executor中执行,执行N次
          data * 2
        }
      )
    })

    val newDS1: DStream[String] = ds.map(
      data => {
        //此处代码在Executor执行N次
        data * 2
      }
    )

    newDS.print()

    ssc.start
    ssc.awaitTermination()
  }
}
