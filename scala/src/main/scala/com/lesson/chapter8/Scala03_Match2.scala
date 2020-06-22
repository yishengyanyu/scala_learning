package com.lesson.chapter8

/**
 * @author LiuJing
 * @create 2020-05-30 10:21
 */
object Scala03_Match2 {
  def main(args: Array[String]): Unit = {
    //TODO - 模式匹配 - 匹配规则

    //TODO 匹配元组
    for (tuple <- Array(
      (0, 1),   //0 ...
      (1, 0),   //10
      (1, 1),   //1 1
      (1, 0, 2))) { //something else
      val result = tuple match {
        case (0, _) => "0 ..." //是第一个元素是0的元组
        case (y, 0) => "" + y + "0" // 匹配后一个元素是0的对偶元组
        case (a, b) => "" + a + " " + b
        case _ => "something else" //默认
      }
      println(result)
    }

  }
}
