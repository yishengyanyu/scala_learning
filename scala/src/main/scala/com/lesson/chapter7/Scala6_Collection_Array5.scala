package com.lesson.chapter7

import scala.collection.mutable.ArrayBuffer

/**
 * @author LiuJing
 * @create 2020-05-27 9:07
 */
object Scala6_Collection_Array5 {
  def main(args: Array[String]): Unit = {

    // foreach
    // 循环遍历
    val array1 = Array(1,2,3,4)

    def fun(i:Int): Unit = {
        println(i)
    }
    array1.foreach(fun)
    array1.foreach((i:Int)=>{println(i)})
    // 至简原则
    array1.foreach((i:Int)=>println(i))
    array1.foreach((i)=>println(i))
    array1.foreach(i=>println(i))
    array1.foreach(println(_))
    array1.foreach(println)

    val array2 = TestArray(1,2,3,4)

    def fun1( i:Int ): Unit = {
        println(i)
    }

    array2.foreach(fun1)

    var myMatrix = Array.ofDim[Int](3,3)
    myMatrix.foreach(list=>list.foreach(println))

    val arr1 = Array(1,2,3,4)
    val arr2 = Array(5,6,7,8)

    val arr6: Array[Int] = Array.concat(arr1, arr2)
    println(arr6.mkString(","))

    val arr7: Array[Int] = Array.range(1,5)
    println(arr7.mkString(","))

    val arr8:Array[Int] = Array.fill[Int](5)(-1)
    println(arr8.mkString(","))
  }
  class TestArray {
    val buffer = new ArrayBuffer[Int]()
    def foreach( f : Int => Unit ): Unit = {
      for ( i <- buffer ) {
        f(i)
      }
    }
  }
  object TestArray {
    def apply(is:Int*) = {
      val array = new TestArray()
      for ( i <- is ) {
        array.buffer.append(i)
      }
      array
    }


  }
}
