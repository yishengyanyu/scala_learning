package com.lesson.chapter7

import scala.collection.mutable

/**
 * @author LiuJing
 * @create 2020-05-29 15:36
 */
object Scala31_Collection_Queue {
  def main(args: Array[String]): Unit = {
    //BlockingQueue(阻塞式队列)
    //Deque(双端队列), Java有Deque
    //Kafka如何保证数据有序?(用双端队列)

    val que = new mutable.Queue[String]()
    // 添加元素, 进队
    que.enqueue("a", "b", "c")
    val que1: mutable.Queue[String] = que += "d"
    println(que eq que1)
    // 获取元素, 出队
    println(que.dequeue())
    println(que.dequeue())
    println(que.dequeue())

  }
}
