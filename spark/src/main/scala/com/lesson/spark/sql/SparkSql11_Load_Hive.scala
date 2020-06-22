package com.lesson.spark.sql

import org.apache.spark.SparkConf
import org.apache.spark.sql.SparkSession

/**
 * @author LiuJing
 * @create 2020-06-12 22:23
 */
object SparkSql11_Load_Hive {
  def main(args: Array[String]): Unit = {
    // TODO 创建环境对象
    val sparkConf = new SparkConf().setMaster("local[*]").setAppName("sparkSQL")
    // builder 构建，创建

    // TODO 默认情况下SparkSQL支持本地Hive操作的，执行前需要启用Hive的支持
    // 调用enableHiveSupport方法,启用Hive的支持
    val spark = SparkSession.builder()
      .enableHiveSupport()
      .config(sparkConf).getOrCreate()
    // 导入隐式转换，这里的spark其实是环境对象的名称

    // 可以使用基本的sql访问hive中的内容
//    spark.sql("create table aa(id int)")
    //启用Hive会在当前目录生成warehouse文件夹
//    spark.sql("show tables").show()
    //使用内置Hive不得有外置Hive配置
    //如果版本正确却出现版本不兼容, 可以刷新一下
    spark.sql("load data local inpath 'input/id.txt' into table aa")
    spark.sql("select * from aa").show

    spark.stop
  }
}
