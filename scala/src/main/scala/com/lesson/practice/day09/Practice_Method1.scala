package com.lesson.practice.day09

import scala.collection.mutable

/**
 * @author LiuJing
 * @create 2020-05-29 15:20
 */
object Practice_Method1 {
  def main(args: Array[String]): Unit = {
    val map1 = mutable.Map("a"->1,"b"->2,"c"->3)
    val map2 = mutable.Map("a"->4,"d"->5,"c"->6)

    //合并两个集合
    val newMap: mutable.Map[String, Int] = map1.foldLeft(map2)(
      (map, kv) => {
        val k = kv._1
        val v = kv._2
        val value: Int = map.getOrElse(k, 0) + v
        map.update(k, value)
        map
      }
    )
    println(newMap)
  }
}
