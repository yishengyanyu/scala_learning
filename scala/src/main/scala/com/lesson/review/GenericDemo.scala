package com.lesson.review

/**
 * @author LiuJing
 * @create 2020-06-21 15:15
 */
object GenericDemo {
  implicit val ord:Ordering[User] = new Ordering[User]() {
    override def compare(x: User, y: User): Int = {
      x.age - y.age
    }
  }

  def main(args: Array[String]): Unit = {
    println(foo[Int](10, 20))
    foo1[Int](10,20)

    foo1[User](User("zs",20),User("ls",25)) //报错,需要增加隐式变量
  }

  //以下两种写法等价
  //更灵活,假设K为User类型,第二种不好用
  def foo1[K](n1:K,n2:K)(implicit ord:Ordering[K]): Unit ={
    println("foo1[K]")
    ord.max(n1,n2)
  }

  def foo[K:Ordering](n1:K,n2:K)={
    println("foo[K]")
    //从冥界召唤那个隐式值
    val ord: Ordering[K] = implicitly[Ordering[K]]
    ord.max(n1,n2)
  }

  case class User(name:String,age:Int)
}
/*
泛型上下文:
  [K:Ordering]
  表示必须存在一个隐式值:Ordering[K]
  其实是对隐式值的一个简写
 */
