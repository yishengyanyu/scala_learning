package com.lesson.chapter8

/**
 * @author LiuJing
 * @create 2020-05-30 9:13
 */
object Scala01_Match {
  def main(args: Array[String]): Unit = {
    val a: Int = 10
    val b: Int = 20
    val operator: Char = '*'

    /*
      int i = 20
      switch (i) {
        default :
            System.out.println("other number");
            break;
        case 10 :
            System.out.println("10");
            //break;
        case 20 :
            System.out.println("20");
            break;
      }
     */

    //规则匹配,满足规则匹配成功
    //TODO case_的分支一般写在所有分支的最后,模仿default语法
    //  如果所有分支都不匹配,还没有case_分支,那么会发生错误
    val result = operator match { //不会产生歧义,一般情况反编译后为switch-case
      case _ => "illegal" //不满足条件的任意值匹配下划线
      case '+' => a + b
      case '-' => a - b
      case '*' => a * b
      case '/' => a / b
    } //此种情况下,反编译没有switch-case
    //可调整顺序

    println(result) //illegal
  }
}
