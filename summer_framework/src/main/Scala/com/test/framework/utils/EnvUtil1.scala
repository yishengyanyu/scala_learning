package com.test.framework.utils

import org.apache.spark.{SparkConf, SparkContext}

/**
 * @author LiuJing
 * @create 2020-06-09 19:03
 */
object EnvUtil1 {
  private val scLocal = new ThreadLocal[SparkContext]

  def getEnv() ={
    //从当前线程的共享空间中获取对象
    var sc: SparkContext = scLocal.get()
    //如果获取不到sc对象
    if(sc == null){
      val sparkConf: SparkConf = new SparkConf().setMaster("local[*]").setAppName("WordCount")
      sc = new SparkContext(sparkConf)
      //获取之后保存到内存中
      scLocal.set(sc)
    }
    sc
  }

  def clear()={
    scLocal.remove()
  }
}
