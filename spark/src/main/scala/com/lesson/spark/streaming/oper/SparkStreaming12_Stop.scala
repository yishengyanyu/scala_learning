package com.lesson.spark.streaming.oper

import org.apache.spark.SparkConf
import org.apache.spark.streaming.dstream.{DStream, ReceiverInputDStream}
import org.apache.spark.streaming.{Seconds, StreamingContext, StreamingContextState}

/**
 * @author LiuJing
 * @create 2020-06-15 9:59
 */
object SparkStreaming12_Stop {
  def main(args: Array[String]): Unit = {
    val conf: SparkConf = new SparkConf().setMaster("local").setAppName("Streaming")

    val ssc = new StreamingContext(conf, Seconds(3))

    ssc.sparkContext.setCheckpointDir("checkpoint")

    //创建DS
    val ds: ReceiverInputDStream[String] = ssc.socketTextStream("localhost",9999)

    val wordToOneDS: DStream[(String, String)] = ds.map(num => ("key", num))

    wordToOneDS.print()


    ssc.start()

    //TODO 当业务升级的场合，或逻辑发生变化
    //TODO Stop方法一般不会放置在main线程完成
    //TODO 需要将stop方法使用新的线程完成调用
    new Thread(new Runnable {
      override def run()= {
        //TODO Stop方法的调用不应该是线程启动后马上调用
        //TODO Stop方法调用的时机，这个时机不容易确定，需要周期性的判断时机出否出现
        while (true) {
          Thread.sleep(10000)
          //TODO 关闭时机的判断一般不会使用业务操作
          //TODO 一般采用第三方的程序或存储进行判断
          // 例如检索HDFS => /stopSpark是否有文件
          // 使用zk
          // 使用mysql
          // 使用redis
          // 优雅地关闭
          val state: StreamingContextState = ssc.getState()
          if(state == StreamingContextState.ACTIVE){
            ssc.stop(true,true)
            System.exit(0)
          }
        }
      }
    }).start()

    //Stop (X)
    //等待采集器的结束
    ssc.awaitTermination()

    //Stop(X)

    //ssc.stop()

    // 线程
    // val t = new Thread()
    // t.start()
    // i++, long, double
    // t.stop() // 数据安全
  }
}
