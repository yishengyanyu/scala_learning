package com.lesson.chapter7

import scala.collection.mutable.ArrayBuffer

/**
 * @author LiuJing
 * @create 2020-05-26 16:40
 */
object Scala03_Collection_Array2 {
  def main(args: Array[String]): Unit = {
    //Scala - 集合 - 数组 - 可变
    //类似于StringBuffer
    //可变数组,在muttable包中
    val array = new ArrayBuffer[String]()

    //数据的操作
    //追加数据
    array.append("a")
    array.append("b")

    //遍历数据
    for (s <- array) {
      println(s)
    }
    //输出
    println(array)  //ArrayBuffer(a, b)
    println(array.mkString(","))
  }

}
