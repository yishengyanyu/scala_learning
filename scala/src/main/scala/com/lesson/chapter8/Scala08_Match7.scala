package com.lesson.chapter8

/**
 * @author LiuJing
 * @create 2020-06-01 8:43
 */
object Scala08_Match7 {
  def main(args: Array[String]): Unit = {
    val list = List(("a",1),("b",2),("c",3))

    list.map{
      case (k,v) => {
        (k,v*2)
      }
    }

  }
}
