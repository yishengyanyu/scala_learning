package com.lesson.chapter5

/**
 * @author LiuJing
 * @create 2020-05-20 11:17
 */
object Scala02_Function1 {
  def main(args: Array[String]): Unit = {
    //Scala 函数和方法的区别
    //方法的概念来自于Java
    //函数的概念来自于Scala
    //Scala也是完全函数式编程语言.其实方法其实就是函数
    //一般情况下,将类中封装的功能函数称为方法
    //其他地方封装的功能就称为函数了
    //函数可以声明在任意地方,同时也可以嵌套声明使用
    //类中的函数就是方法,符合Java的语法规则:重写&重载
    //函数没有重写和重载的概念
    def test1(): Unit ={
      println("XXXX")
      def test2(): Unit ={
        println("test2...")
      }
    }

//    def test1(s:String): Unit ={
//      println("XXXX")
//    }

    test1()
    test1()
    test1()
  }

  def test2(): Unit ={
    println("XXXX")
  }

  def test2(s:String): Unit ={
    println("XXXX")
  }
}
