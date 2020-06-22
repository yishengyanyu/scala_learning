package com.lesson.review


/**
 * @author LiuJing
 * @create 2020-06-21 14:42
 */
object ObjectMatch {
  def main(args: Array[String]): Unit = {
    val d = 9.0
    d match {
      case Sqrt(r) => println(r)
    }

    val user = new User("zs",10)
    user match {
      case User(n,a) => {
        println(n)
        println(a)
      }
    }
  }

  case class User(name:String,age:Int)
}

object Sqrt {
  //值的传递顺序: d => arg => Some => r
  def unapply(arg: Double): Option[Double] = if(arg > 0) Some(math.sqrt(arg)) else None
}





