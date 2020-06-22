package com.lesson.practice.day06

import com.lesson.practice.day06.Practice_Access.Person

/**
 * @author LiuJing
 * @create 2020-05-25 20:13
 */
object Practice_Access {
  def main(args: Array[String]): Unit = {
    var p1 = new Person
    println(p1.name)

//    println(p1.age) //权限不够

    println(p1.sex)

//    println(p1.email)

//    println(p1.tel) //权限不够
  }

  class Person{
    var name : String = _
    private var age:Int = _
    private [practice] var sex:String = _
//    private [test] var email:String = _
    protected var tel : String = _
  }
}



class User extends Person{
  def test1(): Unit ={
    var u = new User
    println(u.sex)
//    println(u.email)
    println(u.tel)
  }
}
