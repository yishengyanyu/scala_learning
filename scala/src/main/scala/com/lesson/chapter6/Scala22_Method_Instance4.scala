package com.lesson.chapter6

/**
 * @author LiuJing
 * @create 2020-05-23 14:36
 */
object Scala22_Method_Instance4 {
  def main(args: Array[String]): Unit = {
    //Scala-面向对象-构造方法-构造顺序

    //如果父类有构造方法,怎么办?
    //Person => User
    //new User() => new Person()
    //构建子类对象时,如果父类的构造方法有参
    //那么子类在构建父类对象时也应该传递参数
    //Scala中如何向父类的构造方法传参?
    //在父类名称后面加上括号就可以传参了
    val user = new User
    val emp = new Emp("lisi")

  }


  class Person(name:String){
    println("Person...")
  }

  class User extends Person("zhangsan"){
    println("User...")
  }

  class Emp(name:String) extends Person(name){
    println("Emp...")
  }
}






