package com.lesson.spark.core.rdd.basic

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
 * @author LiuJing
 * @create 2020-06-03 11:33
 */
object Spark06_RDD_File_PartitionData {
  def main(args: Array[String]): Unit = {

    val sparkConf: SparkConf = new SparkConf().setMaster("local[*]").setAppName("wordCount")
    val sc = new SparkContext(sparkConf)

    //TODO Spark - 从磁盘(file)中创建RDD

    //1.Spark读取文件采用Hadoop的读取规则
    //  文件切片规则: 以字节方式切片
    //  数据读取规则: 以行为单位读取

    //2.问题
    //  TODO 文件到底切成几片(分区数量)
    //  文件字节数（10），预计切片数量（2）
    //  换行符2个字节,一个数字1个字节
    //  10 / 2 => 5byte
    // totalSize = 10
    // goalSize = totalSize / numSplits = 10 / 2 = 5 ...1 => 3
    //   所谓的最小分区数，取决于总的字节数是否能整除分区数并且剩余的字节达到一个比率(10%)
    //   实际产生的分区数量可能大于最小分区数

    //   TODO 分区的数据如何存储？
    //   分区数据是以行为单位读取的，而不是字节
    val fileRDD1: RDD[String] = sc.textFile("input/w.txt", 2)
    fileRDD1.saveAsTextFile("output")
    sc.stop()
  }
}
