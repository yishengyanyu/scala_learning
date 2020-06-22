package com.lesson.chapter5

/**
 * @author LiuJing
 * @create 2020-05-22 14:26
 */
object Scala15_Function14 {
  def main(args: Array[String]): Unit = {
    //Scala函数式编程 : 柯里化
    def test1()={
      def fun1(): Unit ={
        println("xxxxx")
      }
      fun1 _
    }
    test1()()

    //使用函数柯里化的方式声明函数(逻辑上类似于嵌套函数)
    //所谓柯里化,其实就是一个函数有多个参数列表,即有多个()
    //1.简化嵌套函数开发
    //2.将复杂的参数逻辑简单化,可以支持更多的语法
    def test2(i:Int,j:Int,f:Int=>Int): Unit ={

    } //一个函数,一个参数列表
    test2(1,2,_ * 2)

    def test3(i:Int)(j:Int)(f:(Int,Int)=>Int)={
      println("test3...")
      f(i,j)
    }
    println(test3(1)(2)(_ + _))
  }
}
