package com.lesson.chapter10

/**
 * @author LiuJing
 * @create 2020-05-30 15:42
 */
object Scala02_Transform1 {
  def main(args: Array[String]): Unit = {
    //TODO Scala - 隐式转换
    implicit def transform(d:Double): Int ={
      d.toInt
    }

    //OCP
    //编译器可以按照指定的规则进行查找,让错误的逻辑通过转换后,编译执行通过
    //这个功能称为隐式转换
    //这里的隐式转换其实就是让编译器查找转换规则
    //如果想要编译器可以查找到转换规则,那么需要使用特殊的关键字:implicit
    //这里的隐式转换其实就是类型的转换: A => B

    //TODO 隐式转换的作用
    //1.程序因为意外情况,导致正确的逻辑出现错误.(例如jar包升级)
    //2.扩展功能

    //OCP
    val i:Int = transform(2.0)
    val ii:Int = 2.0.toInt
    val iii:Int = 2.0
  }
}
