package com.lesson.spark.streaming.req.service

import java.sql.{Connection, PreparedStatement, ResultSet}
import java.text.SimpleDateFormat
import java.util.Date

import com.lesson.spark.streaming.req.bean.Ad_Click_Log
import com.lesson.spark.streaming.req.dao.BlackListDao
import com.lesson.summer.framework.core.TService
import com.lesson.summer.framework.util.JDBCUtil
import org.apache.spark.rdd.RDD
import org.apache.spark.streaming.dstream.DStream

import scala.collection.mutable.ListBuffer

/**
 * @author LiuJing
 * @create 2020-06-15 21:59
 */
class BlackListService extends TService{
  private val dao = new BlackListDao
  /**
   * 数据分析
   *
   * @return
   */
  override def analysis() = {
    //读取Kafka数据
    val ds: DStream[String] = dao.readKafka()
    //TODO 将数据转换为样例类来使用
    val logDS: DStream[Ad_Click_Log] = ds.map(
      datas => {
        val words: Array[String] = datas.split(" ")
        Ad_Click_Log(words(0), words(1), words(2), words(3), words(4))
      }
    )

    //TODO 周期性获取黑名单的信息，判断当前用户的点击数据是否在黑名单中
    val reduceDS: DStream[((String, String, String), Int)] = logDS.transform(
      //Code ： 周期性执行
      //TODO 读取Mysql数据库，获取黑名单信息
      //  JDBC
      rdd => {
        val connection = JDBCUtil.getConnection()
        val pstat: PreparedStatement = connection.prepareStatement(
          """
            |select userid from black_list
            |""".stripMargin)

        val rs: ResultSet = pstat.executeQuery()

        //黑名单ID集合
        val blackIds: ListBuffer[String] = ListBuffer[String]()

        while (rs.next()) {
          blackIds.append(rs.getString(1))
        }
        rs.close()
        pstat.close()
        connection.close()

        //TODO 如果用户在黑名单中，那么将数据过滤掉，不会进行统计
        val filterRDD: RDD[Ad_Click_Log] = rdd.filter(
          log => {
            !blackIds.contains(log.userid)
          }
        )
        //TODO 将正常的数据进行点击量的统计
        //     (key, 1) =>（key, sum）
        // key = day - userid - adid
        // ("2012-12-20" - userid - adid, 1) => (day - userid - adid, sum)
        // ts => day
        val sdf = new SimpleDateFormat("yyyy-MM-dd")
        val mapRDD: RDD[((String, String, String), Int)] = filterRDD.map(
          log => {
            val date = new Date(log.ts.toLong)
            ((sdf.format(date), log.userid, log.adid), 1)
          }
        )
        mapRDD.reduceByKey(_ + _)
      }
    )

    //TODO 将统计的结果中超过阈值的用户信息拉人到黑名单中。
    //TODO 数据库的连接对象是无法序列化的。
    reduceDS.foreachRDD(
      rdd => {
        //TODO RDD可以以分区为单位进行数据的遍历
        rdd.foreachPartition(
          datas => {
            val conn: Connection = JDBCUtil.getConnection()
            val pstat: PreparedStatement = conn.prepareStatement(
              """
                |insert into user_ad_count(dt, userid, adid, count)
                |values(?,?,?,?)
                |on duplicate key
                |update count = count + ?
                |""".stripMargin)

            val pstat1: PreparedStatement = conn.prepareStatement(
              """
                |select userid
                |from user_ad_count
                |where dt = ? and userid = ? and adid = ? and count >= 100
                |""".stripMargin)

            val pstat2: PreparedStatement = conn.prepareStatement(
              """
                |insert into black_list(userid)
                |values(?)
                |on duplicate key
                |update userid = ?
                |""".stripMargin)

            datas.foreach {
              case ((day, userid, adid), sum) => {
                pstat.setString(1, day)
                pstat.setString(2, userid)
                pstat.setString(3, adid)
                pstat.setLong(4, sum)
                pstat.setLong(5, sum)
                pstat.executeUpdate()

                // TODO 获取最新的用户统计数据
                pstat1.setString(1, day)
                pstat1.setString(2, userid)
                pstat1.setString(3, adid)
                val rs1 = pstat1.executeQuery()
                if (rs1.next()) {
                  // TODO 判断是否超过阈值
                  // TODO 如果超过阈值，拉入到黑名单
                  //  20 - 1 - 20  100
                  //  20 - 1 - 21  100

                  pstat2.setString(1, userid)
                  pstat2.setString(2, userid)
                  pstat2.executeUpdate()

                }
              }
            }
            pstat2.close()
            pstat.close()
            pstat1.close()
            conn.close()
          }
        )
      }
    )
    ds.print()
  }
}
