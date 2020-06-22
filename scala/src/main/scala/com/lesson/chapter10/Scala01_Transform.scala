package com.lesson.chapter10

/**
 * @author LiuJing
 * @create 2020-05-30 15:30
 */
object Scala01_Transform {
  def main(args: Array[String]): Unit = {
    //TODO 隐式转换

    val b : Byte = 10

    //Java中基本类型数值之间存在精度的转换和截取
    //Scala中没有精度的概念,编译时会自动由编译器调用Java逻辑来进行数值操作
    //如果两个类型想要互相转换,必须要存在关系:
    //1.父子类
    //2.接口和实现类

    //本来两个类型之间不存在关系,无法进行类型转换,但是编译器在编译时
    //尝试找到对应的转换方法将类型进行转换,让程序编译通过
    //这个自动转换的过程称之为隐式转换,是由编译器完成,也称之为二次编译
    val i : Int =b
//    val bb:Byte = i

    println(i)
  }
}
