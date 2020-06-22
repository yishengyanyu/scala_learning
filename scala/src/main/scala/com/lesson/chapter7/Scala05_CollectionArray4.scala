package com.lesson.chapter7

import scala.collection.mutable
import scala.collection.mutable.ArrayBuffer

/**
 * @author LiuJing
 * @create 2020-05-26 16:55
 */
object Scala05_CollectionArray4 {
  def main(args: Array[String]): Unit = {
    //Scala
    //可变数组
    //内存存储的数据可以动态操作,而不会产生新的集合
    //可变数组提供了大量对数据操作的方法,基本上方法名都是单词

    //不可变数组
    //对数据的操作都会产生新的集合
    //提供对数据的操作方法相对来说较少,而且都是一些符号

    //StringBuilder => String
    //可变数组 <=> 可变数组
    val array = Array(1,2,3,4)

    //不可变 => 可变
    val buffer: mutable.Buffer[Int] = array.toBuffer

    val array1  = ArrayBuffer(1,2,3,4)

    val array2: Array[Int] = array1.toArray
  }
}
