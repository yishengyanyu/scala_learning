package com.lesson.chapter1

/**
 * Scala语言是一个完全面向对象的编程语言
 * Java语言不是一个完全面向对象的编程语言
 * object : scala语言中没有静态的语法,采用object方式模仿java中的静态语法
 *          通过类名访问方法。
 * def : define缩写，表示声明方法的关键字
 *
 * scala => args: Array[String] ： 参数声明 =>  参数名:参数类型
 * 农业文明 & 工业文明
 * java => String[] args => 强类型语言 => 类型 名称
 *
 *
 * @author LiuJing
 * @create 2020-05-18 22:47
 */
object Scala01_Hello {

  //public static void main(String[] args) {
  def main(args: Array[String]): Unit = {
      System.out.println("Hello")
      println("Hello!!!")

    //访问静态方法
      test1()
      Scala01_Hello.test1()
  }

  def test1() : Unit = {
    println("test");
  }

  //语法练习
  def main() : Unit = {
    System.out.println("语法练习")
  }
}
