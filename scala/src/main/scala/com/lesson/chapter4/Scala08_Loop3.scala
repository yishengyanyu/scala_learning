package com.lesson.chapter4

/**
 * @author LiuJing
 * @create 2020-05-20 9:20
 */
object Scala08_Loop3 {
  def main(args: Array[String]): Unit = {
    //Scala for循环
    //step=2
    //layer=9(9层)
    //1,3,5,7,9...,17
    for(i <- Range(1,18,2);j = (18 - i)/2){
      println( " " * j + "*" * i)
    }
  }
}
