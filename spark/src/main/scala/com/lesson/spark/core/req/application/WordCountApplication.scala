package com.lesson.spark.core.req.application

import com.lesson.spark.core.req.controller.WordCountController
import com.lesson.summer.framework.core.TApplication

/**
 * @author LiuJing
 * @create 2020-06-09 14:26
 */
object WordCountApplication extends App with TApplication{
  start( "spark" ) {

    val controller = new WordCountController
    controller.execute()

  }
}
