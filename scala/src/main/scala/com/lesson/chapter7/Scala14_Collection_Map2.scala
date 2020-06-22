package com.lesson.chapter7

import scala.collection.mutable

/**
 * @author LiuJing
 * @create 2020-05-27 11:18
 */
object Scala14_Collection_Map2 {
  def main(args: Array[String]): Unit = {
    //Scala - 集合 - Map - 映射 - 可变
    val map: mutable.Map[String, Int] = mutable.Map("a"->1,"b"->2,"c"->3)

    //获取指定key的value
    //Java: map集合可以放null键null值
    //      map.get(key)
    //Option选项类型,有两个对象
    //      有值:Some(类型),根据key可以获取值
    //      无值:None(类型),根据key获取不到值
    //主要解决空指针问题(考虑到了获取不到数据的情况)
    val maybeInt: Option[Int] = map.get("a")
    println(maybeInt) //Some(1)
    println(maybeInt.get) //1

    val maybeInt1: Option[Int] = map.get("d")
    println(maybeInt1)  //None
    //从None对象中获取值会发生异常:NoSuchElementException
    println(maybeInt1.get)
    //getOrElse方法表示获取数据,如果获取到,直接返回,如果获取不到,使用默认值
    println(maybeInt1.getOrElse(-1))

    //maybeInt.isEmpty判断是否为空
    //Scala提供了更简洁的方法
    val i: Int = map.getOrElse("d",-1)
    val i1: Int = map.getOrElse("a",-1)
    println(i)
    println(i1)

  }
}
