package com.lesson.chapter7

/**
 * @author LiuJing
 * @create 2020-05-27 14:04
 */
object Scala17_Collection_Method {
  def main(args: Array[String]): Unit = {
    //Scala-集合-常用方法1
    val list = List(1,2,3,4)

    //获取集合的长度
    println(list.length)  //4
    println(list.size)  //4

    //遍历数据
    list.foreach(println)
    println(list.mkString(","))
    val iterator: Iterator[Int] = list.iterator
    while(iterator.hasNext){
      println(iterator.next())
    }

    //判断是否为空
    println(list.isEmpty)

    //简单的运算
    println(list.sum) //10,集合元素求和
    println(list.max)
    println(list.min)
    //求乘积
    println(list.product)

  }
}
