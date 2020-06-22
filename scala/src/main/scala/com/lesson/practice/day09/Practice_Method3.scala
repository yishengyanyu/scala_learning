package com.lesson.practice.day09

/**
 * @author LiuJing
 * @create 2020-05-29 21:02
 */
object Practice_Method3 {
  def main(args: Array[String]): Unit = {
    //运算
    //reduce:两两计算

    val list = List(1,2,3,4)

    println(list.reduce(_ - _))

    println(list.reduceLeft(_ - _))

    println(list.reduceRight(_ - _))  //-2

    //fold
    println(list.fold(5)(_ - _))  //-5

    println(list.foldLeft(5)(_ - _))  //-5

    println(list.foldRight(5)(_ - _)) //3

    //val list = List(1,2,3,4)
    println(list.foldLeft("a")(_+_))  //a1234

//    println(list.fold("")(_ + _)) //编译不通过

    println(list.foldRight("b")(_ + _)) //1234b

    println(List(1, 2, 3, 4, 5).foldRight("c")(_ + _))  //12345c
  }
}
