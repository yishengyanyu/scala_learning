package com.lesson.spark.core.rdd.serial

import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.rdd.RDD

/**
 * @author LiuJing
 * @create 2020-06-06 14:36
 */
object Spark52_Serial {
  def main(args: Array[String]): Unit = {
    val sparkConf = new SparkConf().setMaster("local[*]").setAppName("File-RDD")

    val sc = new SparkContext(sparkConf)

    //Spark的序列化
//    val rdd: RDD[Int] = sc.makeRDD(List(1,2,3,4))
//    rdd.foreach(
//      num => {
//        val user = new User()
//        println("age = " + (user.age + num))  //21,22,23,24
//      }
//    )

    //TODO Exception: Task not serializable
    //  原因:User从Driver传到了Executor,需要序列化
    //  分布式环境需要考虑传输序列化问题
    //如果算子中使用了算子外的一些对象,那么在执行时,需要保证这个对象能够序列化
//    val user = new User()
//    val rdd: RDD[Int] = sc.makeRDD(List(1,2,3,4))
//    rdd.foreach(
//      num => {
//        println("age = " + (user.age + num))
//      }
//    )

    //TODO  闭包
    val user = new User()
    //空集合没有走到user,为什么还报错
    val rdd: RDD[Int] = sc.makeRDD(List())

    //Spark的算子的操作其实都是闭包,所以闭包有可能含有外部的变量
    //如果包含外部的变量,那么一定要保证这个变量可序列化
    //Spark提交作业之前,需要对闭包内的变量进行检测,检测是否能够序列化
    //将这个操作成为闭包检测
    //源码
    rdd.foreach(
      num => {
        println("age = " + (user.age + num))
      }
    )

    sc.stop()
  }

  class User{
    val age  : Int = 20
  }

  //样例类自动混入可序列化特质
  //case class User(val age:Int = 20)
}
