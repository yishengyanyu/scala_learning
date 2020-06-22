package com.lesson.practice.day10

/**
 * @author LiuJing
 * @create 2020-05-30 9:45
 */
object Practice_Match {
  def main(args: Array[String]): Unit = {
    def describe1(x: Any) = {
      val result = x match {
        case i: Int => "Int"
        case s: String => "String hello"
        case m: List[String] => "List"
        case c: Array[Int] => "Array[Int]"
        case map:Map[String ,Int] => "Map"
        case set:Set[String] => "Set"
        case someThing => "something else " + someThing
      }
      println(result)
    }
    val map: Map[Int, Int] = Map((1,2),(2,3),(3,4))
    describe1(map)

    val set: Set[Int] = Set(1,3,9,5)
    describe1(set)
  }
}
