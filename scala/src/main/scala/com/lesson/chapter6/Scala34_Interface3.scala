package com.lesson.chapter6

/**
 * @author LiuJing
 * @create 2020-05-26 14:09
 */
object Scala34_Interface3 {
  def main(args: Array[String]): Unit = {
    //Scala - 特质

    //1.trait关键字,可以声明特质
    //2.可以将trait理解为interface
    //  java中接口可以继承
    //  特质能不能继承?可以,并且可以采用with进行多继承
    //3.可以将trait理解为抽象类
    //  java中抽象类是一个类,可以继承其他的类
    //  特质能不能继承类,可以继承其他的类并可以采用with混入其他的类
    //4.将特质混入类中,采用extends关键字或with关键字
    //  将特质理解为抽象类,就可以使用extends让子类继承
    //  如果特质中存在抽象方法,那么混入的类应该存在补全方法,否则就是抽象类
    //  如果特质中存在具体方法,那么子类重写方法时,需要使用override关键字
    //5.Scala可以直接使用Java中的代码,Scala没有接口
    //  Java中的接口在Scala中怎么使用
    //  Java中所有的接口在Scala中都能当成特质来用


  }
}
class UserNNN{

}
trait ParentTest344 extends UserNNN {

}

trait ParentTest34{

}


trait Test34 extends Exception with ParentTest34 {
  //抽象方法
  def test1(): Unit

  //具体方法
  def test2(): Unit ={
    println("Test34...")
  }

  def sum(i:Int,j:Int) ={
    i + j
  }
}

class User34 extends Test34 with ParentTest34 with Serializable {
  override def test1(): Unit = {

  }
}
