package com.lesson.practice.day06

/**
 * @author LiuJing
 * @create 2020-05-25 21:52
 */
object Practice_Method_Instance {
  def main(args: Array[String]): Unit = {
    val user1 = new User1("zhangsan",20,"123651367134");

    val user2 = new User2("zhangsan")
    println(user2.name)

//    val user3 = new User1 //编译不通过


  }
}

class User1 private{
  println("AAAA")

  def this(name : String){
    this()
    println("BBBB")
  }

  def this(name:String,age:Int){
    this(name)
    println("CCCC")
  }

  def this(name:String,age:Int,tel:String){
    this(name,age)
    println("DDDD")
  }
}


class User2(var name:String){

}

class Student private () extends User1("zhangsan") {
  def this(name:String){
    this()
  }

  def this(id:Int){
    this()
  }
}
