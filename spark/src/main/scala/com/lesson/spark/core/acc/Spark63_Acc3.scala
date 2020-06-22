package com.lesson.spark.core.acc

import org.apache.spark.rdd.RDD
import org.apache.spark.util.AccumulatorV2
import org.apache.spark.{SparkConf, SparkContext}

import scala.collection.mutable

/**
 * @author LiuJing
 * @create 2020-06-08 14:26
 */
object Spark63_Acc3 {
  def main(args: Array[String]): Unit = {
    val sparkConf: SparkConf = new SparkConf().setMaster("local[*]").setAppName("acc")
    val sc = new SparkContext(sparkConf)

    //TODO 累加器 - WordCount
    val rdd: RDD[String] = sc.makeRDD(List("hello scala","spark","hive","hello","scala"))

    //TODO 1.创建累加器
    val acc = new MyWordCountAccumulator

    //TODO 2.注册累加器
    sc.register(acc)

    //TODO 3.使用累加器
    //闭包
    rdd.flatMap(_.split(" ")).foreach(
      word => {
        acc.add(word)
      }
    )

    //TODO 4.获取累加器的值
    println(acc.value)

    sc.stop()

  }

  //TODO 自定义累加器
  //  1.继承AccumulatorV2, 定义泛型[IN,OUT]
  //    IN:累加器输入的值的类型
  //    OUT:累加器返回的结果的类型
  //  2.重写方法
  //  3.不初始化会报错:copyAndReset must return a zero value copy
  //    序列化的时候调用前三个方法

  class MyWordCountAccumulator extends AccumulatorV2[String,mutable.Map[String,Int]]{

    //存储wordCount的集合
    var wordCountMap = mutable.Map[String, Int]()

    //TODO 累加器是否初始化
    override def isZero: Boolean = {
      !wordCountMap.isEmpty  //没东西就是初始化状态
    }

    //TODO 复制累加器
    override def copy(): AccumulatorV2[String, mutable.Map[String, Int]] = {
      new MyWordCountAccumulator
    }

    //TODO 重置累加器
    override def reset(): Unit = {
      wordCountMap.clear()
    }

    //TODO 向累加器中增加值
    override def add(word: String): Unit = {
      wordCountMap(word) = wordCountMap.getOrElse(word,0) + 1
    }

    //TODO 合并当前累加器和其他累加器
    //     合并累加器
    override def merge(other: AccumulatorV2[String, mutable.Map[String, Int]]): Unit = {
      var map1 = wordCountMap
      val map2 = other.value
      wordCountMap = map1.foldLeft(map2){
        (map,kv) => {
          map(kv._1) = map.getOrElse(kv._1,0) + kv._2
          map
        }
      }
    }

    //TODO 返回累加器的值(OUT)
    override def value: mutable.Map[String, Int] = wordCountMap
  }
}
