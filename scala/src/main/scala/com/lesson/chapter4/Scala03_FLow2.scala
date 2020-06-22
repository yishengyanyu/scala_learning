package com.lesson.chapter4

/**
 * @author LiuJing
 * @create 2020-05-19 16:14
 */
object Scala03_FLow2 {
  def main(args: Array[String]): Unit = {
    //
    val age = 30
    val result = if (age < 40) {
      20
    }
    println(result) //AnyVal类型

    val result1 = if (age < 40) {
      "青年"
      20
    }
    println(result1) //AnyVal类型

    val result2 = if (age < 40) {
      "青年"
      20
    } else {
      "1234"
      12.5
      throw new Exception
    }
    println(result2) //Int类型

    val result3 = if (age < 40) {
      "青年"
      20
    } else {
      throw new Exception
    }
    println(result3) //Int类型
  }
}
