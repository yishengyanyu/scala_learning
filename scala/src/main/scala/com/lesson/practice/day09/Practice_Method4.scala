package com.lesson.practice.day09

import scala.collection.mutable

/**
 * @author LiuJing
 * @create 2020-05-29 22:02
 */
object Practice_Method4 {
  def main(args: Array[String]): Unit = {
    //合并集合
    val map1 = mutable.Map("a"->1,"b"->2,"c"->3)
    val map2 = mutable.Map("a"->4,"d"->5,"c"->6)

    //第二个集合与第一个集合中每个kv-1匹配, 集合2中每个kv-2与kv-1进行运算
    val result: mutable.Map[String, Int] = map1.foldLeft(map2)(
      (map, kv) => { //两两运算,所以参数一定是两个值
        val k = kv._1
        val v = kv._2
        val i: Int = map.getOrElse(k, 0) + v
        map(k) = i
        map
      }
    )
    println(result)

    //scan
    val list = List(1,2,3,4,5)
    println("scan => " + list.scan(6)(_ - _)) //scan => List(6, 5, 3, 0, -4, -9)

    println("scanLeft => " + list.scanLeft(6)(_ - _))
    //scanLeft => List(6, 5, 3, 0, -4, -9)

    println("scanRight => " + list.scanRight(6)(_ - _))
    //scanRight => List(-3, 4, -2, 5, -1, 6)

  }
}
