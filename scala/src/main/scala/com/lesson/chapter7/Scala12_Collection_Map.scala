package com.lesson.chapter7

/**
 * @author LiuJing
 * @create 2020-05-27 10:39
 */
object Scala12_Collection_Map {
  def main(args: Array[String]): Unit = {
    // apply方法主要用于在伴生对象中构建对象

    //Scala - 集合 - Map - 映射
    //A=>B
    //K=>V
    //Map集合用于存储k-v键值对对象
    //构建键值对对象: A -> B A映射到B


    //构建对象  (key和value的泛型)
    //map:无序,key不能重复
    //多了之后输出无序
    val map: Map[String,Int] = Map("a"->1,"b"->2,"c"->3,"a"->4,"e"->5)

    println(map)

  }
}
