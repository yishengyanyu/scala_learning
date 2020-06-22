package com.lesson.spark.core.rdd.operator

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
 * @author LiuJing
 * @create 2020-06-06 9:30
 */
object Spark42_RDD_Operator24 {
  def main(args: Array[String]): Unit = {
    //TODO Spark - 双value数据操作
    val sparkConf = new SparkConf().setMaster("local[*]").setAppName("File-RDD")

    val sc = new SparkContext(sparkConf)

//    val rdd: RDD[(String, Int)] = sc.makeRDD(
//      List(
//        ("a", 9), ("b", 4),("e",6), ("c", 9)
//      )
//    )

    //其实就是sortBy,只不过约定用key排序
    //降序:false, 升序:true
    //也可以加上分区
    //可以不用传参,默认升序

    //Java中的比较器可以在Scala中使用
    val rdd: RDD[(User, Int)] = sc.makeRDD(
      List(
        (new User, 1),
        (new User, 2),
        (new User, 3)
      )
    )
    val sortRDD = rdd.sortByKey(false)

    sortRDD.collect().foreach(println)

    sc.stop()
  }

  //如果自定义的key进行排序,需要将key混入特质Ordered,否则无法使用sortByKey
  class User extends Ordered[User] with Serializable {
    override def compare(that: User): Int = {
      1
    }
  }
}
