package com.lesson.chapter5

/**
 * @author LiuJing
 * @create 2020-05-20 14:37
 */
object Scala06_Function5 {
  def main(args: Array[String]): Unit = {
    //函数编程
    //Scala中函数有至简原则:能省则省
    //这里的能省则省,必须是编译器能够自动推断的场合,才能省
    def test(name:String):String ={
      return "name = " + name
    }

    //1.当函数需要返回值时,可以将函数体中最后一行执行的代码作为返回结果,所以可以省略return关键字
    def test1(name:String):String ={
      "name = " + name
    }
    println(test1("zhangsan"))

    //2.如果编译器可以推断出函数的返回值类型,返回值类型可以省略
    def test2(name:String) ={ //后面的String是编译器自动推断出来的
      val age = 20
      "name = " + name
    }
    println(test2("zhangsan"))

    //3.如果函数体只有一行代码,那么{}可以省略
    def test3(name:String) = "name = " + name
    println(test3("lisi"))

    //4.如果函数没有提供参数,那么调用的时候,()可以省略
    //如果函数没有提供参数,那么声明时,()也可以省略,但是如果声明时没有(),则调用时一定不能使用()
    def test4() = "zhangsan"
    println(test4())
    println(test4)

    //统一访问原则
    def test5 = "zhangsan"  //和 val a = 12 很像,但是区别在于关键字
    println(test5)
//    println(test5())  //执行时会报错

    //5.函数如果明确使用Unit声明没有返回值,那么函数体中的return关键字不起作用
    //  函数体中如果明确使用return关键字,那么返回值类型不能省略(如果省略了,默认返回值类型为Unit)
    //  明确函数没有返回值,但是Unit不想声明,那么可以同时省略等号,将这种函数的声明方式称为过程函数
    def test6(): Unit ={
      return "zhangsan"
    }
    println(test6())  //()

    def test7() {
      return "zhangasan"
    }
    println(test7())  //()

    //6.当只关心代码逻辑,不关心函数名称时,函数名和def关键字可以省略
    //将没有名称和def关键字的函数,称为匿名函数
    //规则: (参数列表) => {代码逻辑}
    //函数调用:函数(变量)名称(参数列表)
    (name:String)=> println("name = " + name);
    val a = (a:Int) => println("a = " + a)
    //调用
    a(10)
  }
}
