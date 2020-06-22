package com.lesson.chapter6

/**
 * @author LiuJing
 * @create 2020-05-23 14:36
 */
object Scala19_Method_Instance1 {
  def main(args: Array[String]): Unit = {
    //Scala-面向对象-构造方法

    //Scala构造方法只有一个吗?不是
    //Scala中提供了两种不同类型的构造方法
    //1.主构造方法:在类名后的构造方法,可以完成类的初始化;
    //2.辅助构造方法:为了完成类初始化的辅助功能而提供的构造方法
    //    声明方法为:  def this()={}
    //    使用辅助构造方法时,必须直接或者间接地调用主构造方法
    //    辅助构造方法也存在重载的概念
    //    辅助构造方法间接调用主构造方法时,需要保证调用的其他辅助构造函数已经声明(有顺序)
    val user1 = new User()
    val user2 = new User("zhangsan")
    val user3 = new User("lisi",30)

    println(user1)
    println(user2)
    println(user3)

  }

  class User {
    println("xxxxx")

    def this(name:String) = {
      this()  //直接调用
      println(name)
    }

    def this(name:String,age:Int) = {
      //this()
      this(name)  //间接调用
      println(name,age)
    }
  }
}






