package com.lesson.chapter10

/**
 * @author LiuJing
 * @create 2020-05-30 16:07
 */
object Scala04_Transform3 {
  def main(args: Array[String]): Unit = {

    //OCP

    //函数的参数预先知道可能会发生变化,为了遵循OCP开发原则
    //可以给函数增加关键字修饰一下
    //implicit修饰函数的参数时,函数所在的参数列表只能有一个参数

    //TODO 隐式参数
    def regUser(name:String)(implicit password:String = "123123"): Unit ={
      println(s"注册用户: $name,默认密码: $password")
    }

    //隐式变量
    implicit val pswd : String = "888888"

    //如果使用隐式参数处理,那么调用函数时,不需要使用小括号调用
    //如果使用小括号,隐式变量无法使用
    regUser("zhansgan")() //加了()表示不想使用隐式变量

    val list = List(1,2,3,4)
    list.sortBy(num => num) //源码:implicit ord : scala.math.Ordering
    list.sortBy(num => num)(Ordering.Int.reverse)

    //StringOps
    val s:String = "abc" //字符串没有索引,底层变成了StringOps,StringOps有索引
    println(s(0)) //a
    //StringOps其实是字符串的辅助类,增加功能,靠隐式转换实现
  }
}
