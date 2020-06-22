package com.lesson.practice.day10

/**
 * @author LiuJing
 * @create 2020-05-31 18:55
 */
object Practice_Match2 {
  def main(args: Array[String]): Unit = {
    val m1 = Match2("zhangsan")
    m1.age = 20
    val m2 = Match2("lisi")
    m2.age = 30
    val m3 = Match2("wangwu")
    m3.age = 25
    val m = Match2("lisi")
    m.age = 25

    val result = m match {
      case m1 => "zhangsan"
      case m2 => "lisi"
      case m3 => "wangwu"
      case _ => "something"
    }
    println(result)

  }
}

case class Match2(val name:String){
  var age:Int = _
}
