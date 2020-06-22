package com.lesson.chapter7

import scala.io.Source

/**
 * @author LiuJing
 * @create 2020-05-27 14:41
 */
object Scala20_Collection_WordCount {
  def main(args: Array[String]): Unit = {
    //Scala-WordCount
    //需求:将文件中单词统计出现次数并排序取前三名
    //spark => 8种以上的方式实现wordcount
    //所有的统计需求中都可以将大的需求拆分成小的需求,小的需求基本上很多都和wordcount类似

    //代码实现:就是翻译,将文字用代码翻译过来
    //TODO 1.从文件中获取数据,一行一行的字符串
    //可迭代的集合都可以互相转换
    val dataList: List[String] = Source.fromFile("input/word.txt").getLines().toList

    //TODO 2.将一行一行的字符串拆分成一个一个的单词(分词)
    val wordList: List[String] = dataList.flatMap(data => {
      data.split(" ")
    })

    //TODO 3.根据单词将数据进行分组:相同的单词放在一个组中
    val wordGroupMap: Map[String, List[String]] = wordList.groupBy(word=>word)

    //TODO 4.将分组后的数据进行次数统计: word count
    // (word,List(word,word,word)) => (word,count)
    //  A => B
    //  键值对对象其实就是Tuple(元组)
    val wordToCount: Map[String, Int] = wordGroupMap.map(kv => {
      (kv._1, kv._2.length)
    })

    //TODO 5.将统计的结果根据次数进行排序:降序
    //  map是无序的集合,无法排序
    val sortList: List[(String, Int)] = wordToCount.toList.sortBy(kv => kv._2)(Ordering.Int.reverse)

    //TODO 6.将排序后的结果取前三名:Top3
    val result: List[(String, Int)] = sortList.take(3)

    println(result)

  }
}
