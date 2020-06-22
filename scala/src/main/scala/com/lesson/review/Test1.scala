package com.lesson.review

/**
 * @author LiuJing
 * @create 2020-06-21 21:33
 */
object Test1 {
  def main(args: Array[String]): Unit = {
    val list = List(1,2,3,4)
    list.map(x => x*10)
    list.map(_*10)

    list.foreach(x => println(x+10))
    //list.foreach(println(_+10)) //报错

    //部分应用函数, 不能对占位符进行运算
    math.pow(_,2) //需要2个参数,只传了1个,返回值为一个函数,叫做部分应用函数
    val f: Double => Double = math.pow(_,2)
    //val d: Double = math.pow(_,2)
    //调用函数时只传部分参数,其余用_代替

    val f1: Any => Unit = println(_)  //是函数
  }
}
