package com.lesson.review

/**
 * @author LiuJing
 * @create 2020-06-21 14:32
 */
object MatchDemo {
  def main(args: Array[String]): Unit = {
    val a:Any = 10
    a match {
      case b: Int =>
      case c => //取了个别名,可以将值赋给c,更强大
      case _ => //_类似于黑洞
    }

    val array = Array(10,20,30)
    array match {
      case Array(a,b,c) =>
      case Array(a,rest@_*) => {
        println("array2...")
        println(rest)
      }
    }

    //中置运算符(::) 前置(!1) 后置(a toString)
    val list = List(10,20,30)
    list match {
      case (a::b::rest) => println(rest)
      case a::b::c::d::Nil => println(a)
    }
  }
}
