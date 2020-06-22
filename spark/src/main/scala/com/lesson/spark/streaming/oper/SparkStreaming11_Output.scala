package com.lesson.spark.streaming.oper

import org.apache.spark.SparkConf
import org.apache.spark.streaming.dstream.{DStream, ReceiverInputDStream}
import org.apache.spark.streaming.{Seconds, StreamingContext}

/**
 * @author LiuJing
 * @create 2020-06-15 18:23
 */
object SparkStreaming11_Output {
  def main(args: Array[String]): Unit = {
    val conf: SparkConf = new SparkConf().setMaster("local[*]").setAppName("Streaming")
    val ssc = new StreamingContext(conf,Seconds(3))
    ssc.sparkContext.setCheckpointDir("checkpoint")

    val ds: ReceiverInputDStream[String] = ssc.socketTextStream("localhost",9999)

    val wordToOneDS: DStream[(String, Int)] = ds.map(num => ("key",num.toInt))

    //TODO reduceByKeyAndWindow方法一般用于重复数据的范围比较大的场合，这样可以优化效率
    val result: DStream[(String, Int)] = wordToOneDS.reduceByKeyAndWindow(
      (x, y) => {
        println(s"x = ${x}, y = ${y}")
        x + y
      },
      (a, b) => {
        println(s"x = ${a}, y = ${b}")
        a - b
      },
      Seconds(9)
    )

    result.print()
    //result.saveAsObjectFiles()
    //result.saveAsTextFiles()
    //result.saveAsHadoopFiles()
    result.foreachRDD(
      rdd => {
        rdd.foreach(
          data => println(data)
        )
      }
    )

    ssc.start()

    ssc.awaitTermination()
  }
}
