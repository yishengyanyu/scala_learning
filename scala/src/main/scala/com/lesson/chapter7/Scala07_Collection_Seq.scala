package com.lesson.chapter7

/**
 * @author LiuJing
 * @create 2020-05-27 9:30
 */
object Scala07_Collection_Seq {
  def main(args: Array[String]): Unit = {
    //Scala - 集合 - Seq集合
    //seq - 序列 - List
    //默认情况下,Scala提供的集合都是不可变的:immutable
    //默认不可变集合List是抽象类,无法构建对象
    //如果想要构建List集合对象,可以采用apply的方式
    val list: List[Int] = List(1,2,3,4)

    //数据处理
    val list1: List[Int] = list :+ 5  //在后面加

    val list2: List[Int] = 5 +: list  //在前面加

    println(list eq list1)
    println(list) //不变的
    println(list1)  //新的集合
    println(list2)  //新的集合

    //遍历数据
    for (elem <- list2) {
      println(elem)
    }

    list1.foreach(println)
  }
}
