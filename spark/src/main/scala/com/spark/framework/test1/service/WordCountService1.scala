package com.spark.framework.test1.service

import com.spark.framework.test1.dao.WordCountDao1
import com.test.framework.core.TService1
import org.apache.spark.rdd.RDD

/**
 * @author LiuJing
 * @create 2020-06-09 19:24
 */
class WordCountService1 extends TService1{
  private val dao = new WordCountDao1

  /**
   * 数据分析
   *
   * @return
   */
  override def analysis()= {
    val rdd: RDD[String] = dao.readFile("input/word.txt")

    val result: RDD[(String, Int)] = rdd.flatMap(_.split(" "))
      .map((_, 1))
      .groupByKey()
      .map(kv => (kv._1, kv._2.size))

    result
  }
}
