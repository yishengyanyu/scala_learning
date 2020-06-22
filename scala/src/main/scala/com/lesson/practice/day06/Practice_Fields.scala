package com.lesson.practice.day06

import scala.beans.BeanProperty

/**
 * @author LiuJing
 * @create 2020-05-25 19:33
 */
object Practice_Fields {
  def main(args: Array[String]): Unit = {
    val p1 = new Person
//    p1.age2 = 2 //编译通过,运行不通过
    println(p1.age1)
  }

  class Person {
    //Sec1
    var name : String = _
//    val name : String = _
    val name1  = ""
    var name2 = null
    var age : Int = _
    var age1 = 0
//    var age2 : Int = null

    @BeanProperty
    var sex = "男"
  }

}
