package com.lesson.chapter7

/**
 * @author LiuJing
 * @create 2020-05-27 14:13
 */
object Scala18_Collection_Method1 {
  def main(args: Array[String]): Unit = {
    //Scala-集合-常用方法2
//    val list = List(1,2,3,4,5)
//    //函数式编程最多的算法其实就是递归算法
//
//    //获取集合的头
//    println(list.head)  //1
//
//    //获取集合的尾(除了头就是尾)
//    //尾 -> 尾 -> 尾
//    println(list.tail)  //List(2, 3, 4, 5)
//    println(list.tail.tail.tail.tail) //List(5)
//
//    //最后一个
//    println(list.last)  //5
//
//    //除了最后一个的部分,初始
//    println(list.init)  //List(1, 2, 3, 4)
//
//    //反转
//    println(list.reverse) //List(5, 4, 3, 2, 1)
//    println(list.reverse.head)  //5
//
//    //判断数据是否存在
//    println(list.contains(6)) //false

//    val list = List(1,2,3,4,1,2,3,4)
//    //数据去重
//    println(list.toSet) //Set(1, 2, 3, 4)
//
//    println(list.distinct)  //List(1,2,3,4)

    val list = List(1,2,3,4)
    //取数据
    println(list.take(3))  //List(1, 2, 3),取前三条数据
    //从右边拿数据
    println(list.takeRight(3))  //List(2, 3, 4),从右边取三个

    //丢弃数据,把左边的N条数据丢弃
    println(list.drop(2)) //List(3, 4)
    //从右边丢弃数据
    println(list.dropRight(2))  //List(1,2)

  }
}
