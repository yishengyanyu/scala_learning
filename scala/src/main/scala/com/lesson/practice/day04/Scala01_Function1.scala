package com.lesson.practice.day04

/**
 * @author LiuJing
 * @create 2020-05-22 20:01
 */
object Scala01_Function1 {
  def main(args: Array[String]): Unit = {
//    def test1(i: Int): Int ={
//      i * 2
//    }
//
//    def fun1()={
//      test1 _
//    }
//    println(fun1()) //com.lesson.practice.day04.Scala01_Function1$$$Lambda$5/2109957412@2d209079
//    println(fun1()(10)) //20
//
//    val a = fun1()  //为什么不写fun1()(),fun1()相当于test1 _,写fun1()()是为了求值但未传参
//    val b = fun1  //求函数fun1的内存地址值
//    val c = fun1()(3) //求函数fun1(test(3))的值
//    println(a(10))
//    println(b)  //com.lesson.practice.day04.Scala01_Function1$$$Lambda$5/2109957412@2d209079
//    println(c)  //6
//    println(fun1.toString())  //求内存地址值
//
//    val d = test1 _
//    println(d(20))
//
//    def fun2() ={
//      def test2(i: Int):Int={
//        i * 2
//      }
//      test2 _
//    }
//    println(fun2()(10))
//
//    def fun3():Int=>Int = {
//      def test3(i : Int):Int={
//        i * 2
//      }
//      test3
//    }
//    println(fun3()(5))

    //匿名函数测试
    def test4(f:Int=>Int): Unit ={
      f(20)
    }
    println(test4(_ + 10))

  }
}
