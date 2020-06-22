package com.lesson.chapter9

import java.io.FileNotFoundException

import scala.util.control

/**
 * @author LiuJing
 * @create 2020-05-30 15:03
 */
object Scala02_Exception1 {
  def main(args: Array[String]): Unit = {

  }
}

class Dept02{
  @throws[Exception]
  def test()={
    throw new Exception
  }
}
