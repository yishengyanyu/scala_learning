package com.lesson.spark.core.req.dao

import com.lesson.spark.core.req.bean.UserVisitAction
import com.lesson.summer.framework.core.TDao
import com.lesson.summer.framework.util.EnvUtil
import org.apache.spark.rdd.RDD

/**
 * @author LiuJing
 * @create 2020-06-10 11:14
 */
class PageFlowDao extends TDao{
  override def readFile(path: String): RDD[String] = {
    EnvUtil.getEnv().textFile(path)
  }

  def getUserVisitAction( path:String ) = {
    val rdd: RDD[String] = readFile(path)
    rdd.map(
      line => {
        val datas = line.split("_")
        UserVisitAction(
          datas(0),
          datas(1).toLong,
          datas(2),
          datas(3).toLong,
          datas(4),
          datas(5),
          datas(6).toLong,
          datas(7).toLong,
          datas(8),
          datas(9),
          datas(10),
          datas(11),
          datas(12).toLong
        )
      }
    )
  }

}
