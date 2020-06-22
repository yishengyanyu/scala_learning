package com.lesson.chapter7

/**
 * @author LiuJing
 * @create 2020-05-29 14:00
 */
object Scala27_Collection_Method5 {
  def main(args: Array[String]): Unit = {
    val list = List ((1,2),(2,3))

    //sortWith:用于判断左边的数据是否小于右边数据
    //          如果满足(true),升序,如果不满足(false),降序
    //TODO sortWith实现时,只需要考虑在满足自定义条件的场合下,返回true就行
    val sortList: List[(Int, Int)] = list.sortWith({
      (left, right) => {
        if (left._1 < right._1) {
          true
        } else {
          false
        }
      }
    })

  }
}
