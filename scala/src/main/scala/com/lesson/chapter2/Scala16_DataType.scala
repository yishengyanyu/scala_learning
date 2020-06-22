package com.lesson.chapter2

/**
 * @author LiuJing
 * @create 2020-05-19 9:34
 */
object Scala16_DataType {
  def main(args: Array[String]): Unit = {
    //数据类型 ==> AnyVal
    val b : Byte = 10
    val s : Short = 20
    val i : Int = 30
    val l : Long = 10L
    val f : Float = 10.0f
    val d : Double = 20.0
    val ii = 20
    println(ii) //如果整数省略类型, 默认为Int类型
    val dd = 2.0
    println(dd) //如果浮点类型数据省略类型, 默认为Double类型

    val c : Char = 'A'
    val bl : Boolean = true

    val u : Unit = () //Unit是一个类型, 对象只有一个:()
    println(test1())


  }

  def test1() : Unit = {

  }
}
