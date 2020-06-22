package com.lesson.chapter5

/**
 * @author LiuJing
 * @create 2020-05-20 16:55
 */
object Scala10_Function9 {
  def main(args: Array[String]): Unit = {
    //函数式编程
    def sum(x:Int,y:Int):Int = {
      x+y
    }

    def calcAnylysis(f:(Int,Int)=>Int)={
      val boyCnt = 20
      val girlCnt = 40
      f(boyCnt,girlCnt)
    }

    val f = sum _
    println(calcAnylysis(f))

    calcAnylysis((x:Int,y:Int)=>{ x + y})//60
    calcAnylysis((x:Int,y:Int)=>x + y)//60
    calcAnylysis((x,y)=>x + y)//60
    calcAnylysis(_ + _)//60
    println(calcAnylysis(_ + _))//60

  }

}
