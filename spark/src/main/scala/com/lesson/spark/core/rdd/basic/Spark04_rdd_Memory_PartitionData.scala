package com.lesson.spark.core.rdd.basic

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
 * @author LiuJing
 * @create 2020-06-03 10:31
 */
object Spark04_rdd_Memory_PartitionData {
  def main(args: Array[String]): Unit = {
    //TODO Scala
    //  1.泛型
    //  2.方法的重写
    //  3.伴生对象
    //  4.模式匹配
    //  5.map

    val sparkConf: SparkConf = new SparkConf().setMaster("local[*]").setAppName("wordCount")
    val sc = new SparkContext(sparkConf)

    //TODO 内存中的集合数据按照平均分的方式进行分区处理
    val rdd: RDD[Int] = sc.makeRDD(List(1,2,3,4),2)
    //12,34
    rdd.saveAsTextFile("output")

    val rdd1: RDD[Int] = sc.makeRDD(List(1,2,3,4),4)
    //1,2,3,4
    rdd1.saveAsTextFile("output1")

    //TODO saveTextFile方法的文件路径已经存在,会发生错误
    //TODO 内存中集合的数据如果不能平均分, 则多余的数据放在最后一个分区
    //TODO 内存中数据的分区基本上是平均分, 如果不能整除, 会采用一个基本算法进行分配

    //List(1,2,3,4,5) => Array(1,2,3,4,5)
    //(array.length, numSlices)
    //(0,1,2)迭代 => 0,1,2
    //0 => (0,1) => 1
    //1 => (1,3) => 2,3
    //2 => (3,5) => 4,5
    // 确定了每个数据对应的分区索引位置
    //Array.slice() => 切分数组 => [from,until)
    val rdd2: RDD[Int] = sc.makeRDD(List(1,2,3,4,5),3)
    //1,23,45
    rdd2.saveAsTextFile("output2")

    sc.stop()
  }
}
