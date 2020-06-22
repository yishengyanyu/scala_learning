package com.lesson.spark.streaming.req.service

import com.lesson.spark.streaming.req.dao.MockDataDao
import com.lesson.summer.framework.core.TService

/**
 * @author LiuJing
 * @create 2020-06-15 19:25
 */
class MockDataService extends TService{
  private val dao = new MockDataDao
  /**
   * 数据分析
   *
   * @return
   */
  override def analysis() = {
    //TODO 生成模拟数据
    //import mockDataDao._
    val datas: Seq[String] = dao.getMockData()
    //val a = Seq("a")

    //TODO 向Kafka中发送数据
    dao.writeToKafka(datas)
  }
}
