package com.lesson.spark.streaming.req

/**
 * @author LiuJing
 * @create 2020-06-15 22:04
 */
package object bean {
  case class Ad_Click_Log(
     ts:String, //时间戳
     area:String, //区域
     city:String, //城市
     userid:String, //用户id
     adid:String )  //广告id
}
