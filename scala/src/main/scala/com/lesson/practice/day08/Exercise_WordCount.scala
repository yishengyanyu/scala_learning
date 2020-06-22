package com.lesson.practice.day08

/**
 * @author LiuJing
 * @create 2020-05-28 15:59
 */
object Exercise_WordCount {
  def main(args: Array[String]): Unit = {
    val list = List(("hello", 4),
      ("hello spark", 3),
      ("hello spark scala", 2),
      ("hello spark scala hive", 1))

    //TODO 1.使用映射,取出字符串
    val lists: List[List[String]] = list.map((element) => {
      List.fill[String](element._2)(element._1)
    })
    val strings = lists.flatten
    println(strings)

    //TODO 2.将集合中的字符串拆分成一个一个的单词
    val wordsList: List[String] = strings.flatMap(_.split(" "))

    //TODO 3.根据单词将数据进行分组,相同的单词放在同一个组
    val wordsGroup: Map[String, List[String]] = wordsList.groupBy(word => word)

    //TODO 4.将分组后的单词进行次数统计
    val wordsToCount: Map[String, Int] = wordsGroup.map(kv => {
      (kv._1, kv._2.length)
    })

    //TODO 5.排序
    val sortList: List[(String, Int)] = wordsToCount.toList.sortBy(kv => kv._2)(Ordering.Int.reverse)

    //TODO 6.取前三位
    val finalList: List[(String, Int)] = sortList.take(3)

    println(finalList)
  }
}


