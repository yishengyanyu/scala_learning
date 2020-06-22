package com.lesson.spark.core.req.controller

import com.lesson.spark.core.req.service.WordCountService
import com.lesson.summer.framework.core.TController

/**
 * @author LiuJing
 * @create 2020-06-09 14:24
 */
class WordCountController extends TController{

  private val wordCountService = new WordCountService

  override def execute(): Unit = {
    val wordCountArray: Array[(String, Int)] = wordCountService.analysis()
    println(wordCountArray.mkString(","))
  }
}
