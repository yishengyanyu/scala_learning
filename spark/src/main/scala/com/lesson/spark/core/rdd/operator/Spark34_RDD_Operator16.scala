package com.lesson.spark.core.rdd.operator

import org.apache.spark.rdd.RDD
import org.apache.spark.{HashPartitioner, SparkConf, SparkContext}

/**
 * @author LiuJing
 * @create 2020-06-05 11:47
 */
object Spark34_RDD_Operator16 {
  def main(args: Array[String]): Unit = {
    //TODO Spark - 算子(方法)
    val sparkConf = new SparkConf().setMaster("local[*]").setAppName("File-RDD")

    val sc = new SparkContext(sparkConf)

    //TODO K-V类型的数据操作

    val rdd: RDD[(String, Int)] = sc.makeRDD(List(("a",1),("b",2),("c",3)),1)

    //Spark中很多的方法是基于Key进行操作的,所以数据格式应该为键值对(对偶元组)
    //如果数据类型为K-V类型,那么Spark会给RDD补充很多新的功能(扩展)

    //partitionBy对象为分区器
    //  分区器对象:HashPartitioner & RangePartitioner

    //HashPartitioner的分区规则:将当前数据的key的hashcode进行取余操作
    //HashPartitioner是Spark的默认分区器
    val rdd1: RDD[(String, Int)] = rdd.partitionBy(new HashPartitioner(2))

    //rdd1.saveAsTextFile("output")

    //sortBy底层使用了RangePartitioner
    //RangePartitioner要求数据的key必须能够排序,用的不多
//    rdd1.sortBy()

    sc.stop()
  }
}
