package com.lesson.spark.sql

import org.apache.spark.SparkConf
import org.apache.spark.sql.SparkSession

/**
 * @author LiuJing
 * @create 2020-06-12 23:59
 */
object SparkSql13_Req_Mock {
  def main(args: Array[String]): Unit = {
    System.setProperty("HADOOP_USER_NAME", "root")
    // TODO 创建环境对象
    val sparkConf = new SparkConf().setMaster("local[*]").setAppName("sparkSQL")
    // builder 构建，创建

    // TODO 访问外置的Hive
    val spark = SparkSession.builder()
      .enableHiveSupport()
      .config(sparkConf).getOrCreate()
    import spark.implicits._

    spark.sql("use spark")

    spark.sql(
      """
        |CREATE TABLE `user_visit_action`(
        |  `date` string,
        |  `user_id` bigint,
        |  `session_id` string,
        |  `page_id` bigint,
        |  `action_time` string,
        |  `search_keyword` string,
        |  `click_category_id` bigint,
        |  `click_product_id` bigint,
        |  `order_category_ids` string,
        |  `order_product_ids` string,
        |  `pay_category_ids` string,
        |  `pay_product_ids` string,
        |  `city_id` bigint)
        |row format delimited fields terminated by '\t'
            """.stripMargin)

    spark.sql(
      """
        |load data local inpath 'input/user_visit_action.txt' into table atguigu200213.user_visit_action
            """.stripMargin)

    spark.sql(
      """
        |CREATE TABLE `product_info`(
        |  `product_id` bigint,
        |  `product_name` string,
        |  `extend_info` string)
        |row format delimited fields terminated by '\t'
            """.stripMargin)

    spark.sql(
      """
        |load data local inpath 'input/product_info.txt' into table atguigu200213.product_info
            """.stripMargin)

    spark.sql(
      """
        |CREATE TABLE `city_info`(
        |  `city_id` bigint,
        |  `city_name` string,
        |  `area` string)
        |row format delimited fields terminated by '\t'
            """.stripMargin)

    spark.sql(
      """
        |load data local inpath 'input/city_info.txt' into table atguigu200213.city_info
            """.stripMargin)

    spark.sql(
      """
        |select * from city_info
            """.stripMargin).show(10)


    spark.stop
  }
}
