package com.lesson.practice

/**
 * @author LiuJing
 * @create 2020-05-31 20:58
 */
package object day10 {
  implicit class Transform1(t:Transform) {
    def update(): Unit = {
      println("update...")
    }
  }
}
