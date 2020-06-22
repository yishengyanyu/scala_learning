package com.lesson.chapter8


/**
 * @author LiuJing
 * @create 2020-05-30 10:25
 */
object Scala04_Match3 {
  def main(args: Array[String]): Unit = {
    //TODO - 模式匹配 - 匹配规则

    //TODO 匹配对象
    val user = User("zhangsan",20)

    //Scala中模式匹配对象时,自动调用对象的unapply()方法
    //这里的匹配对象其实匹配的是对象的属性是否相同

    val result = user match {
      case User("zhangsan", 11) => "yes"
      case _ => "no"
    }

    //TODO 样例类
    //使用case关键字修饰的类
    //专门用于匹配对象
    //1. 样例类在编译时,会自动生成伴生对象以及apply方法
    //2. 样例类的构造参数自动使用val声明,所以参数其实就是类的属性
    //3. 如果想要更改属性,需要显示的将属性声明为var
    //4. 样例类会自动生成unapply方法
    //5. 样例类自动实现可序列化接口
    //实际开发中一般使用样例类
    val emp = Emp("lisi",30)
    emp match {
      case Emp("lisi",25) => println("yes")
      case _ => println("no")
    }

  }


  //声明样例类
  case class Emp(name: String, age: Int)

  //声明伴生类
  class User(val name: String, val age: Int)
  //声明伴生对象
  object User{
    //使用参数自动构建对象
    def apply(name: String, age: Int): User = new User(name, age)
    //使用对象自动获取参数
    def unapply(user: User): Option[(String, Int)] = {
      Option((user.name,user.age))
    }

  }
}
