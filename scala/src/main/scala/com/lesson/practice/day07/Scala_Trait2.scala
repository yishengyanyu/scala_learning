package com.lesson.practice.day07

/**
 * @author LiuJing
 * @create 2020-05-26 22:24
 */
object Scala_Trait2 {
  def main(args: Array[String]): Unit = {
    val u = new User3333
  }
}

trait Test3333{
  println("AAAA")
}
trait Test3333A{
  println("BBBB")
}
trait Test3333AA{
  println("CCCC")
}
class User3333 extends Test3333 with Test3333A with Test3333AA {
  println("DDDD")
}
