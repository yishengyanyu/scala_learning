package com.lesson.chapter5

/**
 * @author LiuJing
 * @create 2020-05-20 11:46
 */
object Scala04_Function3 {
  def main(args: Array[String]): Unit = {

    def test1(): Unit ={
      println("XXXX")
      def test2(): Unit ={
        println("test2...")
      }
    }
    test1()

  }

  def test1(): Unit ={
    println("YYYY")
  }

  def test1(s:String): Unit ={
    println("XXXX")
  }
}
