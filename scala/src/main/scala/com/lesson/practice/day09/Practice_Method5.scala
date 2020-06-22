package com.lesson.practice.day09

import scala.collection.mutable

/**
 * @author LiuJing
 * @create 2020-05-29 22:19
 */
object Practice_Method5 {
  def main(args: Array[String]): Unit = {
    //队列
    val queue = new mutable.Queue[String]()

    //添加元素
    queue.enqueue("a","b","c")

    val queue1: mutable.Queue[String] = queue += "d"

    //获取元素
    println(queue.dequeue())
    println(queue.dequeue())
    println(queue.dequeue())

    //并行
    val result1 = (0 to 100).map(x => {Thread.currentThread().getName})
    val result2 = (0 to 100).par.map(x => {Thread.currentThread().getName})

    println(result1)
    println(result2)
  }
}
