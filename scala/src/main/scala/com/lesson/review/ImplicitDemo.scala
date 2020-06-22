package com.lesson.review

import java.time.LocalDate

/**
 * @author LiuJing
 * @create 2020-06-21 14:03
 */
object ImplicitDemo {
  def main(args: Array[String]): Unit = {
    val ago = "ago"
    val r1: String = 1 days ago
    val later = "later"
    val r2: String = 2 days later
    println(r1)
    println(r2)

    val array = Array(29,36,10,6,27,15)
    //sortBy有隐式参数
    //相关类型有Array,Int,Ordering, 找到了Ordering类型的伴生对象
    array.sortBy(x => x)(Ordering.Int.reverse)
  }

  implicit class RichInt(day:Int){
    def days(when:String)={
      when match {
        case "ago" => LocalDate.now().plusDays(-day).toString
        case "later" => LocalDate.now().plusDays(day).toString
        case _ => ""
      }
    }
  }
}
