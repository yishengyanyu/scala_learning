package com.lesson.spark.core.wordcount

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
 * @author LiuJing
 * @create 2020-06-01 22:44
 */
object Spark02_WordCount1 {
  def main(args: Array[String]): Unit = {
    // TODO Spark - WordCount
    // Spark是一个计算框架,依托于框架的API实现计算功能
    // 开发人员是使用Spark框架的API实现计算功能。

    // TODO 1.准备Spark环境
    //SparkConf:Spark配置
    // setMaster : 设定Spark环境的位置(框架在哪)
    //setAppName:应用程序的名称
    val sparkConf: SparkConf = new SparkConf().setMaster("local").setAppName("wordCount")

    //TODO 2.建立和Spark的连接
    //jdbc:connection
    //建立连接, 和谁建立连接?sparkConf,和本地环境建立连接
    val sc = new SparkContext(sparkConf)

    //TODO 3.实现业务操作
    //TODO 3.1 读取文件(可以读取目录,也可以读取目录下的某个文件),获取字符串
    //  参数parth可以指向单一文件,也可以指向文件目录
    //  RDD: 更适合并行计算的数据模型
    //获取到的一行一行的字符串
    val fileRDD: RDD[String] = sc.textFile("input") //2个参数:path 以及 minPartitions

    //TODO 3.2 将读取的数据进行扁平化操作,切分单词
    //将一行一行的字符串进行分解,分解成单词
    //fileRDD.flatMap(line => {line.split(" ")})
    val wordRDD: RDD[String] = fileRDD.flatMap(_.split(" "))

    //TODO 3.3 将分词后的数据进行结构转换
    val mapRDD: RDD[(String, Int)] = wordRDD.map((_,1))


    //TODO 3.4 将转换结构后的数据根据单词进行分组聚合
    //reduceByKey()的作用表示根据数据的key进行分组,然后对value进行聚合
    //reduceByKey()是Spark自带的方法
    val wordToSumRDD: RDD[(String, Int)] = mapRDD.reduceByKey(_+_) //bykey:分组, Reduce:聚合

    //TODO 3.5 将聚合的结果采集后打印到控制台上
    val result: Array[(String, Int)] = wordToSumRDD.collect()
    println(result.mkString(","))

    //TODO 4.释放链接
    sc.stop()
  }
}
