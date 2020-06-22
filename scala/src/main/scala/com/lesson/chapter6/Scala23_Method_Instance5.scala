package com.lesson.chapter6

/**
 * @author LiuJing
 * @create 2020-05-23 14:36
 */
object Scala23_Method_Instance5 {
  def main(args: Array[String]): Unit = {
    //Scala-面向对象-构造方法-构造顺序

    //先构造父类,再构造子类
    val user = new User("wangwu")

  }


  class Person(name:String){
    println("AAAA")
    def this()={
      this("zhangsan")
      println("BBBB")
    }
  }

  class User extends Person("zhangsan"){
    println("CCCC")
    def this(name:String)={
      this()
      println("DDDD")
    }
  }

  class Emp(name:String) extends Person(name){
    println("Emp...")
  }
}






