package com.lesson.spark.sql

import org.apache.spark.SparkConf
import org.apache.spark.sql.SparkSession

/**
 * @author LiuJing
 * @create 2020-06-12 14:58
 */
object SparkSql07_LoadSave2 {
  def main(args: Array[String]): Unit = {
    // TODO 创建环境对象
    val sparkConf = new SparkConf().setMaster("local[*]").setAppName("sparkSQL")
    // builder 构建，创建
    val spark = SparkSession.builder().config(sparkConf).getOrCreate()

    //TODO SparkSQL通用的读取和保存

    // TODO 通用的读取(Sql语法)
    //路径加飘号
    spark.sql("select * from json.`input/user.json`").show()

    spark.stop()
  }
}
