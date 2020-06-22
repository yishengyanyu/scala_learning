package com.lesson.summer.framework.util

import org.apache.spark.streaming.{Duration,Seconds, StreamingContext}
import org.apache.spark.{SparkConf, SparkContext}


/**
 * @author LiuJing
 * @create 2020-06-09 14:14
 */
object EnvUtil {
  private val scLocal = new ThreadLocal[SparkContext]
  private val sscLocal = new ThreadLocal[StreamingContext]

  def getEnv()  = {
    // 从当前线程的共享内存空间中获取环境对象
    var sc: SparkContext = scLocal.get()
    if ( sc == null ) {
      // 如果获取不到环境对象
      val sparkConf = new SparkConf().setMaster("local").setAppName("sparkApplication")
      // 创建新的环境对象
      sc = new SparkContext(sparkConf)
      // 保存到共享内存中
      scLocal.set(sc)
    }
    sc
  }

  def getStreamingEnv(time : Duration = Seconds(3)) ={
    var ssc: StreamingContext = sscLocal.get()
    if(ssc == null){
      val conf: SparkConf = new SparkConf().setMaster("local[*]").setAppName("streaming")
      ssc = new StreamingContext(conf,time)
      sscLocal.set(ssc)
    }
    ssc
  }

  def clear(): Unit = {
    getEnv.stop()
    // 将共享内存中的数据清除掉
    scLocal.remove()
  }
}
