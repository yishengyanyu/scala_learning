package com.lesson.spark.core.req.application

import com.lesson.spark.core.req.controller.PageFlowController
import com.lesson.summer.framework.core.TApplication

/**
 * @author LiuJing
 * @create 2020-06-10 11:14
 */
object PageFlowApplication extends App with TApplication{
  start("spark"){
    val controller = new PageFlowController
    controller.execute()
  }
}
