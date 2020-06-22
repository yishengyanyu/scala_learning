package com.lesson.chapter11

/**
 * @author LiuJing
 * @create 2020-06-01 10:34
 */
object Scala02_Generic1 {
  def main(args: Array[String]): Unit = {
    //看懂就行
    def f[A : Test](a: A) = println(a)  //Test[A]
    //将泛型和隐式转换合二为一
    implicit val test : Test[User] = new Test[User]
    f( new User() )
  }
  class Test[T] {
  }
  class Parent {
  }
  class User extends Parent{
  }
  class SubUser extends User {
  }

}
