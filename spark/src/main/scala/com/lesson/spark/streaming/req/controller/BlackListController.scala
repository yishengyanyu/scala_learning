package com.lesson.spark.streaming.req.controller

import com.lesson.spark.streaming.req.service.BlackListService
import com.lesson.summer.framework.core.TController

/**
 * @author LiuJing
 * @create 2020-06-15 21:58
 */
class BlackListController extends TController{
  private val service = new BlackListService
  override def execute(): Unit = {
    service.analysis()
  }
}
