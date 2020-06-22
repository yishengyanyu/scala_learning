package com.lesson.review

/**
 * @author LiuJing
 * @create 2020-06-21 14:55
 */
object PartitionDemo1 {
  def main(args: Array[String]): Unit = {
    val list = List((10,(20,30)),(40,(50,60)))

    val list1: List[Int] = list.map(x => x._2._2)

    list.map {
      case (a,(b,c)) => println(c)
    }
  }
}
