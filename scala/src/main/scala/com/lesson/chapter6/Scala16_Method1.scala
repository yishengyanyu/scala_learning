package com.lesson.chapter6

/**
 * @author LiuJing
 * @create 2020-05-23 14:36
 */
object Scala16_Method1 {
  def main(args: Array[String]): Unit = {
    //Scala-面向对象-方法-apply(应用)
    //apply主要作用用于构建对象
    //使用new,等于调用对象的构造方法构建对象
    val user = new User16()
    //有些情况下无法使用new,如私有的构造方法
    //apply()方法一般应用于Object伴生对象中构建对象(用方法构建对象)
    //伴生对象可以访问伴生类的私有属性和方法
    //Scala可以自动识别apply方法,所以调用伴生对象的apply方法时,apply可以省略
    for(i <- Range(1,5)){ //有apply方法

    }


    //如果不使用new来构建对象,等于调用伴生对象的apply方法
    //如果将伴生对象不使用小括号操作,那么等同于将伴生对象赋给变量,而不是调用apply方法
    //apply如果想要被编译器识别,则不能省略小括号
    //apply方法主要用于构建对象,但这个对象不一定是当前类的对象
    //apply方法可以重载
    val user1 = User16.apply("zhangsan")
    val user2 = User16()
    val user3 = User16  //将伴生对象赋给user3
    println(user1)
    println(user3)

  }
}

class User16{

}

object User16{
  def apply() = {

  }

  def apply(name:String)={  //apply方法重载
    println("name = " + name)
  }

}




