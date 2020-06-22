package com.lesson.practice.day07

/**
 * @author LiuJing
 * @create 2020-05-26 22:17
 */
object Practice_Trait1 {
  def main(args: Array[String]): Unit = {

    new SubUserA().parentA()
    //      SubUserA.parenA -> UserA.parentA -> TestA.parentA -> ParentA.parentA
    //        SubUserA...         UserA...          TestA...         ParenA...
    //      SubUserA.parentA -> SubTestA.parentA -> ParentA.parentA
    //         SubUserA...        SubTestA...         ParenA...

  }
}

trait ParentA{
  def parentA(): Unit ={
    println("ParenA...")
  }
}

trait TestA extends ParentA{
  override def parentA(): Unit ={
    println("TestA...")
    super.parentA()
  }
}

trait SubTestA extends ParentA{
  override def parentA(): Unit ={
    println("SubTestA...")
    super.parentA()
  }

}

class UserA extends TestA{
  override def parentA(): Unit = {
    println("UserA...")
    super.parentA()
  }

}

class SubUserA extends UserA with SubTestA{
  override def parentA(): Unit = {
    println("SubUserA...")
    super.parentA()
  }

}