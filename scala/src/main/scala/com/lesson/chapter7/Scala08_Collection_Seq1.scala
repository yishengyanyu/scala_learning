package com.lesson.chapter7

/**
 * @author LiuJing
 * @create 2020-05-27 10:01
 */
object Scala08_Collection_Seq1 {
  def main(args: Array[String]): Unit = {
    //Scala - 集合 - Seq
    //空集合,什么数据都加不进去
//    Nil = List()
    val nil: List[Nothing] = Nil
    nil.+:(2) //加不进去
    println(nil)

    //空集合一般用于增加数据
    //采用新的方式添加数据
    //运算方式:Nil::(4)::(3)::(2)::(1)
    val list: List[Int] = 1::2::3::4::Nil //特殊情况下有用,可以在其他语法中使用
    println(list)

    val list2: List[Any] = 5::6::list::Nil  //把list集合当成整体放在新的集合,新集合长度为3
    println(list2)  //List(5, 6, List(1, 2, 3, 4))

    //扁平化操作:将一个数据整体拆分成一个一个的个体来使用
    val list3: List[Any] = 5::6::list:::Nil //将list集合拆成个体放进去
    println(list3)  //List(5, 6, 1, 2, 3, 4)

  }
}
