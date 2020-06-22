package com.lesson.spark.core.acc

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
 * @author LiuJing
 * @create 2020-06-08 15:41
 */
object Spark64_BC {
  def main(args: Array[String]): Unit = {
    val sparkConf: SparkConf = new SparkConf().setMaster("local[*]").setAppName("acc")
    val sc = new SparkContext(sparkConf)

    //TODO 广播变量

    //join有笛卡尔积效果,数据量急剧增多,如果有shuffle操作,那么性能会非常低
    val rdd1: RDD[(String, Int)] = sc.makeRDD(List(("a",1),("b",2),("c",3)))
    val rdd2: RDD[(String, Int)] = sc.makeRDD(List(("a",1),("b",2),("c",3)))

    //(a,(1,1)),(b,(2,2)),(c,(3,3))
    val joinRDD: RDD[(String, (Int, Int))] = rdd1.join(rdd2)

    joinRDD.collect().foreach(println)
    sc.stop()
  }
}
