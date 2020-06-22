package com.lesson.chapter6

/**
 * @author LiuJing
 * @create 2020-05-23 14:36
 */
object Scala21_Method_Instance3 {
  def main(args: Array[String]): Unit = {
    //Scala-面向对象-构造方法-构造顺序
    val user = new User("lisi",20)
    //AAAA
    //BBBB
    //CCCC
    //如果在类名后面增加private关键字,表示主构造方法私有化,无法在外部使用
//    val user1 = new User("zhangsan")
    val user2 = new User()

  }

  class User private(name : String){
    println("AAAA")

    def this(){
      this("zhangsan")
      println("BBBB")
    }

    def this(name:String,age:Int){
      this()
      println("CCCC")
    }
  }
}






