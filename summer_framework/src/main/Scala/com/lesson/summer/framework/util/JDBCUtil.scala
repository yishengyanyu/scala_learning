package com.lesson.summer.framework.util

import java.util

import com.alibaba.druid.pool.DruidDataSourceFactory

/**
 * @author LiuJing
 * @create 2020-06-15 22:18
 */
object JDBCUtil {
  //创建连接池对象
  val dataSource = init()

  //连接池的初始化
  def init()={
    val paramMap = new util.HashMap[String,String]()
    //固定写法
    paramMap.put("driverClassName", PropertiesUtil.getValue("jdbc.driver.name"))
    paramMap.put("url", PropertiesUtil.getValue("jdbc.url"))
    paramMap.put("username", PropertiesUtil.getValue("jdbc.user"))
    paramMap.put("password", PropertiesUtil.getValue("jdbc.password"))
    paramMap.put("maxActive", PropertiesUtil.getValue("jdbc.datasource.size"))

    //使用druid连接池对象
    DruidDataSourceFactory.createDataSource(paramMap)
  }

  //从连接池中获取连接对象
  def getConnection() = {
    dataSource.getConnection
  }
}
