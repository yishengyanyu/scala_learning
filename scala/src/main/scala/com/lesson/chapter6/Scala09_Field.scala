package com.lesson.chapter6

/**
 * @author LiuJing
 * @create 2020-05-23 14:36
 */
object Scala09_Field {
  def main(args: Array[String]): Unit = {
    //Scala-面向对象-属性'
    //在类中声明属性就等同于在类中声明局部变量的感觉,可以使用var,val声明
    //可以通过对象在外部访问
    val user = new User09()
    user.name = "zhangsan"

    //变量应该显式地初始化
    //如果想要像Java中类的属性默认初始化一样,需要采用特殊的符号:下划线
    //如果属性使用val声明,那么初始值不能使用下划线,需要显式地赋值
    //使用val声明的属性,不能修改
    user.age = 20
//    user.sex = "女"  //编译不通过

    //

  }
}

class User09{
  //属性
  var name : String = ""  //也可以写null
//  var age : Int = null  //错误,类型不匹配
  var age : Int = _
  val sex : String = "男"
}



