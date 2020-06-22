package com.lesson.practice.day06

import com.lesson.chapter6.UserNNN

/**
 * @author LiuJing
 * @create 2020-05-25 20:54
 */
object Practice_Method {
  def main(args: Array[String]): Unit = {
    val u1 = UserNNN.apply()
    val u2 = UserNNN() //省略了apply
    val u3 = new UserNNN
    val u4 = UserNNN
    val u5 = UserNNN.apply("zhangsan") //返回值类型为Unit
    println(u1)
    println(u2)
    println(u3)
    println(u4)
    println(u5)

  }
}

class UserNNN{
  override def equals(obj: Any): Boolean = {
    if(obj.isInstanceOf[UserNNN]){
      var u = obj.asInstanceOf[UserNNN]
      this == u
    }else{
      false
    }

  }
}

object UserNNN{

  def apply(): UserNNN = new UserNNN()

  def apply(name:String): Unit ={

  }
}

