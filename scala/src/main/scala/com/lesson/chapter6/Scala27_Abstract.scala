package com.lesson.chapter6

/**
 * @author LiuJing
 * @create 2020-05-26 9:55
 */
object Scala27_Abstract {
  def main(args: Array[String]): Unit = {
    //TODO Scala - 面向对象编程 - 抽象Abstract
    //抽象的对象一般理解为不完整的对象
    //抽象类:不完整的类
    //抽象方法:不完整的方法
    //        只有声明,没有实现的方法
    //        无需使用abstract修饰

    //TODO 如果一个类中有抽象方法,则这个类一定是抽象类
    //TODO 抽象类应该使用abstract修饰
    //TODO 如果一个类是抽象类,则该类不一定有抽象方法
    //TODO 抽象类无法直接构造对象

    //new不行,apply也不行

    //如果想要抽象类构造对象,使用子类继承抽象类,构造子类的同时构造抽象类
    //如果子类继承抽象类,必须将不完整的内容补充完整,否则依然是不完整的类,还是抽象类
    //new SubUser27
    new SubUser227

  }
}

abstract class User27{
  def test1(): Unit ={

  }
  def test2(): Unit //也是抽象方法

  def apply(): Unit = {

  }
}

abstract class SubUser27 extends User27{

}

class SubUser227 extends User27{
  override def test1(): Unit = {

  }

  override def test2(): Unit ={

  }
}
