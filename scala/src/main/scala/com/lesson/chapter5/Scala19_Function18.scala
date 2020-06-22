package com.lesson.chapter5

/**
 * @author LiuJing
 * @create 2020-05-22 14:26
 */
object Scala19_Function18 {
  def main(args: Array[String]): Unit = {
    // Scala - 函数式编程 - 惰性(lazy)函数 - 延迟加载
    // lazy延迟加载功能是编译器在编译时产生大量的方法进行调用所实现的。
    // 用到数据的时候加载数据
    // 10000 User
    def test(): String = {
      println("xxxxxxxxxx")
      "zhangsan"
    }

    lazy val name = test()
    println("********************") // 1 hour
    println("name = " + name)

    //将一个对象转换为另外一个类型的对象
    val a : Any = "abc"
    val b: String = a.asInstanceOf[String]
  }
}
