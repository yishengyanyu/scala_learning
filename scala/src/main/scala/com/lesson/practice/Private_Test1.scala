package com.lesson.practice

import com.lesson.practice.day06.Practice_Access.Person

/**
 * @author LiuJing
 * @create 2020-05-25 20:31
 */
object Private_Test2 {
  def main(args: Array[String]): Unit = {

  }
}

class SPerson extends  Person {
  def test1(): Unit ={
    var s = new SPerson
    println(s.sex)
//    println(s.email)
    println(s.tel)
  }
}