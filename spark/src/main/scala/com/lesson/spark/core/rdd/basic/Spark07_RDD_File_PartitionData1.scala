package com.lesson.spark.core.rdd.basic

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
 * @author LiuJing
 * @create 2020-06-04 23:15
 */
object Spark07_RDD_File_PartitionData1 {
  def main(args: Array[String]): Unit = {

    // TODO Scala


    val sparkConf = new SparkConf().setMaster("local[*]").setAppName("File - RDD")
    val sc = new SparkContext(sparkConf)

    // TODO  Spark - 从磁盘（File）中创建RDD

    // TODO 1. 分几个区？
    //    10 byte / 4 = 2byte...2byte => 5
    //     读取数据的偏移量(包含两端)
    //    0 => (0, 2)
    //    1 => (2, 4)
    //    2 => (4, 6)
    //    3 => (6, 8)
    //    4 => (8,10)
    // TODO 2. 数据如何存储?
    //    数据是以行的方式读取，但是会考虑偏移量（数据的offset）的设置
    //    1@@ => 012
    //    2@@ => 345
    //    3@@ => 678
    //    4   => 9
    //    实际读取情况
    //    0 => (0, 2) => 1(读取了012)
    //    1 => (2, 4) => 2(从2开始读,但是按行读取,2已经读了,换行从3开始读)
    //    2 => (4, 6) => 3(从4开始读,但是偏移量4所在的行已经读取,实际读取偏移量6所在的行)
    //    3 => (6, 8) =>    (6,7,8已经被分区2读完了,不会再读取)
    //    4 => (8,10) => 4

    val fileRDD1: RDD[String] = sc.textFile("input/w.txt", 4)
    fileRDD1.saveAsTextFile("output")
    sc.stop()
  }
}
