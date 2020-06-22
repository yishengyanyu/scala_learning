package com.lesson.spark.streaming.oper

import org.apache.spark.SparkConf
import org.apache.spark.streaming.dstream.ReceiverInputDStream
import org.apache.spark.streaming.{Seconds, StreamingContext}

/**
 * @author LiuJing
 * @create 2020-06-13 16:26
 */
object SparkStreaming08_State {
  def main(args: Array[String]): Unit = {
    val conf: SparkConf = new SparkConf().setMaster("local[2]").setAppName("Streaming")
    val ssc = new StreamingContext(conf,Seconds(3))

    ssc.sparkContext.setCheckpointDir("checkpoint")

    val ds: ReceiverInputDStream[String] = ssc.socketTextStream("localhost",9999)

    //数据有状态的保存
    //将Spark每个周期采集的数据处理结果保存起来,然后和后续的数据进行聚合

    //reduceByKey方法是无状态的,而我们需要的是有状态的数据操作

    //有状态的目的其实就是将每一个采集周期数据的计算结果临时保存起来
    //然后再一次数据的处理中可以继续使用
    ds.flatMap(_.split(" "))
      .map((_,1L))
    //Option:Some,None
    //updateStateByKey是有状态的计算方法
      //第一个参数表示:相同key的value集合
      //第二个参数表示相同key的缓冲区的数据,有可能为空

      //计算的中间结果需要保存到检查点的位置中,需要设定检查点路经
      .updateStateByKey[Long](
            (seq:Seq[Long], buffer:Option[Long]) => {
              val newBufferValue: Long = buffer.getOrElse(0L) + seq.sum
              Option(newBufferValue)
            }
          ).print()


    ssc.start
    ssc.awaitTermination()
  }
}
