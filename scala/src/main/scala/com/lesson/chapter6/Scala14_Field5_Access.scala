package com.lesson.chapter6

import scala.beans.BeanProperty

/**
 * @author LiuJing
 * @create 2020-05-23 14:36
 */
object Scala14_Field5_Access {
  def main(args: Array[String]): Unit = {
    //Scala-面向对象-访问权限
    //private: 同类
    //如果属性声明为private,则编译器生成set,get方法时,也会使用private进行修饰
    //使用BeanProperty注解后,属性不能声明为private
    val user = new User
    //user.name = "lisi"  //报错

    //private[包名]:同类,同包(不强调子类的概念)
    //中括号的包名可以向上使用
    //必须在当前包的作用域范围内

    //protected表示同类和子类,没有同包的概念!!!

    //(default):公共的
    //Scala中的源码文件可以声明多个公共类

  }

  class User{
    //@BeanProperty 报错
    private var name:String = "zhangsan"
    private[chapter6] var age : Int= _
    private[lesson] var sex :String = _
    protected var tel:String = _
    var email : String = _

    def test1(): Unit ={
      println("name" + name)
    }
  }


  class SubUser extends User{
    def testSub(): Unit ={
      println(this.tel)
//      println(this.name)
      println(this.age)
    }
  }

  class Emp{
    def test1(): Unit ={
      val user = new User
//      user.name = "lisi"
      user.age = 20
//      user.tel
    }
  }
}





