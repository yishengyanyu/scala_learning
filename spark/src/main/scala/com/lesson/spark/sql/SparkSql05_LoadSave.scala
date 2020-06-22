package com.lesson.spark.sql

import org.apache.spark.SparkConf
import org.apache.spark.sql.{DataFrame, SparkSession}

/**
 * @author LiuJing
 * @create 2020-06-12 14:17
 */
object SparkSql05_LoadSave {
  def main(args: Array[String]): Unit = {
    //TODO 创建环境对象
    val sparkConf: SparkConf = new SparkConf().setMaster("local[*]").setAppName("SparkSql")
    //SparkSession无法通过new的方式创建
    val spark: SparkSession = SparkSession.builder().config(sparkConf).getOrCreate()

    import spark.implicits._

    //TODO SparkSql通用的读取和保存

    //TODO 通用的读取

    //TODO 如果读取的文件格式为JSON格式
    //RuntimeException: xxxxx/input/user.json is not a Parquet file
    //SparkSql通用读取的默认数据为Parquet列式存储格式,所以会报错
    //val frame: DataFrame = spark.read.load("input/users.parquet")
    //如果想要改变读取文件的格式。需要使用特殊的操作
    //JSON => JavaScript Object Notation
    //JSON文件格式要求整个文件满足JSON的语法规则
    //Spark默认以行为单位进行读取
    //Spark读取JSON文件时，要求文件中的每一行符合JSON的格式要求, 即使不满足JSON格式(每1行1个大括号)
    //如果文件格式不正确，那么不会发生错误，但是解析结果不正确
    //例如使用[]和{},读出的数据有误
    //JSON文件本身多条数据写法
    val df: DataFrame = spark.read.format("json").load("input/user.json")
    df.show()

    //spark.read.load("input/1.json") //报错

    val frame: DataFrame = spark.read.format("json").load("input/1.json")
    frame.show()

    spark.stop()
  }
}
