package com.lesson.chapter5

/**
 * @author LiuJing
 * @create 2020-05-22 9:57
 */
object Scala11_Function10 {
  def main(args: Array[String]): Unit = {
    //答疑
    //1.方法/函数传进来的参数不能修改
    test1("")
    def test1(name:String) : String = {
//      name = "lisi"
      return name
    }

    //2.匿名函数后面的代码不执行
    //匿名函数只有声明不调用
    () => {
      print("XXXX")
    }
    println("yyyy") //无法执行,原因:将该部分和匿名函数封装在一起
    //解决方法: 将匿名函数赋给变量

    //3.匿名函数参数不使用的简化问题
    //匿名参数使用下划线的时候可以简化参数列表
    def test3(f:(Int)=>Any) = {
      f(100)
    }
    test3("Hello")

    //4.循环反向操作
    //默认情况下只能正向操作
    for(i <- 5 to 1 by -1) {
      println(i)
    }

    //5. def fun : String = { "zhangsan" }, val aaa : ()=>String = fun 报错
    def test5 : String = {
      "zhangsan"
    }
    val a = test5 _
    println(a)
    //左右两边类型必须匹配,左边有(),右边test5在声明时没有()
//    val b : ()=>String = test5
    val c = test5 _
    println(c)

    //6.函数作为参数不理解
    def test6(i : Int) : Int = {
      i * 2
    }
    def fun6(i:Int):Unit = {
      print(i*2)
    }

    //8.for循环中的i为什么不声明val或var(两个i不一样)
    val i = 10
    //两个i不一样
    for(i <- 1 to 5){
      println(i)
    }

    //9.
    def test9(a:Int):String={
      "xxxxx"
    }
    test9(1)  //和test9 1(报错)
    1 to 5
    1 toString


  }
}
