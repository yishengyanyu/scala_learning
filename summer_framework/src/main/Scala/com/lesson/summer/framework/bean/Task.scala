package com.lesson.summer.framework.bean

/**
 * @author LiuJing
 * @create 2020-06-09 14:13
 */
class Task extends Serializable{
  var data : Int = 0
  var logic : Int => Int  = null

  def compute() = {
    logic(data)
  }
}
