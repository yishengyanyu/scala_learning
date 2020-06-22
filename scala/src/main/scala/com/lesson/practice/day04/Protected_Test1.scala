package com.lesson.practice.day04


import com.lesson.practice.day06.Practice_Access.Person

/**
 * @author LiuJing
 * @create 2020-05-25 20:49
 */
object Protected_Test1 {
  def main(args: Array[String]): Unit = {

  }
}

class SonOfPerson extends Person{
  def test1(): Unit ={
    var s = new SonOfPerson
    println(s.tel)
    println(s.sex)
//    println(s.email)
  }
}
