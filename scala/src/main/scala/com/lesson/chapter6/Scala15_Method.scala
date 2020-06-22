package com.lesson.chapter6

/**
 * @author LiuJing
 * @create 2020-05-23 14:36
 */
object Scala15_Method {
  def main(args: Array[String]): Unit = {
    //Scala-面向对象-方法
    //所谓的方法其实就是类中声明的函数

    val user= new User()
    //类中的方法
    //1.默认方法
    //  java.lang.Object的方法
    //    user.toString
    //    user.hashCode()

    //Scala中提供的方法
    //user.asInstanceOf[User]
    //user.isInstanceOf[User]
    //user1 == user2

    //获取对象的类型信息(方法区内存)
//    val clazz: Class[_ <: User] = user.getClass
    val clazz: Class[User] = classOf[User]
    //println()
    //Predef中的方法

    //2.自定义方法

  }

  class User{
    override def equals(obj: Any): Boolean = {
      //java重写equals()
//      if(obj instanceof User){
//        User u = (User)obj
//      }

      //Scala重写equals()
      if(obj.isInstanceOf[User]){
        val u = obj.asInstanceOf[User]
        this == u
      }else{
        false
      }

    }
  }
}





