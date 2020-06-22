package com.lesson.chapter10

import com.lesson.chapter10.Scala06_Transform5.User

/**
 * @author LiuJing
 * @create 2020-05-30 16:44
 */
object Scala06_Transform5 {
  def main(args: Array[String]): Unit = {
    //TODO 隐式转换的查找规则
    //隐式类不能放在(top-level)对象中
    //1.当前代码的作用域中找到即可
    //2.当前代码上级作用域
    //3.当前类所在的包对象
    //4.当前类的父类或特质

    //如果想要隐式转换,也可以直接导入

//    implicit class UserExt07(user : User) {
//        def updateUser(): Unit = {
//            println("update 07 user...")
//        }
//    }
    val user = new User
    user.insertUser()

    user.updateUser()
  }

  class User{
    def insertUser(): Unit ={
      println("insert User...")
    }
  }
}

trait Test {
  //implicit class UserExt06(user:User){
  //  def updateUser(): Unit ={
  //    println("update User...")
  //  }
  //}
}

