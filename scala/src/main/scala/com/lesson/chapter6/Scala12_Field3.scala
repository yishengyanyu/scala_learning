package com.lesson.chapter6

import scala.beans.BeanProperty

/**
 * @author LiuJing
 * @create 2020-05-23 14:36
 */
object Scala12_Field3 {
  def main(args: Array[String]): Unit = {
    //Scala-面向对象-属性'
    //spring => 自动装配 => 自动完成两个对象关系的组合(User,Dept)
  }

  class User{
    //Bean规范
    var name : String = _

    def setName(name:String): Unit ={
      this.name = name
    }

    def getName():String = {
      return this.name
    }

  }
}





