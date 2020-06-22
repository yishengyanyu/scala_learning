package com.lesson.spark.core.req.application

import com.lesson.spark.core.req.controller.{HotCategoryAnalysisTop10Controller, WordCountController}
import com.lesson.summer.framework.core.TApplication

/**
 * @author LiuJing
 * @create 2020-06-09 14:28
 */
object HotCategoryAnalysisTop10Application extends App with TApplication{

  start("spark"){
    val controller = new HotCategoryAnalysisTop10Controller
    controller.execute()
  }
}
