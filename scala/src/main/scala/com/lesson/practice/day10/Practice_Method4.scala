package com.lesson.practice.day10

/**
 * @author LiuJing
 * @create 2020-05-31 19:55
 */
object Practice_Method4 {
  def main(args: Array[String]): Unit = {
    //偏函数
    val list = List(1,2,"3",4)

    //偏函数
    val pf : PartialFunction[Any,Any] = {
      case i:Int => i*2
      case s:String => s
    }
    //支持偏函数的函数
    //collect也支持映射
    println(list.collect(pf))

    //不用偏函数,直接使用模式匹配
    println(list.map{
      case e:Int => e*2
      case i:String => i
    })

    println(list.collect{
      case e:Int => e*2
      case i:String => i
    })

    //偏函数
    val pf2:PartialFunction[Any,Any] = {
      case i:Int => i*2
      case s:String => s*2
      case _ => "something"
    }
    println(list.collect(pf2))
  }
}
