package com.spark.framework.test1.dao

import com.test.framework.core.TDao1
import com.test.framework.utils.EnvUtil1
import org.apache.spark.rdd.RDD

/**
 * @author LiuJing
 * @create 2020-06-09 19:24
 */
class WordCountDao1 extends TDao1{
  override def readFile(path: String)={
    val rdd: RDD[String] = EnvUtil1.getEnv().textFile(path)
    rdd
  }
}
