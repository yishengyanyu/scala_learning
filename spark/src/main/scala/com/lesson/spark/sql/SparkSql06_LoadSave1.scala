package com.lesson.spark.sql

import org.apache.spark.SparkConf
import org.apache.spark.sql.{DataFrame, SparkSession}

/**
 * @author LiuJing
 * @create 2020-06-12 14:41
 */
object SparkSql06_LoadSave1 {
  def main(args: Array[String]): Unit = {
    //TODO 创建环境对象
    val sparkConf: SparkConf = new SparkConf().setMaster("local[*]").setAppName("SparkSql")
    //SparkSession无法通过new的方式创建
    val spark: SparkSession = SparkSession.builder().config(sparkConf).getOrCreate()

    import spark.implicits._

    //TODO SparkSql通用保存和读取

    //TODO 通用的保存
    val df: DataFrame = spark.read.format("json").load("input/user.json")

    //TODO SparkSql默认通用保存的文件格式为parquet
    //如果想要保存的格式是指定的格式,比如json,可以在保存时指定文件格式
    //如果路径已经存在, 那么执行保存操作会发生错误,如下:
    // AnalysisException: path /classes-0213/output already exists.;
    //错误试验
    //df.write.save("output")

    df.write.format("json").save("output")
    //如果非要在已经存在的路径下保存文件,那么可以使用保存模式
    //覆盖
    df.write.mode("overwrite").format("json").save("output")

    //追加
    df.write.mode("append").format("json").save("output")

    //忽略
    df.write.mode("ignore").format("json").save("output")

    //错误:error(默认情况)
    df.write.mode("error").format("json").save("output")

    spark.stop()
  }
}
