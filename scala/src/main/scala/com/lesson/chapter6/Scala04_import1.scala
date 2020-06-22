package com.lesson.chapter6

/**
 * @author LiuJing
 * @create 2020-05-23 14:36
 */
object Scala04_import1 {
  def main(args: Array[String]): Unit = {
    //面向对象-import

    //导入对象
    println("zhangsan")

    //Scala可以采用import关键字导入对象,导入对象只能对val声明的对象进行导入,var不可以
    val user = new User04 //不能用var
    import user._
    test1()
    login()
  }
}

class User04{
  def test1(): Unit ={
    println("test1...")
  }

  def login(): Unit ={
  println("login...")
  }
}


