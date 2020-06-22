package com.lesson.chapter4

/**
 * @author LiuJing
 * @create 2020-05-20 9:57
 */
object Scala10_Loop5 {
  def main(args: Array[String]): Unit = {
    //Scala
    //for循环的表达式返回值为Unit
    val result = for(i <- Range(1,5)){

    }

    println(result)

    //如果需要获取循环表达式的值,需要加上关键字yield
    val result1 = for(i <- Range(1,5)) yield{
      i
    }
    println(result1)  //加上yield之后,返回值为一个Vector向量集合

    //这种操作可以将一个集合转换为另一个集合
    //在开发中不用
    val result2 = for(i <- Range(1,5)) yield{
      "*" * i
    }
    println(result2)
  }
}
