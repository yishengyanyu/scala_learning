package com.lesson.chapter7

/**
 * @author LiuJing
 * @create 2020-05-27 14:31
 */
object Scala19_Collection_Method2 {
  def main(args: Array[String]): Unit = {
    //Scala-集合-常用方法-操作数据
//    val list = List(1,2,3,4)
//
//    //TODO map : 映射转换 A=>B
//    //100%的需求会用到map()
//    def transform(i:Int): Int ={
//      i*2
//    }
//    //map方法可以将集合通过指定的转换规则变成新的集合
//    //指定的转换规则会对每条数据起作用
//    val list1: List[Int] = list.map(transform)
//    val list2: List[Int] = list.map(_*3)
//    println(list1)  //List(2, 4, 6, 8)
//    println(list2)  //List(3, 6, 9, 12)
//
//    //TODO 扁平化
//    //所谓的扁平化其实就是一个整体拆成一个一个的数据使用
//    //扁平化默认对外层数据进行操作,内层的数据无法进行操作,解决:嵌套
//    //1::list:::Nil
//    val list3 = List(List(List(1,2)),List(List(3,4)))
//    println(list3.length) //2
//
//    println(list3.flatten)  //List(1,2),List(3,4)
//    println(list3.flatten.flatten)  //List(1, 2, 3, 4)
//
//    //TODO 扁平映射 => 扁平化(自定义规则) + 映射
//    val list4 = List(
//      List(1, 2), List(3, 4)
//    )
//    println(list4.flatten.map(_ * 2))
//
//    //方法中的参数表示集合中的每一个元素
//    //方法返回值的类型为可迭代的集合类型
//    def transform1(list:List[Int]): List[Int] ={
//      list.map(_*2)
//    }
//
//    println(list4.flatMap(transform1))  //List(2, 4, 6, 8)
//    println(list4.flatMap((list)=>{list.map(_*2)}))
//    println(list4.flatMap(_.map(_*2)))

//    val list = List("hello scala","hello spark")
//
////    println(list.flatten)
//
//    def transform( s:String )={
//      s.split(" ")
//    }
//
//    println(list.flatMap(transform))  //List(hello, scala, hello, spark)
//    println(list.flatMap(_.split(" "))) //List(hello, scala, hello, spark)

    //从原理上来讲,做不了扁平化,但是从语法上来讲可以
//    val list = List(1,2,3,4)
//    list.flatMap((num)=>{List(num*2)})

    //TODO 过滤
    //按照指定的规则对集合中的每一条数据进行筛选过滤
    //满足条件的保留,不满足的丢弃
//    val list = List(1,2,3,4)
//    println(list.filter(_ % 2 == 0))  //List(2,4)
//    val list = List("hello","scala","hello","spark")
//    list.filter(_.startsWith("s"))

    //TODO 分组
    //按照指定的规则对集合中的每一个数据进行分组
    //指定的规则其实是一个函数,函数的返回结果是分组的key
    //分组后的类型为Map类型
    //Map中的key就是分组的key,value就是同一个组的数据集合
//    val list = List(1,2,3,4)
//    println(list.groupBy(_ % 2))  //Map(1 -> List(1, 3), 0 -> List(2, 4))
//
//    val list1 = List("hello","hello","scala")
//    println(list1.groupBy(w=>w))

    //TODO 排序
    //将集合中的每一个数据按照指定规则进行排序
    //默认排序为升序
    //sortBy可以使用函数柯里化实现降序
//    val list = List(4,2,3,1)
//    println(list.sortBy(-_))  //List(4,3,2,1)
//    println(list.sortBy(i => i).reverse)
//    println(list.sortBy(i => i)(Ordering.Int.reverse))//函数柯里化

    val list = List("1","11","4","6")
    //字符串的排序可以按照字典顺序
    println(list.sortBy(i => i)) //Map(1 -> List(1), 4 -> List(4), 11 -> List(11), 6 -> List(6))
    //将字符串转换为Int
    println(list.sortBy(i => i.toInt)) //Map(11 -> List(11), 4 -> List(4), 1 -> List(1), 6 -> List(6))

    //自定义类型数据排序
    val user1 = new User
    user1.age = 20
    user1.name = "zhangsan"

    val user2 = new User
    user2.age = 20
    user2.name = "lisi"

    val user3 = new User
    user3.age = 10
    user3.name = "wangwu"

    val list1 = List(user1,user2,user3)
    //年龄相同怎么办
    //Scala中Tuple可以自动比较大小
    //先比较第一个元素,再比较第二个元素,依次向后
    println(list1.sortBy((user: User) => {
//      user.age
      (user.age,user.name)
    }))

  }
}

class User{
  var name:String = _
  var age : Int = _

  override def toString: String = super.toString
}
