package com.lesson.review

/**
 * @author LiuJing
 * @create 2020-06-21 14:19
 */
object ArrayDemo1 {
  def main(args: Array[String]): Unit = {
    val array = Array(1,2,3,4,5)
    val array1: Array[Int] = array:+7 //array.:+(7)方法

    val array2: Array[Int] = 8+:array1  //array1+:(8),8+:array1,右结合,找右边的array1,调用它的方法:array1.+:8

    //::  :::
    val list = List(1,2,3,4,5)
    println((100 :: list):+100)  //::为右结合  不加()会报错
    println(10 :: 20 :: Nil)

    val list1 = List(6,7,8,9,10)
    val list2: List[Int] = list:::list1
  }

  //运算符的结合性
  //左结合: 3 + 4(+属于3,3的+加上4)
  //右结合:赋值运算都是右结合;以冒号结尾的运算符都是右结合
}
