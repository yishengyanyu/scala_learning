package com.lesson.spark.core.rdd.action

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
 * @author LiuJing
 * @create 2020-06-06 11:43
 */
object Spark47_RDD_Operator_Action1 {
  def main(args: Array[String]): Unit = {
    //TODO Spark - 行动算子

    val sparkConf = new SparkConf().setMaster("local[*]").setAppName("File-RDD")

    val sc = new SparkContext(sparkConf)

    val rdd: RDD[Int] = sc.makeRDD(List(1,2,3,4),2)

    //TODO reduce
    //简化规约
    val i: Int = rdd.reduce(_+_)

    //TODO collect
    //采集数据
    //将所有分区的计算结果拉取到当前节点(Driver)内存中,可能出现内存溢出
    val array: Array[Int] = rdd.collect()

    //TODO count
    //表示当前处理的数据集的元素数量
    val l: Long = rdd.count()

    //TODO first
    //返回处理的数据集合的第一个元素
    val i1: Int = rdd.first()

    //TODO take
    //返回一个由RDD的前n个元素组成的数组
    val array1: Array[Int] = rdd.take(3)

    println(i)

    sc.stop()
  }
}
