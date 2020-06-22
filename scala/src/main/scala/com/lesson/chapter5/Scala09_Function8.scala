package com.lesson.chapter5

/**
 * @author LiuJing
 * @create 2020-05-20 16:28
 */
object Scala09_Function8 {
  def main(args: Array[String]): Unit = {
    //函数也是对象
    //函数可以作为参数传递给其他函数
    //函数名(参数名1:参数类型1,参数名2:参数类型2)
    //函数名(参数名:函数类型)
//    def test1(name:String):String = {
//      "name" + name
//    }
    def fun2(i:Int):Int={
      i * 2
    }

    def test2(f:(Int)=>Int) ={
      f(10)
    }

    //2.1 将函数赋值为变量
    val f = fun2 _
    println(test2(f))
    println(test2(fun2 _))
    println(test2(fun2))

    //2.2 将函数作为参数使用时,不关心函数的名称,所以一般使用匿名函数
    println(test2((i: Int) => {
      i * i
    }))

    //至简原则
    val result1 = test2((i:Int)=>{i*i})
    //如果代码逻辑只有一行,{}可以省略
    val result2 = test2((i:Int)=>i*i)
    //如果匿名函数的参数类型可以推断出来,则参数类型可以省略
    val result3 = test2((i)=>i*2)
    //如果匿名函数的参数列表只有一个,则()可以省略
    val result4 = test2(i=>i*2)
    //如果匿名函数中参数在逻辑代码中只使用了一次,则参数可以省略, 使用_代替参数
    val result5 = test2(_*2)
    println(result5)
  }
}
