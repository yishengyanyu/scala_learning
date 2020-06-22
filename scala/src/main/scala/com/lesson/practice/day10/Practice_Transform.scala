package com.lesson.practice.day10

import scala.collection.immutable.StringOps

/**
 * @author LiuJing
 * @create 2020-05-31 20:19
 */
object Practice_Transform {
  def main(args: Array[String]): Unit = {
    //类型转换
    def transform(d:Double):Int= {
      d.toInt
    }
    val i:Int = transform(2.0)

    //隐式转换-implicit
    implicit def transform1(d:Double):Int= {
      d.toInt
    }
    val i1:Int = 2.0

    def regUser(name:String,password:String): Unit ={
      println(s"注册用户:$name,密码:$password")
    }

    regUser("zhangsan","000000")
    //设置默认密码
    def regUser1(name:String)(implicit password:String = "123123"): Unit ={
      println(s"注册用户:$name,默认密码:$password")
    }
//    regUser1("zhangsan")  //123123
    //在regUser1的基础上修改默认密码
    //  隐式变量
    implicit val pswd:String = "888888"
//    implicit val pass:String = "999999"
    regUser1("lisi")  //"888888"

    val s:StringOps= "zhangsan"
    val c: Char = s(2)
    println(c)
  }
}
