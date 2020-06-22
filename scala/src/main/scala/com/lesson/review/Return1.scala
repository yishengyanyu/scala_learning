package com.lesson.review

/**
 * @author LiuJing
 * @create 2020-06-21 15:33
 */
object Return1 {
  def main(args: Array[String]): Unit = {
    val array = Array(1,2,3,4,5)

    array.foreach(
      x => {
        if (x > 3) return
        println(x)
      }
    )
  }
}
