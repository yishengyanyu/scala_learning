package com.lesson.spark.core.req.controller

import com.lesson.spark.core.req.bean
import com.lesson.spark.core.req.service.{HotCategoryAnalysisTop10Service, HotCategorySessionAnalysisTop10Service}
import com.lesson.summer.framework.core.TController

/**
 * @author LiuJing
 * @create 2020-06-20 15:53
 */
class HotCategorySessionAnalysisTop10Controller extends TController{
  private val service1 = new HotCategoryAnalysisTop10Service
  private val service = new HotCategorySessionAnalysisTop10Service
  override def execute(): Unit = {
    val list: List[bean.HotCategory] = service1.analysis4()
    val array: Array[(String, List[(String, Int)])] = service.analysis(list)
    array.foreach(println)
  }
}
