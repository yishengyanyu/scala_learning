package com.lesson.chapter6

/**
 * @author LiuJing
 * @create 2020-05-26 11:12
 */
object Scala30_Abstract3 {
  def main(args: Array[String]): Unit = {
    new SubUser30() //输出结果为0
    //override发生了什么事
    //1.println(age)其实调用了子类的age的get()
    //2.println方法的位置,在父类初始化时进行调用
    //3.父类初始化的时候,子类还没有初始化,只有系统的默认值为0
  }
}

abstract class User30{
  val age:Int = 20
  println(age)  //age属性的get方法,成员方法,动态绑定机制

}

class SubUser30 extends User30{
  override val age:Int = 30 //get方法
}
