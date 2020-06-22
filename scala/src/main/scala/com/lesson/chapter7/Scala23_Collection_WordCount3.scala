package com.lesson.chapter7

/**
 * @author LiuJing
 * @create 2020-05-29 18:18
 */
object Scala23_Collection_WordCount3 {
  def main(args: Array[String]): Unit = {
    val list = List(
      ("hello", 4),
      ("hello spark", 3),
      ("hello spark scala", 2),
      ("hello spark scala hive", 1)
    )

    val tupleList: List[(String, Int)] = list.flatMap(
      kv => {
        val count = kv._2
        val str = kv._1
        val words: Array[String] = str.split(" ")
        words.map(
          s => (s, count)
        )
      }
    )
    val groupList: Map[String, List[(String, Int)]] = tupleList.groupBy(_._1)

    //TODO 在kv数据处理过程中，如果k保持不变，只对v进行处理，可以采用特殊的方法
    //mapValues方法表示:对值进行操作
    val wordToSumMap: Map[String, Int] = groupList.mapValues(
      v => {
        val ints: List[Int] = v.map(_._2)
        ints.sum
      }
    )

    val result: List[(String, Int)] = wordToSumMap
      .toList
      .sortBy(_._2)(Ordering.Int.reverse)
      .take(3)
    println(result)
  }
}
