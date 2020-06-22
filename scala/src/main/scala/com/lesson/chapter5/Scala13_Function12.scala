package com.lesson.chapter5

/**
 * @author LiuJing
 * @create 2020-05-22 11:25
 */
object Scala13_Function12 {
  def main(args: Array[String]): Unit = {

    //函数式编程
    //java -> method -> 压栈 -> 栈帧 -> 弹栈
    //函数在使用外部变量时,如果外部变量失效时,会将这个变量包含到当前的函数内部,
    //形成闭合的效果,改变变量的生命周期
    //将这种操作称为closure(闭包)
    //1.Scala2.12版本中,反编译后,发现编译器重新声明了内部函数的参数,将使用外部变量作为内部函数的参数使用
    //2.早期Scala版本(2.11),闭包会被编译成匿名函数类
    //3.早期的Scala版本(2.11),即使没有使用外部变量,也会有闭包的效果,只是没有包含外部变量
    //4.Spark如何判断闭包:判断类名中是否为匿名函数类
    //5.匿名函数肯定为闭包,将函数赋值给变量使用也是闭包,嵌套函数的使用(使用内部函数)会用 闭包
    def test1(i:Int)={
      def sum(j : Int)={
        i + j
      }
      sum _
    }

    def test2(i :Int)={
      def sum(j : Int)={
        j
      }
      sum _
    } //该种写法sum没有使用外部变量i,在Scala2.11中仍然会有闭包效果
    println(test1(10)(20))
    println(test2(1)(2))
  }
}
