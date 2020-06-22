package com.lesson.chapter4

/**
 * @author LiuJing
 * @create 2020-05-20 9:07
 */
object Scala06_Loop {
  def main(args: Array[String]): Unit = {
    //循环守卫:条件
    for(i <- Range(1,5) if i!= 3){
      println("i = " + i)
    }
  }
}
