package com.lesson.chapter13

/**
 * @author LiuJing
 * @create 2020-06-01 11:01
 */
object Calc {
  def main(args: Array[String]): Unit = {
    val num = 5
    var sum = 0
    val start = System.currentTimeMillis();
    //串行
    //并发(资源共享)
    //并行(分布式)
    //线程多了调度也要花时间
    for(i <- 1 to num){

      new Thread({
        new Runnable {
          override def run(): Unit = {
            sum = sum + i*2
            Thread.sleep(i*100)
          }
        }
      }).start()

    }
    val end  = System.currentTimeMillis();
    println(
      s"""
         |计算结果为:$sum,耗时:${end-start}ms
         |""".stripMargin
    )
  }
}
