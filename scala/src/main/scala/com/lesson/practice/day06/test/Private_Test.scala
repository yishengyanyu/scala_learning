package com.lesson.practice.day06.test


import com.lesson.practice.day06.Practice_Access.Person

/**
 * @author LiuJing
 * @create 2020-05-25 20:21
 */
object Private_Test {
  def main(args: Array[String]): Unit = {
    var p1 = new Person
//    println(p1.email)
    println(p1.sex)
  }
}

class SubPerson extends Person{
  def test1(): Unit ={
    var s = new SubPerson
//    println(s.email)
    println(s.sex)
    println(s.tel)  //不同包的子类可以访问Protected修饰的属性/方法
  }
}
