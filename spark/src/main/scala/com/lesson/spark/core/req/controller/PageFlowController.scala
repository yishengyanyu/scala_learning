package com.lesson.spark.core.req.controller

import com.lesson.spark.core.req.service.PageFlowService
import com.lesson.summer.framework.core.TController

/**
 * @author LiuJing
 * @create 2020-06-10 11:14
 */
class PageFlowController extends TController{
  private val service = new PageFlowService
  override def execute(): Unit = {
    //service.analysis()
    //service.analysis1()
    service.analysis2()
  }
}
