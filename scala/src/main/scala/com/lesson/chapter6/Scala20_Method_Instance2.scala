package com.lesson.chapter6

/**
 * @author LiuJing
 * @create 2020-05-23 14:36
 */
object Scala20_Method_Instance2 {
  def main(args: Array[String]): Unit = {
    //Scala-面向对象-构造方法
    //给构造方法增加参数的目的是什么
    //从外部将数据传递到对象的属性中
    //Scala中一般构造方法的参数用于属性的初始化,所以为了减少参数的冗余
    //  可以使用关键字var/val将构造参数当成类的属性使用
    //  var可读可写,val只能读,不能写
    val user = new User("zhangsan")
    println(user.username)

    val emp = new Emp("lisi")
    println(emp.name)

  }

  class User(name : String) {
    //name其实是函数的参数,局部变量,无法通过对象在外部访问
    //username是类的属性,也是局部变量,可以通过对象在外部访问
    val username : String = name
  }

  class Emp(var name:String){

  }
}






