package com.lesson.chapter8

/**
 * @author LiuJing
 * @create 2020-05-30 10:46
 */
object Scala05_Match4 {
  def main(args: Array[String]): Unit = {
    //TODO Scala - 模式匹配 - 应用
    //val data = (1,"zhangsan",30)
    //val map = Map("a"->("aa",1), "b"->("bb",1))

    //模式匹配 - 元组
    val (id, name, age) = (1, "zhangsan", 30)
    val t = (1, "zhangsan", 30)
    println(name)
    println(t._2)

    //模式匹配 - 集合
    val map = Map("a" -> ("aa", 1), "b" -> ("bb", 1))

    //foreach方法将集合中的每一个元素进行遍历
    //foreach里面匹配的是数据规则
    //如果匹配集合中的元组数据时,匹配需要使用case关键字
    map.foreach {
      case (_, (_, count)) => { //不加case被认为是元组
        println(count)
      }
    }

    //模式匹配时,()需要变成大括号
    //case后面的小括号不是表示参数列表,而是表示元组
    //模式匹配一般就在一个参数的使用
    val list = List(("a", 1), ("b", 2), ("c", 3))

    val list1: List[(String, Int)] = list.map(t => (t._1, t._2 * 2))
    println(list1)

    val list2 = list.map {
      case (word, count) => {
        (word, count * 2)
      }
    }
    println(list2)


  }
}
