package com.lesson.chapter5

/**
 * @author LiuJing
 * @create 2020-05-20 11:09
 */
object Scala01_Function {
  def main(args: Array[String]): Unit = {
    //函数式编程
    //函数声明方式
    //def ==> define
    //[修饰符] def 函数名(参数列表) [:返回值类型(可有可无)] = { 函数体 }

    //函数的调用
    //函数名(参数)
    test1("张三")
  }

  //参数的声明规则 ==> 参数名:参数类型
  def test1(s : String): Unit ={
    //逻辑代码
    println(s + "xxxx")
  }
}
