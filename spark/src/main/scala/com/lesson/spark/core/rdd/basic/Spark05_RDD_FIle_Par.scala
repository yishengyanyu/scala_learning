package com.lesson.spark.core.rdd.basic

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
 * @author LiuJing
 * @create 2020-06-03 11:19
 */
object Spark05_RDD_FIle_Par {
  def main(args: Array[String]): Unit = {

    // TODO Scala
    // 1. math.min
    // 2. math.max

    val sparkConf: SparkConf = new SparkConf().setMaster("local[*]").setAppName("File - RDD")
    val sc = new SparkContext(sparkConf)

    //TODO Spark - 从磁盘(file)中创建RDD

    //textFile 第一个参数表示读取的文件路径
    //textFile 第二个参数表示最小分区数量
    //  默认值为:math.min(defaultParallelism,2)
    //          math.min(4,2) => 2

    //12,34
    val fileRDD1: RDD[String] = sc.textFile("input/w.txt")
    fileRDD1.saveAsTextFile("output1")

    //1234
    val fileRDD2: RDD[String] = sc.textFile("input/w.txt",1)
    fileRDD2.saveAsTextFile("output2")

    //1,2,3,空,4
    val fileRDD3: RDD[String] = sc.textFile("input/w.txt",4)
    fileRDD3.saveAsTextFile("output3")

    //(1,2),3,4,空
    val fileRDD4: RDD[String] = sc.textFile("input/w.txt",3)
    fileRDD4.saveAsTextFile("output4")

    sc.stop()
  }
}
