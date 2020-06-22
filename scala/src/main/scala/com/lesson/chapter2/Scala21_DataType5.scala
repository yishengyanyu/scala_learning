package com.lesson.chapter2

/**
 * @author LiuJing
 * @create 2020-05-19 10:36
 */
object Scala21_DataType5 {
  def main(args: Array[String]): Unit = {
    //Scala  字符串
    val i : Int = 10

    val s : String = i.toString
    val ss  = i + ""
    println(s + "\t" + ss)
  }
}
