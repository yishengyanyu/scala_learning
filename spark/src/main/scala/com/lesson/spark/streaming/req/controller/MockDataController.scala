package com.lesson.spark.streaming.req.controller

import com.lesson.spark.streaming.req.service.MockDataService
import com.lesson.summer.framework.core.TController

/**
 * @author LiuJing
 * @create 2020-06-15 19:24
 */
class MockDataController extends TController{
  override def execute(): Unit = {
    val service = new MockDataService
    service.analysis()
  }
}
