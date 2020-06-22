package com.test.framework.core

import java.net.Socket

import com.test.framework.utils.EnvUtil1
import org.apache.spark.SparkConf

/**
 * @author LiuJing
 * @create 2020-06-09 18:56
 */
trait TApplication1 {
  var envData: Any = null

  /**
   * 封装启动程序共同步骤
   */

  def start(t:String)(op: => Unit): Unit = {
    //1.初始化环境
    t match {
      case "spark" => envData = EnvUtil1.getEnv()
    }

    //2.业务逻辑
    try{
      op
    }catch {
      case ex: Exception => println("业务执行失败 ：" + ex.getMessage)
    }

    //3.环境关闭
    t match {
      case "spark" => EnvUtil1.clear
    }

  }
}
