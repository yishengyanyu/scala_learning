package com.lesson.chapter6

/**
 * @author LiuJing
 * @create 2020-05-23 14:36
 */
object Scala10_Field1{
  def main(args: Array[String]): Unit = {
    //Scala-面向对象-属性'

    //class可以声明在其他的地方,不一定要声明在外面,可以放在类里面,为内部类
    //1 + 1 => 1.+(1) +是一个方法

    val user = new User09
    user.name = "lisi"
    //java Bean set,get
    //user.name.=("wangwu") //行不通,将=作为方法
    //user.name_=("wangwu")
    //user.name_$eq("wangwu") //底层用$对=进行转换,$eq类似于=

    //Scala类中声明的属性,不仅仅只有属性,还有其他的内容
    //1.编译时,类中声明的属性,其实都是private的,并提供了公共方法进行访问
    //2.编译生成的方法类似于Java中Bean对象的get()方法,用于返回属性的值
    //  以及类似于Java中Bean对象的set()方法,用于声明属性的值
    //3.在使用属性时,因为属性是私有的,给属性赋值,就相当于调用属性的set()方法
    //  public void name_$eq(final String x$1) {  this.name = x$1;  }
    //   获取属性值,就相当于调用属性的get()方法
    //  public String name() {  return this.name; }
    //4.使用val声明的属性,在编译时,属性会被直接使用final修饰,在使用过程中无法进行修改
    println(user.name)

  }

  class User09{ //内部类
    //属性
    var name : String = ""  //也可以写null
    //  var age : Int = null  //错误,类型不匹配
    var age : Int = _
    val sex : String = "男"
  }
}





