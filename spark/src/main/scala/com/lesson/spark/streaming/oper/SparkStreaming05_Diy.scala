package com.lesson.spark.streaming.oper

import java.io.{BufferedReader, InputStreamReader}
import java.net.Socket

import org.apache.spark.SparkConf
import org.apache.spark.storage.StorageLevel
import org.apache.spark.streaming.dstream.ReceiverInputDStream
import org.apache.spark.streaming.receiver.Receiver
import org.apache.spark.streaming.{Seconds, StreamingContext}

/**
 * @author LiuJing
 * @create 2020-06-13 14:47
 */
object SparkStreaming05_Diy {
  def main(args: Array[String]): Unit = {
    val conf: SparkConf = new SparkConf().setMaster("local[2]").setAppName("Streaming")
    val ssc = new StreamingContext(conf,Seconds(3))

    //TODO 执行逻辑
    val ds: ReceiverInputDStream[String] = ssc.receiverStream(new MyReceiver("localhost",9999))

    ds.print()

    ssc.start()
    ssc.awaitTermination()

  }
  //TODO 自定义数据采集器
  //1.继承Receiver,定义泛型
  //  Receiver的构造方法有参数,在继承时应该传递这个参数
  //2.重写方法
  //  onStart
  //  onStop
  class MyReceiver(host:String,port:Int) extends Receiver[String](StorageLevel.MEMORY_ONLY){

    private var socket: Socket = _

    def receive()={
      val reader = new BufferedReader(
        new InputStreamReader(
          socket.getInputStream,"UTF-8")
      )

      var s:String = null

      while(true){
        s = reader.readLine()
        if(s != null) {
          //TODO 将获取的数据保存到框架内部进行封装
          store(s + "liujing")
        }
      }
    }

    override def onStart(): Unit = {
      socket = new Socket(host, port)
      new Thread("Socket Receiver") {
        setDaemon(true)
        override def run() { receive() }
      }.start()
    }

    new Thread("Socket Receiver") {
      setDaemon(true)
      override def run() { receive() }
    }.start()

    override def onStop(): Unit = {
      socket.close()
      socket = null
    }
  }
}
