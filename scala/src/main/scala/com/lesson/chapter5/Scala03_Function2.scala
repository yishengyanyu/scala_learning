package com.lesson.chapter5

/**
 * @author LiuJing
 * @create 2020-05-20 11:30
 */
object Scala03_Function2 {
  def main(args: Array[String]): Unit = {
    //函数是编程
    //1.无参无返回值函数
    def fun1(): Unit ={
      println("fun1...")
    }
    fun1()

    //2.无参,有返回值
    def fun2(): String ={
      return "fun2..."
    }

    println(fun2())

    //3.有参,无返回值
    def fun3(s:String):Unit ={
      println("name =" + s)
    }

    fun3("fun3()")

    //4.有参,有返回值
    def fun4(name : String): String ={
      return "name = " + name
    }
    println(fun4("fun4()"))

    //5.多参,无返回值
    def fun5(name : String, age : Int): Unit ={
      println(
        s"""
          |{"username":"$name","age":$age}
          """.stripMargin
      )
    }
    fun5("zhangsan",24)

    //6.多参,有返回值
    def fun6(name : String , age : Int): String={
      return s"name=$name,age=$age"
    }
    println(fun6("zhangsan", 24))
  }
}
