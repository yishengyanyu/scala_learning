package com.lesson.chapter6

/**
 * @author LiuJing
 * @create 2020-05-26 10:10
 */
object Scala28_Abstract1 {
  def main(args: Array[String]): Unit = {
    //TODO Scala - 面向对象编程 - 抽象Abstract
    //抽象类可以有完整的方法
    //如果抽象类没有不完整的方法,那么子类无须声明为抽象的,可以直接构建
    println(new SubUser28)

    //TODO 如果子类重写父类的完整方法,需要增加override关键字
    //TODO 如果子类重写父类的抽象方法,直接补充完整即可,或采用override关键字修饰(不推荐)
    println(new SubUser28)

  }
}

abstract class User28{
  def test1(): Unit={

  }
}

class SubUser28 extends User28{ //反编译看一看
  override def test1(): Unit ={

  }
}
