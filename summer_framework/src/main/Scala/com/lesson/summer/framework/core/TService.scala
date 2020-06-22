package com.lesson.summer.framework.core

import java.text.SimpleDateFormat

/**
 * @author LiuJing
 * @create 2020-06-09 14:19
 */
trait TService extends Serializable {
  /**
   * 数据分析
   * @return
   */
  def analysis():Any = {

  }

  def analysis(data:Any):Any = {

  }

  def analysis1():Any = {

  }

  def analysis2():Any = {

  }

  def analysis3():Any = {

  }

  def analysis4():Any = {

  }

  def timeTransfer(s:String) ={
    val format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
    format.parse(s).getTime
  }
}
