package com.lesson.chapter6

/**
 * @author LiuJing
 * @create 2020-05-26 15:36
 */
object Scala38_Object {
  def main(args: Array[String]): Unit = {
    println(Color.RED)
    println(Color.RED.id)
  }
}

object Color extends Enumeration {
  val RED = Value(1, "red")
  val YELLOW = Value(2, "yellow")
  val BLUE = Value(3, "blue")
}

