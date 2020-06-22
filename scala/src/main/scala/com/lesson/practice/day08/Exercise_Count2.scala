package com.lesson.practice.day08

import scala.collection.immutable
import scala.collection.mutable.ListBuffer
import scala.util.control.Breaks._

/**
 * @author LiuJing
 * @create 2020-05-28 16:49
 */
object Exercise_Count2 {
  def main(args: Array[String]): Unit = {
    //1.获取一个个单词构成的List集合
    val list = List(("hello", 4),
      ("hello spark", 3),
      ("hello spark scala", 2),
      ("hello spark scala hive", 1))

    val lists: List[List[String]] = list.map((element) => {
      List.fill[String](element._2)(element._1)
    })
    val strings = lists.flatten

    val wordsList: List[String] = strings.flatMap(_.split(" "))

    //2.将每个单词构成的元素列表放在可变List集合中,List.size为单词出现的次数
    val distinctList: List[String] = wordsList.distinct

    val buffer: ListBuffer[List[String]] = new ListBuffer()

    for (d <- distinctList) {
      //过滤后形成每个单词的元素列表
      buffer.append(wordsList.filter(elem => elem == d))
    }

    //3.按照长度排序并输出List头和长度
    val buffer1: ListBuffer[List[String]] = buffer.sortBy(list => list.size)(Ordering.Int.reverse)

    var i = 0
    breakable {
      for (list <- buffer1) {
        i += 1
        if (i == 4)
          break
        println(list.head, list.size)
      }
    }
  }
}
