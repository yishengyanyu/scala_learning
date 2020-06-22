package com.lesson.chapter3

import com.lesson.chapter3.User
/**
 * @author LiuJing
 * @create 2020-05-19 11:20
 */
object Scala02_Operator1 {
  def main(args: Array[String]): Unit = {
    val user1 = new User
    val user2 = new User

    println(user1 == user2)
    println(user1.equals(user2))
    println(user1 eq user2)

    //Scala中一般用于比较内存地址
    //而 == 比较内容,并且增加了非空判断
  }
}
