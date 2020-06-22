package com.lesson.spark.sql

import org.apache.spark.SparkConf
import org.apache.spark.sql.{DataFrame, SaveMode, SparkSession}

/**
 * @author LiuJing
 * @create 2020-06-12 22:16
 */
object SparkSql10_Save_MySql {
  def main(args: Array[String]): Unit = {
    // TODO 创建环境对象
    val sparkConf = new SparkConf().setMaster("local[*]").setAppName("sparkSQL")
    // builder 构建，创建
    val spark = SparkSession.builder().config(sparkConf).getOrCreate()
    // 导入隐式转换，这里的spark其实是环境对象的名称

    val frame: DataFrame = spark.read.format("jdbc")
      .option("url", "jdbc:mysql://Hadoop102:3306/spark")
      .option("driver", "com.mysql.jdbc.Driver")
      .option("user", "root")
      .option("password", "lj19955991")
      .option("dbtable", "user")
      .load()

    //连接方式保持不变
    //没有主键,不会报错
    frame.write.format("jdbc")
      .option("url", "jdbc:mysql://Hadoop102:3306/spark-sql")
      .option("driver", "com.mysql.jdbc.Driver")
      .option("user", "root")
      .option("password", "lj19955991")
      .option("dbtable", "user1")
      .mode(SaveMode.Append)  //表已经存在,追加  枚举类
      .save()

    spark.stop
  }
}
