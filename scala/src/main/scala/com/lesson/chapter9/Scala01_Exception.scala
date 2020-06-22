package com.lesson.chapter9

import java.io.FileInputStream

/**
 * @author LiuJing
 * @create 2020-05-30 14:52
 */
object Scala01_Exception {
  def main(args: Array[String]): Unit = {
    //TODO Scala中的异常和Java的异常处理很相似
    //1.catch关键字只能使用一次
    //2.多个异常采用case进行区分
    //3.异常处理的语法类似于模式匹配,所以匹配方式从前到后
    //4.范围大的异常一般放在范围小的异常后面进行处理
    //5.Scala中的异常不分编译时的异常和运行时的异常,所以无需显式地处理和抛出
    // Scala中没有throws关键字

    try{
      val i = 0
      val j = 10/i

//      val s = null
//      println(s.substring(1))

      new FileInputStream("xxxx")
    }catch {
      case e:ArithmeticException => {
        println("ArithmeticException...")
      }
      case e:Exception => {
        e.printStackTrace()
      }
    }finally{

    }
  }
}
