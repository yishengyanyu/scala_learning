package com.lesson.chapter8

/**
 * @author LiuJing
 * @create 2020-05-30 11:37
 */
object Scala07_Match6 {
  def main(args: Array[String]): Unit = {
    //Scala - 模式匹配 - 偏函数
    //以偏概全
    //偏:部分
    //全:整体
    //所谓的偏函数就是对满足条件的一部分数据进行处理的函数
    //map方法不支持偏函数,支持全量函数操作
    val list = List(1,2,3,4)
    val listMap: List[Int] = list.map(_*2)  //2,4,6,8

    val list1 = List(1,2,"3",4)
    //声明偏函数
    //使用模式匹配进行数据处理'
    val pf: PartialFunction[Any, Any] = {
      case i:Int => i*2
      case s:String => s
    }
    //TODO 使用偏函数,使用模式匹配进行数据处理
    //调用支持偏函数的函数
    //collection:采集,支持偏函数
    val list2 = list1.collect(pf)
    println(list2)  //List(2,4,"3",8)

    //偏函数一般情况下可以使用模式匹配代替
    val list3 = List(1,2,"3",4)
    val list4: List[Any] = list3.collect {
      case i: Int => i * 2
      case s: String => s
    }
    println(list4)  //List(2,4,"3",8)
  }
}
