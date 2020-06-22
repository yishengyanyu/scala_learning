package com.lesson.spark.core.rdd.operator

import org.apache.spark.rdd.RDD
import org.apache.spark.{Partitioner, SparkConf, SparkContext}

/**
 * @author LiuJing
 * @create 2020-06-05 14:23
 */
object Spark35_RDD_Operator17 {
  def main(args: Array[String]): Unit = {
    val sparkConf = new SparkConf().setMaster("local[*]").setAppName("File-RDD")

    val sc = new SparkContext(sparkConf)

    //TODO 自定义分区器
    //cba,wnba,nba
    val rdd: RDD[(String, String)] = sc.makeRDD(
      List(("cba", "消息1"), ("nba", "消息2"), ("cba", "消息3"),
        ("nba", "消息4"), ("wnba", "消息5"), ("wnba", "消息6"))
    )
    rdd.partitionBy(new MyPartitioner(3))

    sc.stop()
  }
  //自定义分区器
  //1.和Partitioner发生关联,继承Partitioner
  //2.重写方法
  class MyPartitioner(num:Int) extends Partitioner {

    //获取分区数量
    override def numPartitions: Int = {
      num
    }

    //根据数据的key来决定数据在哪个分区中处理
    //方法的返回值表示分区编号(索引)
    override def getPartition(key: Any): Int = {
      key match {
        case "nba" => 0
        case _ => 1
      }
    }
  }
}
