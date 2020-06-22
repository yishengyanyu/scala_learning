package com.lesson.spark.streaming.req.application

import com.lesson.spark.streaming.req.controller.MockDataController
import com.lesson.summer.framework.core.TApplication


/**
 * @author LiuJing
 * @create 2020-06-15 19:22
 */
object MockDataApplication extends App with TApplication{
  start("sparkStreaming"){
    val controller = new MockDataController
    controller.execute()
  }
}
