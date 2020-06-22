package com.lesson.spark.sql

import org.apache.spark.SparkConf
import org.apache.spark.rdd.RDD
import org.apache.spark.sql.{DataFrame, Dataset, Row, SparkSession}

/**
 * @author LiuJing
 * @create 2020-06-12 18:33
 */
object SparkSql02_Test1 {
  def main(args: Array[String]): Unit = {
    val conf: SparkConf = new SparkConf().setMaster("local[*]").setAppName("SparkSql")
    val spark: SparkSession = SparkSession.builder().config(conf).getOrCreate()

    // 导入隐式转换，这里的spark其实是环境对象的名称
    // 要求这个对象必须使用val声明
    //原因,版本扩展增加功能,需要额外增加方法, 为了遵循OCP开发原则, 采用implicit增加功能
    //所用的SparkSql必须增加这一步
    import spark.implicits._
    //逻辑操作
    //创建RDD
    val rdd: RDD[(Int, String, Int)] = spark.sparkContext.makeRDD(
      List(
        (1, "zhangsan", 30), (2, "lisi", 20), (3, "wangwu", 40)
      )
    )
    val userDS: Dataset[User] = rdd.map {
      case (id, name, age) => User(id, name, age)
    }.toDS()

    //TODO SparkSql封装的对象提供了大量的方法进行数据处理,类似于RDD的算子操作
//    userDS.join()
//    userDS.reduce()
//    userDS.groupByKey()
//    userDS.agg()
//    userDS.coalesce()
//    userDS.repartition()

    //创建DF
    val df: DataFrame = rdd.toDF("id","name","age")
    //创建DS
    //val ds: Dataset[User] = df.as[User]

    //TODO 改变一下其中的某个列数据的形式
    //方式一: 报错
//    val ds: Dataset[Row] = df.map(row => {  //map里面的参数为Row类型
//      val id: Any = row(0)
//      val name: Any = row(1)
//      val age: Any = row(2)
//      Row(id, "name : " + name, age)  //将df的每一行进行转换
//    })

    //方式二:成功改变输出的数据形式
    val newDS: Dataset[User] = userDS.map( //map里面的参数类型为User
      user => User(user.id, "Name: "+user.name, user.age )
    )
    newDS.show()

    //做map()时,尽量使用DataSet, 因为map中有Encoder(编码)操作
    //在可见的未来,尽量使用DataSet

    //方式三:UDF
    //TODO 使用自定义函数在SQL中完成数据的转换操作
    //在某个列的数据前面加上"Name: "字段
    spark.udf.register("addName",(x:String) => "Name: "+x)
    //使数据类型为Int的某个列的数据数值+1
    spark.udf.register("changeAge", (x:Int) => 18)
    //用法:
    //创建临时视图
    df.createOrReplaceTempView("user")
    spark.sql("select id,addName(name),changeAge(age) from user").show()


    spark.stop()
  }

  case class User(id:Int, name:String, age:Int)
}
