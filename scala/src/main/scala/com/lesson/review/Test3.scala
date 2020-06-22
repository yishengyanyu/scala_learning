package com.lesson.review

/**
 * @author LiuJing
 * @create 2020-06-21 11:42
 */
object Test3 {

  def main(args: Array[String]): Unit = {
//    val a:Int = {
//      println("aa...")
//      println("=====aa分割线=====")
//      7
//    }

    def b  = {
      println("bb...")
      7
    }

    //foo(3+4)  //值调用,把3+4的值计算出来,再传给a, 几乎所有的语言默认情况都是值调用
    //println("=====分割线1=====")
    //foo(a)
    //println("=====分割线2=====")
    foo(b)  //只打印一次,执行结束后,只获取值,不再执行函数b
    println("=====分割线3=====")

    //foo1(3+4)
    //println("=====分割线4=====")
    //foo1(a)
    //println("=====分割线5=====")
    foo1(b)

    val str: String = foo2 {  //因为foo2只有1个参数,所以()可以省略
      println("foo2...e")
      val a = 3 + 4
      a
    }
    println(str)

    var x = 0
    myWhile(x < 100){
      println(x)
      x+=1
    }
  }

  //执行一段代码在子线程
  def runInThread(op : => Unit)= {
    new Thread() {
      override def run(): Unit = {
        op
      }
    }
  }

  def myWhile(c : => Boolean)(op: => Unit):Unit ={
    if(c){
      op
      myWhile(c)(op)
    }
  }

  //值调用
  def foo(c:Int) = {
    c //只计算一次3+4
    c
    c
  }

  //名调用
  def foo1(d: => Int) = {
    d //计算3+4
    d //计算3+4
    d //计算3+4
  }

  def foo2(e : => Int) ={  //e是一段代码,Unit是这段代码的返回值
    e
    e
    e
    e.toString
  }
}
