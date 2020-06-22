package com.lesson.chapter6

/**
 * @author LiuJing
 * @create 2020-05-25 22:52
 */
object Scala01_Object {
  def main(args: Array[String]): Unit = {
    //Scala - 面向对象
    //Scala面向对象基本语法和Java是相同的
    /*
        Java :

        package com.atguigu.bigdata.xxxxxx

        import java.util.*

        public class Dept {
            private Strign name;
        }

        public class JavaUser06 {
            public Dept dept;
            private String name;
            public void setName( String name ) {
                this.name = name;
            }
            public String getName() {
                return this.name;
            }
        }

        Dept d = new Dept();
        JavaUser06 user = new JavaUser06();
        user.dept = d;
     */

    val dept:Dept01 = new Dept01

    val user = new User01
    user.dept = dept
    println(user.dept)
    user.name = "lisi"
    user.test()
    println(s"用户${user.name}所在的部门${user.dept.name}")
  }
}

class Dept01{
  var name : String = "开发部门"
}

class User01{
  var dept : Dept01 = null
  var name = "zhangsan"

  def test(): Unit ={
    println("user,test...")
  }
}