package com.lesson.chapter7

import scala.collection.mutable

/**
 * @author LiuJing
 * @create 2020-05-27 11:46
 */
object Scala16_Collection_Tuple1 {
  def main(args: Array[String]): Unit = {
    //如果元组中的元素只有2个,这样的元组称为对偶元组
    //也称之为键值对
    val data = ("a",1)

    //A -> B
    //"a"->1 => ("a",1)
    val map: mutable.Map[String, Int] = mutable.Map(("a",1),("b",2),("c",3))

    println(map)
    for (kv <- map) {
      println(kv._1 + "=" + kv._2)
    }

  }
}
