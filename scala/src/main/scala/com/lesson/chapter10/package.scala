package com.lesson

import com.lesson.chapter10.Scala06_Transform5.User

/**
 * @author LiuJing
 * @create 2020-05-30 16:49
 */
package object chapter10 {
  implicit class UserExt06(user:User){
    def updateUser(): Unit ={
      println("update User...")
    }
  }
}
