package com.lesson.spark.core.rdd.operator

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
 * @author LiuJing
 * @create 2020-06-03 16:43
 */
object Spark21_RDD_Operator7 {
  def main(args: Array[String]): Unit = {

    //TODO Spark - RDD - 算子(方法)

    val sparkConf = new SparkConf().setMaster("local[*]").setAppName("File-RDD")
    val sc = new SparkContext(sparkConf)

    val dataRDD = sc.makeRDD(List(1,2,3,4),2)

    //TODO 分组
    //groupBy方法可以根据指定的规则进行分组,规则的返回值就是分组的key
    //groupBy方法的返回值为元组
    //  元组中的第一个元素表示分组的key
    //  元组中的第二个元素表示相同的key形成的可迭代的集合
    //groupBy方法执行完毕后,将数据行分组操作,但是分区不会改变
    //  不同组的数据会打乱在不同的分区中
    //groupBy方法会导致数据不均匀,产生shuffle操作.如果想改变分区,可以传递参数
    val rdd: RDD[(Int, Iterable[Int])] = dataRDD.groupBy(
      num => {
        num % 2
      },2
    )

    rdd.saveAsTextFile("output")
    // glom => 分区转换为一个array
    //        println(" 分组后的数据分区的数量 = " + rdd.glom().collect().length)
    //
    //        rdd.collect().foreach{
    //            case ( key, list ) => {
    //                println("key:" + key + " list【"+list.mkString(",")+"】")
    //            }
    //        }

    sc.stop()
  }
}
