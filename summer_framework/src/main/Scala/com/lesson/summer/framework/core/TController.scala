package com.lesson.summer.framework.core

/**
 * @author LiuJing
 * @create 2020-06-09 14:18
 */
trait TController extends Serializable {
  // 执行控制
  def execute():Unit
}
