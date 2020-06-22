package com.lesson.practice.day11

/**
 * @author LiuJing
 * @create 2020-06-01 20:22
 */
object Practice01_Generic {
  def main(args: Array[String]): Unit = {
    //声明
    val list:List[Int] = List(1,2,3,4)

    //协变: 子类当成父类 [-T], T作为子类当成父类
    val a1:AA[User] = new AA[User]
    val a2:AA[User] = new AA[Parent]
//    val a3:AA[User] = new AA[SubUser]

    //逆变: 父类当成子类 [-T], T作为父类当成子类
    val b1:BB[User] = new BB[User]
//    val b2:BB[User] = new BB[Parent]
    val b3:BB[User] = new BB[SubUser]

    //泛型上限
    val p = new Parent
    val u = new User
    val s = new SubUser
    val c = new CC
//    c.test1(p)  //error
    c.test1(u)
    c.test1(s)

    //泛型下限
    c.test2(p)
    c.test2(u)
//    c.test2(s)

  }
  class AA[-T]{

  }
  class BB[+T]{

  }
  class CC{
    def test1[T<:User](t:T) ={

    }
    def test2[T>:User](t:T) ={

    }
  }
  class Parent{

  }
  class User extends Parent{

  }
  class SubUser extends User{

  }
}
