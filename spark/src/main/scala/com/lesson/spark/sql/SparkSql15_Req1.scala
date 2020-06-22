package com.lesson.spark.sql

import org.apache.spark.SparkConf
import org.apache.spark.sql.{Row, SparkSession}
import org.apache.spark.sql.expressions.{MutableAggregationBuffer, UserDefinedAggregateFunction}
import org.apache.spark.sql.types.{DataType, LongType, MapType, StringType, StructField, StructType}

/**
 * @author LiuJing
 * @create 2020-06-13 9:12
 */
object SparkSql15_Req1 {
  def main(args: Array[String]): Unit = {
    System.setProperty("HADOOP_USER_NAME", "root")
    // TODO 创建环境对象
    val sparkConf = new SparkConf().setMaster("local[*]").setAppName("sparkSQL")
    // builder 构建，创建

    // TODO 访问外置的Hive
    val spark = SparkSession.builder()
      .enableHiveSupport()
      .config(sparkConf).getOrCreate()

    spark.sql("use spark")

    //TODO 从Hive表中获取满足条件的数据
    spark.sql(
      """
        |select
        |   a.*,
        |   c.area,
        |   p.product_name,
        |   c.city_name
        |from user_visit_action a
        |join city_info c on c.city_id = a.city_id
        |join product_info p on p.product_id = a.click_product_id
        |where a.click_product_id > -1
            """.stripMargin).createOrReplaceTempView("t1")

    //TODO 将数据根据区域和商品进行分组，统计商品点击的数量
    // 北京，上海，北京，深圳
    //******************************************
    // in : cityname ; String
    // buffer : 2结构，（total, map）
    // out : remark : String
    // （ 商品点击总和， 每个城市点击总和 ）
    // （ 商品点击总和， Map（城市，点击Sum） ）
    // 城市点击sum / 商品点击总和 %
    //TODO 创建自定义聚合函数
    val udaf = new CityRemarkUDAF
    // TODO 注册聚合函数
    spark.udf.register("cityRemark", udaf)

    spark.sql(
      """
        |select
        |    area,
        |    product_name,
        |    count(*) as clickCount,
        |    cityRemark(city_name)
        |from t1 group by area, product_name
            """.stripMargin).createOrReplaceTempView("t2")

    //TODO 将统计结果根据数量进行排序（降序）
    spark.sql(
      """
        |select
        |    *,
        |    rank() over( partition by area order by clickCount desc ) as rank
        |from t2
            """.stripMargin).createOrReplaceTempView("t3")

    //TODO 将组内排序后的结果取前3名
    spark.sql(
      """
        |select
        |   *
        |from t3
        |where rank <= 3
            """.stripMargin).show
    spark.stop()
  }

  class CityRemarkUDAF extends UserDefinedAggregateFunction {
    override def inputSchema: StructType = {
      StructType(Array(StructField("cityName",StringType)))
    }

    override def bufferSchema: StructType = {
      StructType(Array(
        StructField("totalCount",LongType),
        StructField("cityMap",MapType(StringType,LongType)),
      ))
    }

    override def dataType: DataType = StringType

    override def deterministic: Boolean = true

    override def initialize(buffer: MutableAggregationBuffer): Unit = {
      buffer(0) = 0L
      buffer(1) =Map[String,Long]()
    }

    //更新缓冲区
    override def update(buffer: MutableAggregationBuffer, input: Row): Unit = {
      val cityName: String = input.getString(0)
      //点击总和需要增加
      buffer(0) = buffer.getLong(0) + 1

      //城市点击需要增加
      val cityMap: Map[String, Long] = buffer.getAs[Map[String,Long]](1)
      val newClickCount: Long = cityMap.getOrElse(cityName,0L) + 1
      buffer(1) = cityMap.updated(cityName, newClickCount)
    }

    override def merge(buffer1: MutableAggregationBuffer, buffer2: Row): Unit = {
      //合并点击数量的总和
      buffer1(0) = buffer1.getLong(0) + buffer2.getLong(0)

      //合并点击数量的map
      val map1: Map[String, Long] = buffer1.getAs[Map[String,Long]](1)
      val map2: Map[String, Long] = buffer2.getAs[Map[String,Long]](1)

      map1.foldLeft(map2){
        case (map, (k, v)) => {
          map.updated(k, map.getOrElse(k,0L)+v)
        }
      }
    }

    //TODO 对缓冲区进行计算并返回备注信息
    //(totalCount,Map((city_info, clickCountSum),...))
    //返回结果为城市备注一栏的字符串
    override def evaluate(buffer: Row): Any = {
      val totalCount: Long = buffer.getLong(0)
      val cityMap: collection.Map[String, Long] = buffer.getMap(1)

      val twoCityCountList: List[(String, Long)] = cityMap.toList.sortWith(
        (left, right) => left._2 > right._2
      ).take(2)

      val s = new StringBuilder

      val flg: Boolean = cityMap.size > 2
      var rest = 0L

      twoCityCountList.foreach{
        case (cityName, sum) => {
          val rate: Long = sum*100/totalCount
          s.append(cityName+" "+rate+"%"+",")
          rest = 100 - rate
        }
      }

      s.toString() + "其他 " + rest + "%"
    }
  }
}
