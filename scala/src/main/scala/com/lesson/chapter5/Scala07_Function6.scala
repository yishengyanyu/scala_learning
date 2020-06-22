package com.lesson.chapter5

/**
 * @author LiuJing
 * @create 2020-05-20 15:20
 */
object Scala07_Function6 {
  def main(args: Array[String]): Unit = {
    //函数式编程
    val name = "zhangsan"
    val password = "123456"
    //此种写法表示一个集合,","表示分割元素
    println("name="+name,"password="+password)  //(name=zhangsan,password=123456)

    println("name="+name + ",password="+password) //name=zhangsan,password=123456

    //Scala中的()表示集合
    //函数如果只有一个参数,或者没有参数,那么调用时,()可以省略
  }
}
