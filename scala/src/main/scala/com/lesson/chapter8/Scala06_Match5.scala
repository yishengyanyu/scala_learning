package com.lesson.chapter8

/**
 * @author LiuJing
 * @create 2020-05-30 11:30
 */
object Scala06_Match5 {
  def main(args: Array[String]): Unit = {
    //TODO Scala - 模式匹配 - 应用
    val Array(first,second,_*) = Array(1,7,2,9)

    //模式匹配 - 对象
    val Person(name, age) = Person("zhangsan", 16)
    println(name)

    val map = Map("A" -> 1, "B" -> 0, "C" -> 3)
    for (elem <- map) {
      println(elem)
    }
    //模式匹配还可以过滤数据
    for((k,0) <- map){    //进行了数据的筛选
      println(k + "," + 0)
    } //B,0


  }

  case class Person(name: String, age: Int)
}
