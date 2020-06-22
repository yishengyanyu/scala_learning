package com.lesson.chapter7

/**
 * @author LiuJing
 * @create 2020-05-29 11:18
 */
object Scala26_Collection_Method4 {
  def main(args: Array[String]): Unit = {
    //Scala-集合-常用方法-操作数据

    //计算
    val list = List(1,2,3,4,5,6)
//    //sum
//    var sum = 0
//    for (elem <- list) {
//      sum += elem
//    }
//    println(sum)

    //自定义运算规则:reduce
    //TODO 简化,规约
    //reduce方法的参数:  op : (A1,A1) => A1
    //reduce中传递参数的规则:参数和返回值类型相同
    //这里的参数其实就是集合中数据的类型
    //scala中集合的计算基本都是两两计算
    println(list.reduce((a, b) => {
      a + b
    }))

    println(list.reduce(_-_))

    //从源码的角度,reduce操作其实就是reduceLeft
    //reduceLeft参数:  op : (B,Int)=B
    //左右的参数可能不一样
    //这里的参数应该和Int类型有关才能使用
    println(list.reduceLeft(_-_))

    //reduceRight参数:  op : (Int,B)=B
    //底层源码: reversed.reduceLeft[B]((x,y) => op(y,x))
    //1,2,3,4
    //4,3,2,1

    //如何判断计算方式:加上()
    //left:从左边加()
    //((((1-2)-3)-4)-5)
    //right:从右边加()
    //1-(2-(3-(4-5))))
    println(list.reduceRight(_-_))  //-2

  }
}
