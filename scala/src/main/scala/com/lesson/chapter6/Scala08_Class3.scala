package com.lesson.chapter6

/**
 * @author LiuJing
 * @create 2020-05-23 14:36
 */
object Scala08_Class3 {
  def main(args: Array[String]): Unit = {
    //Scala-面向对象-Class
    //Scala中class可以继承(extends)父类
    //多态: 一个对象在不同场合下所表示的不同的状态

    //Scala当省略类型,编译器会自动将构建对象的类型进行推断
    //如果需要使用多态操作,那么必须显式声明类型
    val user:Parent08 = new User08
    println(user)

  }
}

//父类
class Parent08 {

}

//子类
class User08 extends Parent08 {

}


