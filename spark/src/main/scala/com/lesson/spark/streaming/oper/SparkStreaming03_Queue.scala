package com.lesson.spark.streaming.oper

import org.apache.spark.SparkConf
import org.apache.spark.rdd.RDD
import org.apache.spark.streaming.dstream.InputDStream
import org.apache.spark.streaming.{Seconds, StreamingContext}

import scala.collection.mutable

/**
 * @author LiuJing
 * @create 2020-06-13 14:35
 */
object SparkStreaming03_Queue {
  def main(args: Array[String]): Unit = {
    //1.初始化Spark配置信息
    val conf: SparkConf = new SparkConf().setMaster("local[2]").setAppName("Streaming")

    //2.初始化SparkStreamingContext
    val ssc = new StreamingContext(conf,Seconds(3))

    //3.创建RDD队列
    val queue = new mutable.Queue[RDD[String]]()

    //4.创建QueueInputDStream
    val queueDS: InputDStream[String] = ssc.queueStream(queue)

    //5.打印队列中的RDD数据
    queueDS.print()

    //6.启动任务
    ssc.start()

    for ( i <- 1 to 5 ) {
      //7.循环创建并向RDD队列中放入RDD
      val rdd = ssc.sparkContext.makeRDD(List(i.toString))
      queue.enqueue(rdd)
      Thread.sleep(1000)
    }

    ssc.awaitTermination()
  }
}
