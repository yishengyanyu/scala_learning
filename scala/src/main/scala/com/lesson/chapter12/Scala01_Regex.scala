package com.lesson.chapter12

import scala.util.matching.Regex

/**
 * @author LiuJing
 * @create 2020-06-01 10:42
 */
object Scala01_Regex {
  def main(args: Array[String]): Unit = {
    //正则表达式
    //类似于模式匹配
    //模式匹配是对数据进行匹配
    //正则表达式是对字符串的内容进行匹配
    //有自己的匹配规则

    //声明规则
    val r: Regex = "s".r  //判断字符串第一个是否为s
    val s = "hello hive redis"
    val maybeString: Option[String] = r.findFirstIn(s)
    if(maybeString.isEmpty){
      println("没有符合规则的内容")
    }else{
      println(maybeString.get)
    }

    //TODO 判断字符串是不是一个电话号码
    //1.全部都是数字
    //2.手机号码:11位字符串
    val r2: Regex = "^\\d{11}$".r
    val s1 = "02345678901"
    val maybeString1: Option[String] = r2.findFirstIn(s1)
    if ( maybeString1.isEmpty ) {
        println("没有符合规则的内容")
    } else {
      println(maybeString1.get)
    }
  }
}
