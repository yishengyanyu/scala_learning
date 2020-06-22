package com.lesson.chapter7

/**
 * @author LiuJing
 * @create 2020-05-29 18:10
 */
object Scala22_Collection_WordCount2 {
  def main(args: Array[String]): Unit = {
    val list = List(
      ("hello", 4),
      ("hello spark", 3),
      ("hello spark scala", 2),
      ("hello spark scala hive", 1)
    )
    //思路: 先拆成一个个的单词,然后进行分组,计数,排序处理

    //TODO 字符串可以重复出现
    //("hello", 4) => "hello hello hello hello"
    val dataList: List[String] = list.map(kv => (kv._1 + " ") * kv._2)

//  string => word
//  完整的方法
//    val words: List[String] = dataList.flatMap(string=>{string.split(" ")})
//    val wordToWords: Map[String, List[String]] = words.groupBy(word=>word)
//    // List => size(count)
//    val wordToCount: Map[String, Int] = wordToWords.map( kv => { ( kv._1, kv._2.size ) } )
//    // 函数柯里化可以省略参数列表
//    val result: List[(String, Int)] = wordToCount.toList.sortBy(kv=>kv._2)(Ordering.Int.reverse).take(3)

    // 简化的方法
    // 方法链
    val result: List[(String, Int)] = dataList
      .flatMap(_.split(" "))
      .groupBy(word => word)
      .map(kv => {
        (kv._1, kv._2.size)
      })
      .toList.sortBy(t => t._2)(Ordering.Int.reverse)
      .take(3)
    println(result)

  }
}
