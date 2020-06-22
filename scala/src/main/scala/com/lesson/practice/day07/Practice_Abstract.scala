package com.lesson.practice.day07

import scala.beans.BeanProperty

/**
 * @author LiuJing
 * @create 2020-05-26 10:47
 */
object Practice_Abstract {
  def main(args: Array[String]): Unit = {
//    new Test_Abstrat()
//    val t = Test_Abstrat.apply()

  }
}

abstract class Test_Abstrat{

  var name : String
  val age:String


  def test2(): Unit ={

  }
}

object Test_Abstrat{
//  var name : String
//  def apply(): Test_Abstrat = new Test_Abstrat()

}

class SubTest_Abstract extends Test_Abstrat{
//  override var name: String = _

  var name: String = _
  val age: String = ""
}


