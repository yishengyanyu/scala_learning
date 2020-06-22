package com.lesson.practice.day10

/**
 * @author LiuJing
 * @create 2020-05-31 19:08
 */
object Practice_Match3 {
  def main(args: Array[String]): Unit = {
    //应用
    //模式匹配-元组
    val (id,name,age) = (1001,"zhangsan",30)

    //模式匹配-集合
    val map = Map("a"->("aa",1),"b"->("bb",2))
    map.foreach {
      case (_, (_, v)) => {
        println(v)
      }
    }

    val list = List(1,2,3,4,5)
    list.foreach{
      case s => println(s)
    }

    val list1 = List(1,2,3,List(1,2,3))
    println(list1.flatMap{
      case e:List[Int] => e
      case s => List(s)
    })

    val list2 = List(("hello", 1), ("scala", 2), ("scala", 3))
    println(list2.map{
      case (word, count) => (word, count * 2)
    })

    println(list2.filter {
      case (word, count) => word.startsWith("s")
      case _ =>  false
    })

    //匹配对象
    val Match3(name1, age1) = Match3("zhangsan",20)
    println(name1)
    println(age1)

    //匹配数组
    val Array(first,second,_*) = Array("张三",1,2,3)
    println(first)
    println(second)

    //集合模式匹配
    val map1 = Map("A" -> 1, "B" -> 0, "C" -> 3,"D"->0)
    for ((k,0) <- map1) {
      println((k, 0))
    }

  }
  case class Match3(name:String, age:Int)
}


