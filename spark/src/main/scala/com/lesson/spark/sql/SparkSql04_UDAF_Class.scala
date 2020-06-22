package com.lesson.spark.sql

import org.apache.spark.SparkConf
import org.apache.spark.sql.expressions.{Aggregator, MutableAggregationBuffer, UserDefinedAggregateFunction}
import org.apache.spark.rdd.RDD
import org.apache.spark.sql.{DataFrame, Dataset, Encoder, Encoders, SparkSession, TypedColumn}

/**
 * @author LiuJing
 * @create 2020-06-12 20:40
 */
object SparkSql04_UDAF_Class {
  def main(args: Array[String]): Unit = {
    val sparkConf: SparkConf = new SparkConf().setMaster("local[*]").setAppName("UDAF-Test")
    val spark: SparkSession = SparkSession.builder().config(sparkConf).getOrCreate()
    import spark.implicits._

    //创建RDD
    val rdd: RDD[(Int, String, Int)] = spark.sparkContext.makeRDD(
      List((1, "zhangsan", 20), (2, "lisi", 30), (3, "wangwu", 40))
    )
    //根据rdd创建DS
    val ds: Dataset[User] = rdd.map {
      case (id, name, age) => User(id, name, age)
    }.toDS()  //DS:将数据整体全部变为User对象

    //创建UDAF函数
    val udaf = new MyAvgAgeUDAFClass
    // TODO 在SQL中使用聚合函数
    //假设可以用,那么函数括号中传入的参数怎么编程User对象?,所以用不了
    // 因为聚合函数是强类型，那么sql中没有类型的概念，所以无法使用
    // 可以采用DSL语法方法进行访问, 将整条语句当成对象
    // 将聚合函数转换为查询的列让DataSet访问

    val column: TypedColumn[User, Long] = udaf.toColumn
    //将整个类型传入其中
    ds.select(column).show()

    spark.stop()
  }

  case class User(id:Int,name:String,age:Long)

  case class AvgBuffer(var totalage:Long, var count:Long)
  //自定义聚合函数 - 强类型
  //指定了类型,降低了出错的可能性
  // 1. 继承Aggregator, 定义泛型
  //      -IN : 输入数据的类型 User
  //      BUF : 缓冲区的数据类型 AvgBuffer
  //      OUT : 输出数据的类型 Long
  // 2. 重写方法
  class MyAvgAgeUDAFClass extends Aggregator[User,AvgBuffer,Long]{
    //TODO 缓冲区的初始值
    override def zero: AvgBuffer = {
      AvgBuffer(0L,0L)
    }

    //TODO 聚合数据
    override def reduce(b: AvgBuffer, a: User): AvgBuffer = {
      b.totalage = b.totalage + a.age
      b.count = b.count + 1
      b
    }

    //TODO 合并缓冲区
    override def merge(b1: AvgBuffer, b2: AvgBuffer): AvgBuffer = {
      b1.totalage = b1.totalage + b2.totalage
      b1.count = b1.count + b2.count
      b1
    }

    //TODO 计算函数的结果
    override def finish(reduction: AvgBuffer): Long = {
      reduction.totalage / reduction.count
    }

    //缓冲区编码,固定写法,自己定义的对象应该写Encoders.product
    override def bufferEncoder: Encoder[AvgBuffer] = Encoders.product

    //输出编码,按照实际输出的类型
    override def outputEncoder: Encoder[Long] = Encoders.scalaLong
  }
}
