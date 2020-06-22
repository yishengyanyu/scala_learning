package com.lesson.chapter7

import scala.collection.mutable

/**
 * @author LiuJing
 * @create 2020-05-29 14:36
 */
object Scala29_Collection_Method7 {
  def main(args: Array[String]): Unit = {
    //TODO Scala - 集合 - 合并集合
    //Map(a->1,b->2,c->3)
    //Map(a->4,d->5,c->6)
    //=>  Map(a->5,b->2,d->5,c->9)
    val map1 = mutable.Map("a"->1,"b"->2,"c"->3)
    val map2 = mutable.Map("a"->4,"d"->5,"c"->6)

    //reduce只能对集合内部数据进行操作
    val result = map1.foldLeft(map2)({
      (map, kv) => {
        val k = kv._1
        val v = kv._2
        val newVal = map.getOrElse(k,0) + v
        map(k) = newVal
        map
      }
    })
    println(result)
  }
}
