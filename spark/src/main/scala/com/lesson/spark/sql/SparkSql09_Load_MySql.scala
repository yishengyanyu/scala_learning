package com.lesson.spark.sql

import org.apache.spark.SparkConf
import org.apache.spark.sql.SparkSession

/**
 * @author LiuJing
 * @create 2020-06-12 21:54
 */
object SparkSql09_Load_MySql {
  def main(args: Array[String]): Unit = {
    // TODO 创建环境对象
    val sparkConf = new SparkConf().setMaster("local[*]").setAppName("sparkSQL")
    // builder 构建，创建
    val spark = SparkSession.builder().config(sparkConf).getOrCreate()
    // 导入隐式转换，这里的spark其实是环境对象的名称
    import spark.implicits._

    spark.read.format("jdbc")
      .option("url", "jdbc:mysql://Hadoop102:3306/spark")
      .option("driver", "com.mysql.jdbc.Driver")
      .option("user", "atguigu")
      .option("password", "lj19955991")
      .option("dbtable", "spark_practice1")
      .load().show

    spark.stop
  }
}
