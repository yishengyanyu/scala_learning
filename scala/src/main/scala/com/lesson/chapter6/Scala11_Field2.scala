package com.lesson.chapter6

import scala.beans.BeanProperty

/**
 * @author LiuJing
 * @create 2020-05-23 14:36
 */
object Scala11_Field2 {
  def main(args: Array[String]): Unit = {
    //Scala-面向对象-属性'

    //Java Bean规范中,要求属性的get(),set()方法必须以get,set开头
    //框架中会动态的获取属性(通过反射),反射调用属性的get方法获取属性值
    //Scala编译生成的get()和set()并没有遵循Java Bean规范,这样在很多框架中无法使用
    //如果想要Scala中的属性符合bean规范,可以对属性采用特殊的注解:@BeanProperty
    //编译后的底层如下:
    //  public String getName() { return this.name(); }
    //  public void setName(final String x$1) { this.name_$eq(x$1); }

    val user = new User09
    user.setName("wangwu")
    println(user.getName)

  }

  class User09{ //内部类
    //属性
    @BeanProperty
    var name : String = ""  //也可以写null
    //  var age : Int = null  //错误,类型不匹配
    var age : Int = _
    val sex : String = "男"
  }
}





