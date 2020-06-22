package com.lesson.chapter4

import scala.util.control.Breaks._
/**
 * @author LiuJing
 * @create 2020-05-20 10:26
 */
object Scala14_Loop9 {
  def main(args: Array[String]): Unit = {
    //breakable是一个方法,{}是一个参数列表
    //将一段代码作为一个参数传给一个方法
    breakable {
      for (i <- Range(1, 5)) {
        if (i == 3) {
          //中断循环
          break()
        }
        println("i = " + i)
      }
    }
    println("XXXX") //不加Breakable就走不到这一步
  }
}
