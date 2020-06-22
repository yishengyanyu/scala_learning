package com.lesson.spark.core.req.application

import com.lesson.spark.core.req.controller.HotCategorySessionAnalysisTop10Controller
import com.lesson.summer.framework.core.TApplication

/**
 * @author LiuJing
 * @create 2020-06-20 15:52
 */
object HotCategorySessionAnalysisTop10Application extends App with TApplication {
  start("spark") {
    val controller = new HotCategorySessionAnalysisTop10Controller
    controller.execute()
  }
}
