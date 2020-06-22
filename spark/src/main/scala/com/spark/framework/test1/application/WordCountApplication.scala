package com.spark.framework.test1.application

import com.spark.framework.test1.controller.WordCountController1
import com.test.framework.core.TApplication1

/**
 * @author LiuJing
 * @create 2020-06-09 19:21
 */
object WordCountApplication extends App with TApplication1{
  private val controller = new WordCountController1

  start("spark"){
    controller.execute()
  }
}
