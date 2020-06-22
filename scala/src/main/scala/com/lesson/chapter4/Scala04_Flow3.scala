package com.lesson.chapter4

/**
 * @author LiuJing
 * @create 2020-05-19 16:34
 */
object Scala04_Flow3 {
  def main(args: Array[String]): Unit = {
    //Scala没有三元运算符
    //使用if-else代替
    val age = 20
    val s = if(age < 20){
      "张三"
    }else {
      "李四"
    }
    println(s)

    //如果{}中代码逻辑只有1行,则可以省略{}
    val ss = if(age < 20) "zhangsan" else "lisi"
    println(s)

    //如果一行代码中只有一段逻辑,则;是可以省略的,如果有多段逻辑,则;不能省略
    println("zhangsan")

    //如果代码太长,可以折行
  }
}
