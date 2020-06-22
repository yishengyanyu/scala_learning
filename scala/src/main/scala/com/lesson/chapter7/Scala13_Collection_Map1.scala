package com.lesson.chapter7

import scala.collection.mutable

/**
 * @author LiuJing
 * @create 2020-05-27 10:45
 */
object Scala13_Collection_Map1 {
  def main(args: Array[String]): Unit = {
    //Scala - 集合 - Map - 映射 - 可变
    val map: mutable.Map[String, Int] = mutable.Map("a"->1,"b"->2,"c"->3)

    //添加数据(也可以修改数据)
    map.put("d",4)

    //修改数据
    map.update("d",5)
    map("a")=6

    //删除数据
    map.remove("a")

    println(map)
  }
}
