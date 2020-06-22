package com.lesson.chapter6

import scala.beans.BeanProperty

/**
 * @author LiuJing
 * @create 2020-05-26 10:21
 */
object Scala29_Abstract2 {
  def main(args: Array[String]): Unit = {
    //TODO Scala - 面向对象编程 - 抽象Abstract

    //TODO 抽象属性
    //所谓的抽象属性其实就是属性不完整
    //    即:属性只有声明, 没有初始化
    //如果一个类中存在抽象属性,那么这个类是抽象类
    //抽象属性在编译时,不会产生类的属性,而是产生属性的set,get方法,并且方法为抽象方法
    //重写抽象属性,那么等同于重写属性,set,get方法

    //TODO 通过子类继承抽象类,并将其中抽象属性补充完整,就可以构建对象
    println(new SubUser29)

    //TODO 子类重写父类的抽象属性,需要将它补充完整即可
    //TODO 子类重写父类的完整属性,需要增加override关键字修饰
    //TODO 子类重写父类的完整属性时,这个属性不能是可变的,需要采用val声明

    //如果采用var声明的属性可以被重写,那么会产生歧义
    println(new SubUser29().test1())

    //Scala中类的属性在编译时,会自动生成私有属性和对应的set,get方法
  }

}

abstract class User29{
  var name : String

  @BeanProperty
  val age:Int = 20

  def test1(): Unit ={  //验证歧义
//    age = 40  //底层调用了set()
    println(age)  //底层调用了get()
  }
}

class SubUser29 extends User29{
  //将抽象属性补充完整
  override var name: String = _

  @BeanProperty
  override val age:Int = 30
}