package com.lesson.chapter7

/**
 * @author LiuJing
 * @create 2020-05-27 11:30
 */
object Scala15_Collection_Tuple {
  def main(args: Array[String]): Unit = {
    //Scala 集合
    //1,"zhangsan",30当成整体使用
    //bean(与对象相关)
    //json(如何进行间隔和区分)
    //List(得是Any类型)
    //如果将无关的数据当成一个整体来使用
    //封装Bean,json,集合都不是一个很好的选择
    //Scala会采用一种特殊的结构进行封装
    //这个特殊的结构就是采用小括号,称之为元组(元素的组合):Tuple
    val data = (1,"zhangsan",30,"xxxx")

    //元组中的数据一般是没有关系的,需要通过数据的顺序访问
    //元组中最多能放多少条数据?最多能放22条
    //    这里的22表示元素的个数,但是不限定元素的类型
    //元组的对象._顺序号
    println(data._1)
    println(data._2)
    println(data._3)
    println(data._4)
//    println(data._5)  //越界了编译不通过

    //元组的遍历
    //迭代器
    val iterator: Iterator[Any] = data.productIterator
    while (iterator.hasNext){
      println(iterator.next())
    }

    //通过索引访问
    println(data.productElement(0))

  }
}
