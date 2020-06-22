package com.lesson.chapter3

/**
 * @author LiuJing
 * @create 2020-05-19 10:44
 */
object Scala01_Operator {
  def main(args: Array[String]): Unit = {
    val a = new String("abc")
    val b = new String("abc")

    //Scala中String的 "==" 就是equals
    println(a == b)   //true
    println(a.equals(b))  //true

    //Scala中的eq用于比较字符串的类型
    println( a eq b) //false
  }
}
