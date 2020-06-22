package com.lesson.chapter5

/**
 * @author LiuJing
 * @create 2020-05-22 14:26
 */
object Scala14_Function13 {
  def main(args: Array[String]): Unit = {
    //函数式编程 : 将函数作为返回值
    //1.并不是所有的函数使用外部变量的场合都成为闭包
    //例如:如下场合(变量a没有改变生命周期)
    val a = "abcd"
    def test1(): Unit ={
      val b = a * 2
      println(b)
    }
    //在Scala2.11版本中scalac处理后直接看文件名,是否含有anonfun
    test1() //不是闭包,反编译后看该方法执行时是否重新声明(final)使用的外部变量

    val c = test1 _
    c() //是闭包


    def test2(f:Int=>Int)={
      f(20)
    }
    println(test2(_ * 5)) //是闭包

  }
}
