package com.lesson.chapter5

/**
 * @author LiuJing
 * @create 2020-05-20 11:49
 */
object Scala05_Function4 {
  def main(args: Array[String]): Unit = {
    //函数式编程
    //函数参数的个数
    //最大个数为22,声明的时候可以超过22个,但是将函数作为对象赋值给变量时会报错
    //val a : Fun
    def fun1(a:Int): Unit ={

    }

    //可变参数:相同类型的参数多次出现, 但是不确定个数
    //Java ==> 类型 ...
    //Scala ==> 类型*
    def test1(i:Int*): Unit ={
      println(i)
    }
    test1() //输出结果:List()
    test1(1)  //输出结果:WrappedArray(1)
    test1(1,2)  //输出结果:WrappedArray(1, 2)
    test1(1,2,3,4,5,6,7,8,9,10) //输出结果:WrappedArray(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)

    //可变参数顺序:可变参数必须放在最后
    def test2(name:String,i:Int*): Unit ={

    }

    //不能有多个可变参数
//    def test3(name : String* , age : Int*)={
//
//    }

    //Scala函数的参数默认使用val声明,无法进行修改
    //Scala提供参数默认值的语法来解决参数默认值的问题
//    def regUser(name : String, password : String): Unit ={
//      if(password == null) {
//      password = "000000"
//      }
//    }
//    regUser("zhangsan",null)

    //参数默认(初始)值,参数声明时进行初始化
    def regUser(name : String, password : String = "000000"): Unit ={
      println("password = " + password)
    }
    //如果函数存在默认值的参数,调用时可以不用传递.不传参数,会使用默认值
    regUser("zhangsan")
    //如果调用函数时,提供了参数值,那么默认参数值不起作用,被覆盖了
    regUser("zhangsan","123456")

    def regUser1(name : String, password : String = "000000",tel:String): Unit ={
      println("name = " + name +",password = "+password + ", tel = " + tel)
    }

    //函数在传递参数时,是按照从左到右的方式匹配的
//    regUser1("lisi","12345678912")  //报错
    regUser1("lisi","000000","12345678912")

    //带名参数:传递参数时添加参数名,明确指定参数
    regUser1(name ="wangwu",tel="13397175177")

  }

}
