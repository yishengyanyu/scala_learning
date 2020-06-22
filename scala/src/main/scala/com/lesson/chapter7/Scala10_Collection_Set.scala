package com.lesson.chapter7

/**
 * @author LiuJing
 * @create 2020-05-27 10:17
 */
object Scala10_Collection_Set {
  def main(args: Array[String]): Unit = {
    //Scala - set - 集
    //默认的集合是不可变集合
    //java:Set 无序,不可重复
    val set: Set[Int] = Set(1,2,3,4)

    val set1: Set[Int] = set + 5

    println(set eq set1)  //false
    println(set)
    println(set1)

    //Scala Set
    //无序:插入顺序
    //不可重复
    val set2: Set[Int] = Set(1,2,3,4,5,6,7,8)
    println(set2) //Set(5, 1, 6, 2, 7, 3, 8, 4)

    val set3: Set[Int] = Set(1,2,3,4,1,2,3,4)
    println(set3) //Set(1, 2, 3, 4)

  }
}
