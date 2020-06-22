package com.lesson.chapter6

/**
 * @author LiuJing
 * @create 2020-05-26 11:45
 */
object Scala32_Interface1 {
  def main(args: Array[String]): Unit = {
    //Scala中没有接口的概念,也就没有interface关键字
    //Scala可以将多各类中相同的特征从类中剥离出来,形成特殊的语法结构,称之为"特质"
    //如果一个类符合某个特征,那么可以将这个特征(特质)混入到类中

    //特质中可以声明抽象方法
    val operate : Operate = new Mysql
    operate.oper()

    //特质可以看做Interface
    //类中混入特质,等同于实现interface
  }
}

//声明特质
trait Operate{
  //抽象方法 - 不完整方法
  def oper(): Unit
}

//如果一个类符合某个特质,可以将特质"混入"到类中,采用extends关键字
//类应该将特质中的抽象方法补全
class Mysql extends Operate{
  override def oper(): Unit = {
    println("执行Mysql...")
  }
}

