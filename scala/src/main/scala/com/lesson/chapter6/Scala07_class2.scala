package com.lesson.chapter6

/**
 * @author LiuJing
 * @create 2020-05-23 14:36
 */
object Scala07_class2 {
  def main(args: Array[String]): Unit = {
    //Scala-面向对象-Class
    //Thread sleep,wait方法的区别
    //Object一般用于声明静态方法,通过类名直接访问
    //如果需要通过对象访问属性或方法,那么就使用class声明
    //如果需要通过类名直接访问属性或者方法,那么就使用Object声明

    //构建对象
    //使用class声明,那么需要使用new的方式
    // new对象时,由于构造方法无参的原因,小括号可以省略
    val user1 = new User07()
    val user3 = new User07
    println(user1)  //com.lesson.chapter6.User07@56cbfb61
    println(user3)  //com.lesson.chapter6.User07@1134affc

    //使用Object来声明,那么可以直接使用类名,获取的是伴生对象
    //不能使用new
    val user2 = User077
    println(user2)  //com.lesson.chapter6.User077$@1134affc

    //调用方法
    //使用class声明的类,无法通过类名直接访问方法或属性,必须构建对象
    //user1.test1()
    //使用Object声明的类可以通过类名直接访问属性或方法
    User077.test2()


  }
}

class User07 {
  def test1(): Unit ={
    println("user07...")
  }
}

object User077{
  def test2(): Unit ={
    println("user077...")
  }
}


