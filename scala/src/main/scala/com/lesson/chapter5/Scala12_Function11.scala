package com.lesson.chapter5

/**
 * @author LiuJing
 * @create 2020-05-22 10:48
 */
object Scala12_Function11 {
  def main(args: Array[String]): Unit = {
    //函数式编程
    //将函数作为返回值使用
    //将函数的执行结果返回
    def test1(i : Int) : Int = {
      i * 2
    }

    def fun1() = {
      test1 _
    }

    //调用函数
    val a = fun1()  //当前fun1函数的执行结果为函数,那么a此时就是函数
    println(a(10))
    println(fun1()(10))

    //当函数作为返回值使用时, 一般使用嵌套函数
    def fun2() = {
      def test2(i : Int) : Int = {
        i * 2
      }

      test2 _
    }

    println(fun2()(10))

    //如果不想使用下划线返回返回对象,那么需要显式声明被返回函数的参数类型和返回值类型
    def fun3():Int => Int = {
      def test3(i : Int) : Int = {
        i * 2
      }

      test3
    }

    println(fun2()(10))
  }
}
