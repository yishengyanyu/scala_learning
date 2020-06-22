package com.lesson.chapter7

import scala.collection.mutable.ListBuffer

/**
 * @author LiuJing
 * @create 2020-05-27 10:11
 */
object Scala09_Collection_Seq2 {
  def main(args: Array[String]): Unit = {
    //Scala - 集合 -Seq - 可变
    val buffer: ListBuffer[Int] = ListBuffer(1,2,3,4)

    //增加数据
    //可变集合尽量不要用符号方法
    buffer.append(5,6,7)
    buffer.insert(1,8)

    //修改
    buffer(1) = 9
    buffer.update(1,8)  //两种方法一样

    //删除数据
    buffer.remove(1)
    buffer.remove(1,3)

    //循环遍历
    buffer.foreach(println)
    for (elem <- buffer) {
      println(elem)
    }

    println(buffer.mkString(","))
  }
}
