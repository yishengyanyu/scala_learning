package com.lesson.chapter5

/**
 * @author LiuJing
 * @create 2020-05-20 15:49
 */
object Scala08_Function7 {
  def main(args: Array[String]): Unit = {
    //函数式编程

    //函数也是对象

    //1.函数可以作为对象赋值给变量
    def test1() ={
      "zhangsan"
    }
    //将函数赋值给变量
    //函数如果没有参数列表,那么调用时可以省略()
    //如果此时希望将函数不执行,而是当成一个整体赋值给变量,那么需要使用下划线_
    //f1 => ()=>String
    val f1 = test1 _
    //如果不想使用"_"明确将函数作为整体使用,那么可以直接声明变量类型为函数
    //函数类型: 参数列表=>返回值类型
    val f2 : ()=>String = test1
    println(f1())
    println(f2)


    def test2(i:Int):Int = {
      i * 2
    }
    val f3:(Int)=>Int = test2
    println(f3(10))

    //2.函数可以作为参数传递给其他的函数


    //3.函数可以作为函数的返回值返回
  }


}
