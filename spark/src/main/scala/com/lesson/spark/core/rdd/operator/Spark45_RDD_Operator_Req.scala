package com.lesson.spark.core.rdd.operator

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
 * @author LiuJing
 * @create 2020-06-06 10:37
 */
object Spark45_RDD_Operator_Req {
  def main(args: Array[String]): Unit = {
    //TODO Spark - 算子(方法) - 案例实操

    val sparkConf = new SparkConf().setMaster("local[*]").setAppName("File-RDD")

    val sc = new SparkContext(sparkConf)

    //TODO 统计出每一个省份每个广告被点击数量排行的Top3

    //TODO 1.获取原始数据
    val fileRDD: RDD[String] = sc.textFile("input/agent.log")

    //TODO 2.将原始数据进行结构转换,方便统计
    //  ((省份,广告),1)
    val mapRDD: RDD[(String, Int)] = fileRDD.map(
      line => {
        val words: Array[String] = line.split(" ")
        (words(1) + "-" + words(4), 1)
      }
    )

    //TODO 3.将相同的key的数据进行聚合
    //  ((省份,广告),1) => ((省份,广告),sum)
    val reduceRDD: RDD[(String, Int)] = mapRDD.reduceByKey(_+_)

    //TODO 4.将聚合后的结果进行结构转换
    //  ((省份,广告),sum) => (省份,(广告,sum))
    val mapRDD1: RDD[(String, (String, Int))] = reduceRDD.map {
      case (key, sum) => {
        val keys: Array[String] = key.split("-")
        (keys(0), (keys(1), sum))
      }
    }

    //TODO 5.将相同省份的数据分在一个组中
    //  (省份,iterator[(广告,sum),(广告,sum),...])
    val groupRDD: RDD[(String, Iterable[(String, Int)])] = mapRDD1.groupByKey()

    //TODO 6.将分组后的数据进行排序,取前三
    //  Scala: mapValues
    val sortRDD: RDD[(String, List[(String, Int)])] = groupRDD.mapValues(
      iter => {
        iter.toList.sortWith(
          (left, right) => {
            left._2 > right._2
          }
        ).take(3)
      }
    )

    //TODO 7.将数据采集到控制台打印
    val result: Array[(String, List[(String, Int)])] = sortRDD.collect()

    result.foreach(println)

    sc.stop()
  }
}
