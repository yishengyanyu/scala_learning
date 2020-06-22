package com.lesson.spark.core.rdd.persist

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
 * @author LiuJing
 * @create 2020-06-08 21:32
 */
object Spark55_Persist {
  def main(args: Array[String]): Unit = {
    val conf: SparkConf = new SparkConf().setMaster("local").setAppName("WordCount")

    val sc = new SparkContext(conf)

    val rdd: RDD[Int] = sc.makeRDD(List(1,2,3,4))

    val mapRDD: RDD[(Int, Int)] = rdd.map(
      num => {
        println("map...")
        (num,1)
      }
    )

    //将计算结果进行缓存,重复使用,提升效率
    //默认的缓存存放在Executor端的内存中,数据量的大的时候,如何处理
    //TODO 缓存cache的底层调用了persist()
    //persist方法在持久化数据时会采用不同的存储级别对数据进行持久化操作
    //cache缓存的默认操作就是将数据保存到内存
    //cache存储的数据在内存中，如果内存不够用，executor可以将内存的数据进行整理，然后可以丢弃数据。
    //如果由于executor端整理内存导致缓存的数据丢失，那么数据操作依然要重头执行。
    //如果cache后的数据重头执行数据操作的话，那么必须要遵循血缘关系，所以cache操作不能删除血缘关系。
    mapRDD.cache()
//    val cacheRDD: RDD[(Int, Int)] = mapRDD.cache()


    //TODO collect
    println(mapRDD.collect().mkString(","))
//    println(cacheRDD.collect().mkString(","))

    mapRDD.saveAsTextFile("output")
    //cacheRDD.saveAsTextFile("output")

    //未缓存的情况下输出了8次map..., 转换了8次
    //解决方式,设置缓存
    //设置缓存的情况下输出了4次map..., 转换了4次, 数据文件没有问题

    sc.stop()
  }
}
