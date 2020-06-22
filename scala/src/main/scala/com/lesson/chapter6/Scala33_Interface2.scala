package com.lesson.chapter6

/**
 * @author LiuJing
 * @create 2020-05-26 11:57
 */
object Scala33_Interface2 {
  def main(args: Array[String]): Unit = {
    //特质
    //动态拓展功能,遵循OCP开发原则(对扩展功能开放,对不修改的部分关闭)

    //1.特质中不仅仅有抽象方法,还可以有具体方法

    //2.如果对象声明后想要扩展功能,怎么办?

    //3.特质(混入with)
    //以前的程序一点都不用改
    val mysql = new Mysql33 with Operate33
    mysql.insert()
    mysql.select()
  }
}


trait Operate33{

  def insert(): Unit = {
    println("insert data...")
  }
}

class Mysql33 {
  def select(): Unit ={
    println("select data...")
  }
}