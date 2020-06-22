package com.lesson.spark.sql

import org.apache.spark.SparkConf
import org.apache.spark.sql.{DataFrame, SparkSession}

/**
 * @author LiuJing
 * @create 2020-06-12 15:24
 */
object SparkSql08_Load_CSV {
  def main(args: Array[String]): Unit = {
    // TODO 创建环境对象
    val sparkConf = new SparkConf().setMaster("local[*]").setAppName("sparkSQL")
    // builder 构建，创建
    val spark = SparkSession.builder().config(sparkConf).getOrCreate()
    // 导入隐式转换，这里的spark其实是环境对象的名称
    import spark.implicits._

    //csv文件第一行是数据的结构信息
    val frame: DataFrame = spark.read.format("csv")
      .option("sep", ";")
      .option("inferSchema", "true")
      .option("header", "true")
      .load("input/user.csv")
    frame.show()

    spark.stop()
  }
}
