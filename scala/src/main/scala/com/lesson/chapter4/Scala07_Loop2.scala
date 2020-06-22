package com.lesson.chapter4

/**
 * @author LiuJing
 * @create 2020-05-20 9:11
 */
object Scala07_Loop2 {
  def main(args: Array[String]): Unit = {
    //Scala循环
    for ( i <- Range(1,5) ) {
      //写很多代码
      for ( j <- Range(1,4) ) {
        println("i = " + i + ",j = " + j )
      }
    }

    for(i <- Range(1,5); j <- Range(1,4)) { //不常用, 无法在两层循环之中加其他代码
      println("i = " + i + ",j = " + j)
    }

    for(i <- Range(1,5); j = i -1){
      //val j = i - 1
      println("i = " + i + ",j = " + j)
    }
  }
}
