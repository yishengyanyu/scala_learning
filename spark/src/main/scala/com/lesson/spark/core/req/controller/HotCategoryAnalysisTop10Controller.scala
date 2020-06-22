package com.lesson.spark.core.req.controller

import com.lesson.spark.core.req.bean
import com.lesson.spark.core.req.service.HotCategoryAnalysisTop10Service
import com.lesson.summer.framework.core.TController
import org.apache.spark.rdd.RDD

/**
 * @author LiuJing
 * @create 2020-06-09 14:30
 */
class HotCategoryAnalysisTop10Controller extends TController{

  private val service = new HotCategoryAnalysisTop10Service
  override def execute(): Unit = {
    //val array: Array[(String, (Int, Int, Int))] = service.analysis()
    //array.foreach(println)

    //val array: Array[(String, (Int, Int, Int))] = service.analysis1()
    //array.foreach(println)

    //val array: Array[(String, (Int, Int, Int))] = service.analysis2()
    //array.foreach(println)

    val array = service.analysis3()
    array.foreach(println)

    val result: List[bean.HotCategory] = service.analysis4()
    result.foreach(println)
  }
}
