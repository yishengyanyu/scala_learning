package com.lesson.practice.day10

/**
 * @author LiuJing
 * @create 2020-05-31 19:53
 */
object Practice_Exception {
  def main(args: Array[String]): Unit = {
    val a = 10
    val b = 0
    try {
      val c = a / b
    } catch {
      case e:NullPointerException => println("NullPointerException...")
      case e:ArithmeticException => println("ArithmeticException...")
      case e:Exception => println("Exception...")
    } finally {
      println("hello")
    }
  }
}

class User1{
  @throws [Exception]
  def test(): Unit ={
    println("123")
    throw new ArithmeticException("Exception...")
  }
}
