package com.lesson.practice.day11

/**
 * @author LiuJing
 * @create 2020-06-01 21:39
 */
object Practice02_Generic {
  def main(args: Array[String]): Unit = {

    //看懂就行
    def f[A : Test](a: A) = println(a)  //Test[A]
    //将泛型和隐式转换合二为一
    implicit val test : Test[Parent] = new Test[Parent]
    f( new Parent() )
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
