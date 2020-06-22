package com.lesson.chapter7

import scala.collection.mutable.ArrayBuffer

/**
 * @author LiuJing
 * @create 2020-05-26 16:45
 */
object Scala04_Collection_Array3 {
  def main(args: Array[String]): Unit = {
    //Scala - 集合 - 数组 - 可变
    //类似于StringBuffer
    //可变,数组在mutable包中
    val array = new ArrayBuffer[String]()
    val array1 = ArrayBuffer(1,2,3,4)

    //数据的操作
    //追加数据,集合内部的元素发生改变(所以是可变数组)
    array.append("a")
    array.append("b")
    //向指定的位置(索引)插入数据
    array1.insert(1, 7,8,9)

    //对指定位置(索引)修改数据
    //array1(1) = 5 =>编译时,自动转换为update方法
    array1.update(1,5)  //不合逻辑会报错:数组下标越界

    //删除数据
    //array1.remove(2)  //删除索引1的数据
    array1.remove(1,2)  //从索引1位置开始,删除2个 不合逻辑会报错:数组下标越界

    //遍历数据
    for (s <- array) {
      println(s)
    }
    //输出
    println(array.mkString(","))
  }
}
