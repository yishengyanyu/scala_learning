package com.lesson.practice.day09

/**
 * @author LiuJing
 * @create 2020-05-29 20:34
 */
object Practice_Method2 {
  def main(args: Array[String]): Unit = {
    //交集,并集,差集
    val list1 = List(1,2,3,4)
    val list2 = List(3,4,5,6,7)

    //交集
    println(list1.intersect(list2))

    //并集
    println(list1.union(list2))

    //差集
    println(list1.diff(list2))
    println(list2.diff(list1))

    //关联
    println(list1.zip(list2))
    //自关联
    println(list1.zip(list1))
    println(list1.map(e => (e, e)))

    //和索引关联
    println(list2.zipWithIndex) //List((3,0), (4,1), (5,2), (6,3), (7,4))
    
    //滑动窗口
    val list = List(1,2,3,4,5,6,7,8)
    val iterator: Iterator[List[Int]] = list.sliding(2, 1)
    while(iterator.hasNext){
      println(iterator.next().sum)
    }

    //排序
    val list3 = List(1,5,2,4)
    val sort1: List[Int] = list3.sortWith(
      (left, right) => {
        left > right
      }
    )
    val sort2: List[Int] = list3.sortBy(e => e)(Ordering.Int.reverse)
    println(sort1)
    println(sort2)

    val list4 = List((20,"zhangsan"),(30,"lisi"),(20,"wangwu"))
    val sort3: List[(Int, String)] = list4.sortWith(
      (left, right) => {
        if (left._1 > right._1) {
          true
        } else if (left._1 == right._1) {
          left._2 < right._2
        } else {
          false
        }
      }
    )
    println(sort3)

    val sort4: List[(Int, String)] = list4
      .sortBy(t => t)(Ordering.Tuple2(Ordering.Int.reverse,Ordering.String))
    println(sort4)

    //faltMap练习
    val list5: List[Any] = List(1, 2, List(3, 4)) //泛型为Any

//    val list6: List[Any] = list5.flatMap(
//      e => {
//        if (e.isInstanceOf[List]) {
//          e.asInstanceOf[List]
//        } else {
//          List(e)
//        }
//      }
//    )
//    println(list6)


  }
}

