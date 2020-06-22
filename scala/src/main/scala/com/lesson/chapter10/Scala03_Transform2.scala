package com.lesson.chapter10

/**
 * @author LiuJing
 * @create 2020-05-30 15:52
 */
object Scala03_Transform2 {
  def main(args: Array[String]): Unit = {

    //将User => Parent
    //将函数声明前增加implicit关键字,可以由编译器自动识别和自动调用
    //完成类型转换,并扩展功能
    //这种方法称之为隐式方法
    implicit def transform(user:User): Parent ={
      new Parent()
    }
//    implicit def transform1(user:User): Parent ={
//      new Parent
//    }

    //TODO 1.如果在当前范围内,有多个相同的转换规则怎么办?
    //  转换无法成功,因为编译器无法识别使用哪一个
    //  相同的转换规则必须只能有一个
    //TODO 2.隐式转换方法的调用时机
    //  二次编译:第一次编译出现错误时,会选择隐式转换


    //代码写死了,需要更新
    //如何使得main中的代码一点不变并且能够更新
    //动态混入
//    val user = new User with update
    val user = new User
    user.insertUser()
    user.updateUser() //1.编译出错  2.编译器查找转换规则 3.再次编译


  }
  class Parent{
    def updateUser(): Unit ={
      println("update User...")
    }
  }

  class User{

    def insertUser(): Unit ={
      println("insert User...")
    }

  }

}


//trait update{
//  def updateUser(): Unit ={
//    println("update User...")
//  }
//}
