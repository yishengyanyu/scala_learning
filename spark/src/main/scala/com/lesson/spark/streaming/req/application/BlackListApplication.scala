package com.lesson.spark.streaming.req.application

import com.lesson.spark.streaming.req.controller.BlackListController
import com.lesson.summer.framework.core.TApplication

/**
 * @author LiuJing
 * @create 2020-06-15 21:56
 */
object BlackListApplication extends App with TApplication {
  start("sparkStreaming"){
    val controller = new BlackListController
    controller.execute()
  }
}
