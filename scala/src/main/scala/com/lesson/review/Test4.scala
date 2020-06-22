package com.lesson.review

/**
 * @author LiuJing
 * @create 2020-06-21 22:26
 */
object Test4 {
//  User(10)  //==User.apply(10)
  val user = new User
  user(10)  //==user.apply(10)

  def foo(a:Int)={
    println(a)
  }
  //方法转函数
  //方法不能调用apply方法,需要转成函数,fun = method _
  //  (method _).apply(10)
  foo(10) //== foo.apply(10)

  //值调用apply方法
  val a: Int => Unit = foo _
  a.apply(10)
}

object User {
  def apply(a:Int) = println(a)
}

class User{
  def apply(a:Int)={
    println(a)
  }
}
