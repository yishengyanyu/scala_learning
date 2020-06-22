package com.lesson.chapter7

/**
 * @author LiuJing
 * @create 2020-05-29 14:12
 */
object Scala28_Collection_Method6 {
  def main(args: Array[String]): Unit = {
    //TODO Scala - 集合 - 常用方法 - 折叠

    //将集合之外的数据和集合之内的数据进行聚合的操作,称之为聚合
    //聚合数据的方式为两两操作
    val dataList = List(1,2,3,4)
    //fold存在函数的柯里化,有2个参数列表
    //第一个参数列表 => z:A1 (z表示zero,zero表示数据处理的初始值)
    //第二个参数列表 => (A1,A1)=>A1 (聚合数据的逻辑)
    //fold方法在进行数据处理时,外部的数据应该和集合内部的数据类型保持一致
    val i: Int = dataList.fold(10)(_-_)
    println(i)

    //从源码角度看,fold方法的底层其实就是foldLeft
    //fold,foldLeft和foldRight的返回值为初始值的类型
    val str: String = dataList.foldLeft("a")(_+_)
    println(str)  //a1234
    println(dataList.foldLeft("a")(_ * _))  //24个a

    //底层源码: reversed.foldLeft(z)((x,y) => op(y,x))
    println(dataList.foldRight(5)(_ - _))
  }
}
