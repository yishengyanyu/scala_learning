package com.lesson.chapter7

/**
 * @author LiuJing
 * @create 2020-05-29 17:55
 */
object Scala21_Collection_WordCount1 {
  def main(args: Array[String]): Unit = {
    // (word, count)
    val dataList = List("hello scala", "hello spark", "hive hadoop")

    // string => word
    // 完整的方法
    //map切分数据之后形成数组,需要使用flatten扁平化
    val words: List[String] = dataList.flatMap(_.split(" "))
    val groupList: Map[String, List[String]] = words.groupBy(word => word)
    //count处理
    val countMap: Map[String, Int] = groupList.map(kv => {(kv._1,kv._2.size)})
    //按照count排序
    //函数柯里化可以省略参数列表
    val sortList: List[(String, Int)] = countMap.toList.sortBy(t => t._2)(Ordering.Int.reverse)
    //取前三
    val result: List[(String, Int)] = sortList.take(3)

    //简化的方法
    //方法链
    val result1: List[(String, Int)] = dataList
      .flatMap(_.split(" "))
      .groupBy(word => word)
      .map(kv => {
        (kv._1, kv._2.size)
      })
      .toList.sortBy(t => t._2)(Ordering.Int.reverse)
      .take(3)
    println(result1)

  }
}
