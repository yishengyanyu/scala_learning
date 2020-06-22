package com.lesson.chapter2

/**
 * @author LiuJing
 * @create 2020-05-19 10:16
 */
object Scala19_DataType3 {
  def main(args: Array[String]): Unit = {
    //Scala --> 隐式转换 --> 自动转换
    //Byte和Short没有任何关系,但是Scala通过隐式转换的规则将Byte自动转换为Short(由编译器实现)
    val b : Byte = 10 //Byte:抽象类, 继承了AnyVal
    val s :Short = b  //Short:抽象类, 继承了AnyVal
    val i : Int = s

    //如果将精度大的类型转换为精度小的类型
    //Java:截取
    //Scala:方法转换
    val bb : Byte = i.toByte


  }
}
