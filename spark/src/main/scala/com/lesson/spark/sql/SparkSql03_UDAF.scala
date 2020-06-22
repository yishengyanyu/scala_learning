package com.lesson.spark.sql

import org.apache.spark.SparkConf
import org.apache.spark.rdd.RDD
import org.apache.spark.sql.expressions.{MutableAggregationBuffer, UserDefinedAggregateFunction}
import org.apache.spark.sql.types.{DataType, DoubleType, IntegerType, LongType, StructField, StructType}
import org.apache.spark.sql.{DataFrame, Dataset, Row, SparkSession}

/**
 * @author LiuJing
 * @create 2020-06-12 19:54
 */
object SparkSql03_UDAF {
  def main(args: Array[String]): Unit = {
    val sparkConf: SparkConf = new SparkConf().setMaster("local[*]").setAppName("UDAF-Test")
    val spark: SparkSession = SparkSession.builder().config(sparkConf).getOrCreate()
    import spark.implicits._

    //创建RDD
    val rdd: RDD[(Int, String, Int)] = spark.sparkContext.makeRDD(
      List((1, "zhangsan", 20), (2, "lisi", 30), (3, "wangwu", 40))
    )
    //根据rdd创建DF
    val df: DataFrame = rdd.toDF("id","name","age")
    df.createOrReplaceTempView("user")

    //TODO 自定义UDAF函数(DF) / 自定义强类型UDAF函数(DS)
    //UDAF: User defined aggregate function, 用户自定义聚合函数

    //TODO 自定义函数的使用
    //TODO 1.创建函数对象
    val udaf = new MyAvgAgeUDAF
    //TODO 2.注册函数到SparkSql中
    spark.udf.register("avgAge",udaf)
    //TODO 3.使用函数
    spark.sql("select avgAge(age) as newAge from user").show()



    spark.stop()
  }
  //自定义聚合函数
  //1.继承UserDefinedAggregateFunction
  //2.重写方法
  class MyAvgAgeUDAF extends UserDefinedAggregateFunction{
    //TODO 输入数据的结构信息:年龄信息
    override def inputSchema: StructType = {  //StructType是样例类
      //StructType=>StructField=>DataType(找子类)
      StructType(Array(StructField("age",LongType))) //传入StructField
    }

    //聚合计算都在缓冲区中进行
    //TODO 缓冲区的数据结构信息 ： 年龄的总和，人的数量
    override def bufferSchema: StructType = {
      StructType(Array(StructField("totalAge",LongType),
        StructField("sum",LongType)))
    }

    //TODO 聚合函数返回的结果类型
    override def dataType: DataType = {
      LongType
    }

    //TODO 函数稳定性
    override def deterministic: Boolean = true

    //TODO 函数缓冲区初始化
    override def initialize(buffer: MutableAggregationBuffer): Unit = {
      buffer(0) = 0L
      buffer(1) = 0L
    }

    //TODO 更新缓冲区数据
    override def update(buffer: MutableAggregationBuffer, input: Row): Unit = {
      buffer(0) = buffer.getLong(0) + input.getLong(0)
      buffer(1) = buffer.getLong(1) + 1
    }

    //TODO 合并缓冲区
    override def merge(buffer1: MutableAggregationBuffer, buffer2: Row): Unit = {
      buffer1(0) = buffer1.getLong(0) + buffer2.getLong(0)
      buffer1(1) = buffer1.getLong(1) + buffer2.getLong(1)
    }

    //TODO 函数的计算
    override def evaluate(buffer: Row): Any = {
      buffer.getLong(0) / buffer.getLong(1)
    }

  }
}
