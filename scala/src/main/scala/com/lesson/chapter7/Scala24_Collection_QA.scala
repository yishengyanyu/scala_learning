package com.lesson.chapter7

/**
 * @author LiuJing
 * @create 2020-05-29 9:30
 */
object Scala24_Collection_QA {
  def main(args: Array[String]): Unit = {
//    val list = List("hello","hello")
//
//    //匿名函数的位置,下划线的作用
//    //1.代替参数出现一次
//    //2.下划线可以将函数作为整体进行传递
//    //3.如果匿名函数的参数不参与逻辑处理,那么可以使用下划线省略
//
//    //TODO 如果匿名函数中逻辑处理直接返回参数本身,那么不要使用下划线省略参数,会导致无法判断类型
//    val stringToList: Map[String, List[String]] = list.groupBy(s => s)
//
//    //println不传参数,可以用下划线
//    list.foreach(println(_))

//    val list = List(List(1,2),List(3,4))
//
//    val ints: List[Int] = list.flatMap(list => list)
//
//    val flatten: List[Int] = list.flatten
//    println(ints)
//    println(flatten)

//    flatMap试验
//    val list = List(List(List(1,2),List(3,4)),List(List(5,6),List(7,8)))
//    println(list.flatMap(list => list.head))  //先执行map,再执行flatten
//
//    val list1: List[Any] = List(1,2,List(1,2))
//    val list2: List[Any] = list1.flatMap(data => {
//      //模式匹配
//      if (data.isInstanceOf[List]) {
//        data.asInstanceOf[List]
//      } else {
//        List(data)
//      }
//    })
//
//    println(list2)

    //TODO 排序(Tuple本身就能排序)
    val list = List((30,"zhangsan"),(20,"lisi"),(20,"wangwu"))

    println(list.sortBy(t => t)(Ordering.Tuple2(Ordering.Int.reverse, Ordering.String.reverse)))

    //TODO 自定义排序(运用递归)
    //两两比较大小(第一个数据和第二个数据比较)
    //左边大, 右边小为降序
    //sortWith默认的比较规则是升序
    //lt => less than => true
    println(list.sortWith(
      (left, right) => {
//        left._1 > right._1  //降序
//        left._1 < right._1  //升序
        //当满足你的排序要求时,就返回true
        //当不满足排序要求时,就返回false
        if(left._1 > right._1){
          true
        }else if(left._1 == right._1){
          left._2 > right._2
        }else{
          false
        }

      }
    ))
  }
}
