package com.lesson.chapter6

/**
 * @author LiuJing
 * @create 2020-05-23 14:36
 */
object Scala18_Method_Instance {
  def main(args: Array[String]): Unit = {
    //Scala-面向对象-构造方法
    //new关键字创建的对象等同于调用类的构造方法
    //Scala是完全面向对象的语言
    //Scala还是完全面向函数的语言
    //Scala中类其实也是一个函数,类名其实就是函数名,类名后面可以添加(),表示函数参数列表
    //这个类名所代表的函数其实就是构造方法,构造函数
    //构造方法执行时,会完成类的主体内容的初始化
    val user = new User()
    user.User()



  }

  class User(){
    //类体 & 函数体
    println("user...")
    //public User(){}
    def User() ={ //不是构造方法,而是普通方法
      println("User...init")
    }
  }
}






