package com.lesson.chapter4

import scala.util.control.Breaks

/**
 * @author LiuJing
 * @create 2020-05-20 10:15
 */
object Scala13_Loop8 {
  def main(args: Array[String]): Unit = {
    //Scala 循环中断
    //Scala中没有break关键字
    //Scala采用对象.方法的方式实现循环中断操作,使用抛出异常的方式中断循环
    //Scala将需要中断的循环放在一个"代码块"中
    Breaks.breakable {
      for (i <- Range(1, 5)) {
        if (i == 3) {
          //中断循环
          Breaks.break()

        }
        println("i = " + i)
      }
    }
    println("XXXX") //可以走到
  }
}
