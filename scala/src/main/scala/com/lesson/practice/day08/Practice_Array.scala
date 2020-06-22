package com.lesson.practice.day08

import scala.collection.mutable.ArrayBuffer

/**
 * @author LiuJing
 * @create 2020-05-27 21:48
 */
object Practice_Array {
  def main(args: Array[String]): Unit = {
    //1.创建不可变数组
//    val array1: Array[Int] = Array(1, 2, 3, 4, 5)//apply
//    val array2 = new Array[String](4) //new
//    val array3 = new Array[User](5)
//
//    //2.数据操作
//    println(array1)
//    println(array2)
//    println(array3)
//
//    array2(0) = "zhangsan"
//    array2(1) = "lisi"
//
//    for (elem <- array1) {
//      println(elem)
//    }
//    array1.foreach(println(_))
//    val iterator: Iterator[Int] = array1.iterator
//    while(iterator.hasNext){
//      println(iterator.next())
//    }
//
//    println(array1.mkString("1", ",", "3"))

    //相关操作
//    val array: Array[Int] = array1.+:(6)
//    val array2: Array[Int] = array1 :+ 7
//    val array3: Array[Int] = 8 +: array1
//    println(array.mkString(","))
//    println(array2.mkString(","))
//    println(array3.mkString(","))

    //可变数组
    val buffer = ArrayBuffer[Int]()
    buffer.append(1,2,3)

    buffer(1) = 0
    buffer.update(1,4)
    buffer.insert(3,5)


//    buffer.remove(1,2)  //buffer.remove(1)

    for (elem <- buffer) {
      println(elem)
    }
    buffer.foreach(println)







  }

  class User{

  }
}
