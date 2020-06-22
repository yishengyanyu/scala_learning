package com.lesson.chapter6

/**
 * @author LiuJing
 * @create 2020-05-26 14:42
 */
object Scala36_Interface5 {
  def main(args: Array[String]): Unit = {
    //Scala - 特质 -初始化顺序(从左到右)
    //如果类混入多个特质，那么特质的初始化顺序为从左到右
    new User36()
    //AAAA
    //BBBB
    //CCCC
    //DDDD
  }
}

trait Test36{
  println("AAAA")
}
trait Test366{
  println("BBBB")
}
trait Test3666{
  println("CCCC")
}
class User36 extends Test36 with Test366 with Test3666{
  println("DDDD")
}

