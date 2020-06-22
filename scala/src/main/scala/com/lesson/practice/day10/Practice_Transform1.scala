package com.lesson.practice.day10

/**
 * @author LiuJing
 * @create 2020-05-31 20:46
 */
object Practice_Transform1 {
  def main(args: Array[String]): Unit = {
    val t = new Transform with Test
    t.insert()
    t.update()

//    implicit class Transform1(t:Transform) {
//      def update(): Unit = {
//        println("update...")
//      }
//    }
  }


//   implicit class Transform1(t:Transform){
//    def update(): Unit ={
//      println("update...")
//    }
//   }

}

class Transform {
  def insert(): Unit ={
    println("insert...")
  }
}

//class TransformN{
//  implicit class Transform1(t:Transform){
//    def update(): Unit ={
//      println("update...")
//    }
//  }
//}

trait Test{
  implicit class Transform1(t:Transform){
    def update(): Unit ={
      println("update...")
    }
  }
}








