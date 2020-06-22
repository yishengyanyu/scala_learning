package com.lesson.practice.day09

import scala.collection.mutable

/**
 * @author LiuJing
 * @create 2020-05-30 7:56
 */
object Practice_Method7 {
  def main(args: Array[String]): Unit = {
    //合并集合
    val map1 = mutable.Map("a"->1,"b"->2,"c"->3)
    val map2 = mutable.Map("a"->4,"d"->5,"c"->6)

    //使用fold
    val result = map1.foldLeft(map2)(
      (map, kv) => {
        val k: String = kv._1
        val v: Int = kv._2
        val count: Int = map.getOrElse(k, 0) + v
        map(k) = count
        map
      }
    )
    println(result)


  }
}
