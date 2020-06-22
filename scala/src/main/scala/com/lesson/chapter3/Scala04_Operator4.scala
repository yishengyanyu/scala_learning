package com.lesson.chapter3

/**
 * @author LiuJing
 * @create 2020-05-19 15:37
 */
object Scala04_Operator4 {
  def main(args: Array[String]): Unit = {
    //Scala 是一门完全面向对象的语言
    //万物皆对象
    //数字其实是数值类型的对象
    1.to(2)
    val i = 1.+(2)
    val j = 2.-(1)
    println(i + "," + j)

    //字符串
    val str = "abc".*(2)  //字符串出现两次
    println(str)
  }
}
