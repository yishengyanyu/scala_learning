package com.lesson.chapter11

import scala.collection.mutable

/**
 * @author LiuJing
 * @create 2020-06-01 8:53
 */
object Scala01_Generic {
  def main(args: Array[String]): Unit = {
    //TODO 泛型
    //  不要求大家自己写
    //  泛型一般在框架中使用,为了考虑通用性
    //默认Scala的泛型和Java是一样的
    //Scala中声明泛型,采用的是中括号
    //TODO 泛型不可变
    //[T]

    val a1:AAA[User]= new AAA[User]
//    val a2:AAA[User]= new AAA[Parent]
//    val a3:AAA[User]= new AAA[SubUser]
//    val a4:AAA[User] = new AAA[Emp]


    //TODO 泛型协变:将泛型作为类型的一部分来理解
    //[+T]
    //泛型可以将子类型当成父类型使用
    //BBB[SubUser]当成BBB[User]子类型
//    val b1:BBB[User] = new AAA[User]
//    val b2:BBB[User] = new AAA[Parent]//error
//    val b3:BBB[User] = new AAA[SubUser]//ok
//    val b4:BBB[User] = new AAA[Emp]//error

    //TODO 泛型逆变:将泛型作为类型的一部分来理解
    //[-T]
    //泛型可以将父类型当成子类型使用
    //CCC[User]当成CCC[Parent]子类型
    val c1 : CCC[User] = new CCC[Parent] // ok
    val c2 : CCC[User] = new CCC[User]
//    val c3 : CCC[User] = new CCC[SubUser] // error
//    val c4 : CCC[User] = new CCC[Emp] // error

    //TODO 泛型上限
    //类树
    val d = new DDD
    // [ <:]
//    d.test1[Emp](new Emp) //Error
//    d.test1[Parent](new Parent) //Error
    d.test1[User](new User) //ok
    d.test1[SubUser](new SubUser) //ok

//    //TODO 泛型下限
      //[ >:]
//    d.test2[Emp](new Emp) //Error
    d.test2[Parent](new Parent) //ok
    d.test2[User](new User) //ok
//    d.test2[SubUser](new SubUser) //Error

    //TODO 具体例子
    val list = List(1,2,3,4)
    //将数据的统计结果变为1234
    //List(1,2,3,4) => List("1","2","3","4")
    //A => Int
    //A1 >: A =>  AnyVal, Any
    //(A1,A1) => A1
    println(list.map(_.toString).reduce(_ + _))

    //fold方法要求数据处理的类型和初始值的类型之间应该有关系
    //TODO foldLeft数据处理的类型和初始值的类型无关
    println(list.foldLeft("")(_ + _))

    //两个map的合并
    //map,kv
    val map1 = mutable.Map("a"->1, "b"->2)
    val map2 = mutable.Map("a"->1, "b"->2)
    //这里的kv不是键值对对象
    println(map1.fold(map2)(
      (map, kv) => {
        map
      }
    ))
    println(map1.foldLeft(map2)(
      (map, kv) => {
        map
      }
    ))


  }
}

class AAA[T]{

}
class BBB[+T]{

}
class CCC[-T]{

}
class DDD{
  //泛型上限(范围越来越小)(向子类延伸)
  def test1[T<:User](t:T)= {

  }
  //泛型下限(范围越来越大)(向父类延伸)
  def test2[T>:User](t:T)= {

  }
}

class Parent{

}
class User extends Parent{

}
class SubUser extends User{

}
class Emp{

}