package com.lesson.spark.core.req.service

import com.lesson.spark.core.req.dao.WordCountDao
import com.lesson.summer.framework.core.{TController, TService}
import org.apache.spark.rdd.RDD

/**
 * @author LiuJing
 * @create 2020-06-09 14:21
 */
class WordCountService extends TService{
  private val wordCountDao = new WordCountDao

  /**
   * 数据分析
   *
   * @return
   */
  override def analysis() = {
    val fileRDD: RDD[String] = wordCountDao.readFile("input/user_visit_action.txt")
    val wordRDD: RDD[String] = fileRDD.flatMap(_.split(" "))
    val mapRDD: RDD[(String, Int)] = wordRDD.map( word=>(word,1) )
    val wordToSumRDD: RDD[(String, Int)] = mapRDD.reduceByKey(_+_)
    val wordCountArray: Array[(String, Int)] = wordToSumRDD.collect()
    wordCountArray
  }
}
