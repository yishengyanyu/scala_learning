package com.lesson.chapter6

import java.util
import java.util._

/**
 * @author LiuJing
 * @create 2020-05-23 14:36
 */
object Scala04_import {
  def main(args: Array[String]): Unit = {
    //8.Scala默认import是按照包的相对路径进行导入的
    //起包名可以用java
    //双亲委派机制 - 没起作用
    //如果不想使用相对路径下的包,那么可以采用特殊路径(root)访问(从最顶层访问)
    //默认new com.lesson.chapter6.java.util.HashMap() //按照相对路径查找,java中自带,相对路径又有
    println(new _root_.java.util.HashMap())

  }
}

//package java{
//  package util{
//    class HashMap{
//      println("xxxxx")
//    }
//  }
//}
