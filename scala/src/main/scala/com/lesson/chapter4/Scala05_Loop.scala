package com.lesson.chapter4

/**
 * @author LiuJing
 * @create 2020-05-19 16:46
 */
object Scala05_Loop {
  def main(args: Array[String]): Unit = {
    //Scala 循环
    //1."1 to 5"表示1.to(5),是一个集合[1,2,3,4,5](包含1和5)
    //2. "<-"指向赋值, 把集合中的元素依次赋值给i
    //3. i没有声明类型,可以自动类型推断
    for(i <- 1 to 5){
      println("i = " + i)
    }

    //1."1 until 5",是一个集合[1,2,3,4,5)(包含1,不包含5)
    for(i <- 1 until 5){
      println("i = " + i)
    }

    //Range(1,5)等同于 1 until 5
    for(i <- Range(1,5)){
      println("i = " + i)
    }

    //for循环默认情况是一个一个数据进行循环
    //Range可以传递三个参数:start, end(until), step(循环幅度)
    for(i <- Range(1,5,2)){
      println("i = " + i)
    }

    //by(2)或者by 2表示指明循环幅度step
    for(i <- 1 to 5 by 2){
      println("i = " + i)
    }
  }
}
