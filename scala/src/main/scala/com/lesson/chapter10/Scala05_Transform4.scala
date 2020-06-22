package com.lesson.chapter10

/**
 * @author LiuJing
 * @create 2020-05-30 16:35
 */
object Scala05_Transform4 {
  def main(args: Array[String]): Unit = {

    val user = new User
    user.insertUser()
    user.updateUser()
  }

  //隐式类
  //Scala 2.10版本中增加此功能
  //构造参数必须存在且只有一个参数,用于转换类型
  //参数类型(User) => 当前类型(UserExt)
  implicit class UserExt(user:User){
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


