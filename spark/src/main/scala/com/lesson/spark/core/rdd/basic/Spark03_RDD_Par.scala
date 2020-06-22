package com.lesson.spark.core.rdd.basic

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
 * @author LiuJing
 * @create 2020-06-04 17:28
 */
object Spark03_RDD_Par {
  def main(args: Array[String]): Unit = {
    val sparkConf: SparkConf = new SparkConf().setMaster("local").setAppName("wordCount")
    val sc = new SparkContext(sparkConf)

    //TODO Spark - 并行度与分区
    //  Scala: 参数默认值
    //  RDD中分区的数量就是并行度,反过来,设定并行度就是设定分区数量
    //  并行度不一定是分区的数量, 例如当资源不足是,3个Task由1个CPU执行,则并行度为1
    //1.makeRDD的第一个参数: 数据源
    //2.makeRDD的第二个参数: 默认并行度(分区数量)
    //            numSlices: Int = defaultParallelism(并行度)
    //并行度:当前并行执行的任务的个数

    //scheduler.conf.getInt("spark.default.parallelism", totalCores)
    //并行度默认会从spark配置信息中获取spark.default.parallelism值。
    //如果获取不到指定参数，会采用默认值totalCores（机器的总核数）
    //机器总核数 = 当前环境中可用核数
    //local => 单核（单线程）=> 1
    //local[4] => 4核（4个线程） => 4
    //local[*] => 本机核数 => 4
    //设置并行度
    val rdd: RDD[Int] = sc.makeRDD(List(1,2,3,4),2) //分2个区

    println(rdd.collect().mkString(","))

    //将RDD的处理后的数据保存到分区文件中
    rdd.saveAsTextFile("output")

    sc.stop()
  }
}
