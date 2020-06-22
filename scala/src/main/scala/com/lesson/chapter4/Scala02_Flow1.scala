package com.lesson.chapter4

/**
 * @author LiuJing
 * @create 2020-05-19 16:02
 */
object Scala02_Flow1 {
  def main(args: Array[String]): Unit = {
    val age = 30

    //Scala表达式有返回值
    //这个返回值取决于满足条件最后一行的代码的结果
    //此处result类型是推断出来的, 根据最后一行代码的返回值类型
    //推断的类型取决于满足条件和不满足条件结果都能够替代的类型(寻找共同父类)
    //result类型是根据每个分支最后一行代码的类型判断的
    val result = if(age < 18){  //result是Any类型
      "少年"
    }else if(age < 30){
      "青年"
    }else if(age < 60){
      30
      "中年"
      40
      "还没到中年呢"
      println("中年") //返回值类型为Unit
    } else {
      "老年"
    }
    println("结果 = " + result)

  }
}
