package com.lesson.chapter7

/**
 * @author LiuJing
 * @create 2020-05-29 15:47
 */
object Scala32_Collection_Par {
  def main(args: Array[String]): Unit = {
//    val list = List(1,2,3)
//    list.foreach(println) //串行

    val result1 = (0 to 100).map{x => Thread.currentThread.getName}
    val result2 = (0 to 100).par.map{x => Thread.currentThread.getName}

    println(result1)
    println(result2)
  }
}
