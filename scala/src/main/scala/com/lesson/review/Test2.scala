package com.lesson.review

/**
 * @author LiuJing
 * @create 2020-06-21 11:37
 */
object Test2 {
  implicit  val b = 100;
  def main(args: Array[String]): Unit = {
    //隐式值的使用和调用姿势有关
    println(foo(10))  //110
    println(foo(10)())  //310
    println(foo(10)(200)) //210

    val array = Array(10,20,30,40)
    //sortBy定义时使用了隐式参数,柯里化
    array.sortBy(x => x)(Ordering.Int.reverse)
  }

  def foo(a:Int)(implicit b:Int = 300) ={
    a + b
  }
}
