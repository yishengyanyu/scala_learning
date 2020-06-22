package com.lesson.chapter4

/**
 * @author LiuJing
 * @create 2020-05-19 15:54
 */
object Scala01_Flow {
  def main(args: Array[String]): Unit = {
    //Scala 分支
    //单分支
    val age = 20
    if(age < 20){
      println("age < 30")
    }
    println("age >= 30")

    //双分支
    if(age < 20){
      println("age < 20")
    }else {
      println("age >= 20")
    }

    //多分支
    if(age < 18){
      println("少年")
    }else if(age >= 18 && age < 30){
      println("青年")
    }else if(age >= 30 && age < 60){
      println("中年")
    } else {
      println("老年")
    }
  }
}
