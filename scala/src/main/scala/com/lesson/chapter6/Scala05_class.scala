package com.lesson.chapter6

/**
 * @author LiuJing
 * @create 2020-05-23 14:36
 */
object Scala05_class {
  def main(args: Array[String]): Unit = {
    //Scala-面向对象-Class
    //Class和Object的区别
    //Object其实在编译时会产生两个类文件,一个是当前类的文件,还有一个是单例的类文件(产生单例对象,模拟静态语法)
    //    如:Scala05_class.class,Scala_class$.class
    //class其实在编译时只会产生当前类的class文件
    //    如:Scala05_class.class
    //class其实就是修饰普通的类
    //而Object用于修饰伴随着这个类所产生的一个单例对象,用于模仿java中的静态语法
    //Object中的方法和属性都可以通说类名直接访问,类似于静态语法
    //一般将使用Object声明的类称之为半生类,对应的那个单例对象称之为伴生对象
    //后来我们统一将相同名称的class,object声明的类做了区分
    //  使用class声明的类:伴生类
    //  使用Object声明的类:伴生对象

  }
}

//object Test{
//
//}
//
//class Test{
//
//}


