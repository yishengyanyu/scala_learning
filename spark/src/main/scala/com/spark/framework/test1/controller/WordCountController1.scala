package com.spark.framework.test1.controller

import com.spark.framework.test1.service.WordCountService1
import com.test.framework.core.TController1
import org.apache.spark.rdd.RDD

/**
 * @author LiuJing
 * @create 2020-06-09 19:22
 */
class WordCountController1 extends TController1{
  private val service = new WordCountService1

  /**
   * 执行程序
   */
  override def execute(): Unit = {
    val rdd: RDD[(String, Int)] = service.analysis()
    println(rdd.collect().mkString(","))
  }
}
