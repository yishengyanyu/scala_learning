package com.lesson.practice.day07

/**
 * @author LiuJing
 * @create 2020-05-26 23:04
 */
object Practice_Object1 {
  def main(args: Array[String]): Unit = {
    println(Color.RED.id)

  }
}

object Color extends Enumeration{
  val RED = Value(1,"red")
  val BULE = Value(2,"blue")
  val Yellow = Value(3,"yellow")
  val WHITE = Value(4,"white")
}

object Test_Use extends App {
  println("AAAA")
  println("BBBB")
}
