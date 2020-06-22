package com.lesson.chapter7

import scala.collection.mutable

/**
 * @author LiuJing
 * @create 2020-05-27 10:24
 */
object Scala11_Collection_Set1 {
  def main(args: Array[String]): Unit = {
    //Scala - 集合 - Set  - 集
    //可变集合
//    val set: mutable.Set[Int] = mutable.Set(1,2,3,4,5,6,7,8)
    //Set(1, 5, 2, 6, 3, 7, 4, 8)
    val set: mutable.Set[Int] = mutable.Set(1,2)
    //添加数据
    set.add(3)
    val set1: mutable.Set[Int] = set + 6  //产生新的集合
    val set2: mutable.Set[Int] = set += 7 //不会产生新的集合

    println(set eq set2)

    //修改集合
    set.update(5,true)  //是否要包含数据,true包含,false不包括

    //从集合中删除数据
    set.update(1,false)

    //删除数据
    set.remove(1)
    set - 3 //产生新的集合
    set -= 4  //不产生新的集合

    println(set)

    //字符串形式输出元素,以","间隔
    println(set.mkString(","))
  }
}
