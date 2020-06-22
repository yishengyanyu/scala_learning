package com.lesson.chapter5

import scala.util.control.Breaks._

/**
 * @author LiuJing
 * @create 2020-05-22 14:26
 */
object Scala16_Function15 {
  def main(args: Array[String]): Unit = {
    //Scala 函数式编程 -控制抽象
    // breakable是一个函数
    // 参数列表中如果有多行逻辑，可以采用大括号代替
    // scala支持将代码逻辑作为参数传递给函数使用
    // 如果函数参数想要传递代码逻辑，那么类型声明的方式应该为：
    // 参数名： => 返回值类型（Unit）
    // 因为参数类型中没有声明小括号，所以调用时，也不能加小括号,如下:op的位置

    //def breakable(op : => scala.Unit) : scala.Unit = { /* compiled code */ }
    breakable{
      for ( i <- 1 to 5 ) {
        if ( i == 3 ) {
          // 抛出异常
          //def break() : scala.Nothing = { /* compiled code */ }
          break
        }
        println("i = " + i)
      }
    }

    //调用
    test({"1234"})

    def fun:String={
      "zhangsan"
    }
    test(fun)
  }

  def test( f: =>String ): Unit = {
    println(f)  //不能写成f()
  }
}
