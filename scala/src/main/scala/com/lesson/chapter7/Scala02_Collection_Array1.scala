package com.lesson.chapter7

/**
 * @author LiuJing
 * @create 2020-05-26 16:10
 */
object Scala02_Collection_Array1 {
  def main(args: Array[String]): Unit = {

    //Scala - 集合 - 数组
    //可变集合,不可变集合
    //TODO Array是不可变数组集合
    //对不可变数组集合的操作,会产生新的数组
    //采用其他的方式创建数组
    val array = Array(1,2,3,4)  //调用了apply方法,方法后面加()表示调用apply方法

    //添加数据
    //使用 :+5表示在数组后面添加数据5
    val array1 = array :+ 5
    println(array.mkString(","))
    println(array1.mkString(","))

    //使用 +:(5)表示在数组前面添加数据5
    val array2 = array.+:(5)
    println(array2.mkString(","))

    // 使用 +: 表示向数组的前面添加数据
    //val newArray1: Array[Int] = array.+:(5)

    //如果集合的方法采用:结尾,则运算规则从右往左执行
    val array3 = 5 +: array
    println(array3.mkString(","))

    //++运算符表示增加多个数据,即增加集合数据
    val array4 = array ++ array3
    println(array4.mkString(","))

    val array5 = array:+"5" //集合类型发生改变
    println(array5.mkString(","))
  }
}
