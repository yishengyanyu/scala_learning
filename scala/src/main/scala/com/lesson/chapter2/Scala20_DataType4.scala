package com.lesson.chapter2

/**
 * @author LiuJing
 * @create 2020-05-19 10:27
 */
object Scala20_DataType4 {
  def main(args: Array[String]): Unit = {
    //常量运算在编译的时候即可运行
    var c : Char = 'A' + 1//报错, 但是可以运行
    println(c)

    //var cc : Char= c + 1//编译不通过, 有变量参与运算, +会提升数据类型(编译器做的)
    //println(cc)
  }
}
