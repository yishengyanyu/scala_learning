package com.lesson.practice.day11

import scala.util.matching.Regex

/**
 * @author LiuJing
 * @create 2020-06-01 21:42
 */
object Practice03_Regex {
  def main(args: Array[String]): Unit = {
    //创建规则
    val r: Regex = "s".r
    val s1 = "hello words,hello world"
    val maybeString: Option[String] = r.findFirstIn(s1)
    if(maybeString.isEmpty){
      println("没有符合规则的字符")
    }else{
      println(maybeString.get)  //s
    }

    //判断字符串是不是一个电话号码
    val r1: Regex = "^\\d{11}$".r
    val s2 = "12345678930"
    val maybeString1: Option[String] = r1.findFirstIn(s2)
    if(maybeString1.isEmpty){
      println("非手机号码")
    }else{
      println(maybeString1.get)  //s
    }
  }
}
