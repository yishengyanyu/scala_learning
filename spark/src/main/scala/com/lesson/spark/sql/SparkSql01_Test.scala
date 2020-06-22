package com.lesson.spark.sql

import org.apache.spark.SparkConf
import org.apache.spark.rdd.RDD
import org.apache.spark.sql.{DataFrame, Dataset, Row, SparkSession}

/**
 * @author LiuJing
 * @create 2020-06-10 23:39
 */
object SparkSql01_Test {
  def main(args: Array[String]): Unit = {
    //TODO 创建环境对象
    val sparkConf: SparkConf = new SparkConf().setMaster("local[*]").setAppName("SparkSql")
    //SparkSession无法通过new的方式创建
    val spark: SparkSession = SparkSession.builder().config(sparkConf).getOrCreate()

    val df: DataFrame = spark.read.json("input/user.json")
    import spark.implicits._

    //创建临时视图
    df.createTempView("User1")

    //Sql语法
    spark.sql("select * from User1").show()
    //DSL语法
    //加上$或者使用单引号, 会将字段自动转换为列, 这需要隐式转换实现
    //不加则是字符串
    df.select("name","age").show()
    df.select('name,'age).show()

    val rdd: RDD[(Int, String, Int)] = spark.sparkContext.makeRDD(List(
      (1, "zhangsan", 30),
      (2, "lisi", 20),
      (3, "wangwu", 40))
    )

    //TODO rdd <=> df
    val df1: DataFrame = rdd.toDF("id","name","age")
    //Row:行对象, 有很多方法, 可以通过row得到数据
    val dfTORDD: RDD[Row] = df.rdd
    dfTORDD.foreach(
      row => println(row(0))
    )

    //TODO RDD <=> DS(有结构,有类型,一般通过样例类)
    val userRDD: RDD[User] = rdd.map {
      case (id, name, age) => {
        User(id, name, age)
      }
    }
    val rddToDS: Dataset[User] = userRDD.toDS()
    val dsToRdd: RDD[User] = rddToDS.rdd
    dsToRdd.foreach(println(_))

    //TODO DS <=> DF
    //DataFrame是DataSet的一种特殊情况: type DataFrame = Dataset[Row]
    //RDD关心数据本身,DF更关心数据结构,DS更关心数据类型
    val dsToDF: DataFrame = rddToDS.toDF()
    dsToDF.select('id,'name,'age).show()

    val dfToDS: Dataset[User] = dsToDF.as[User]
    dfToDS.select('id,'name).show()


    spark.stop()
  }

  case class User(id:Int, name:String, age:Int)
}
