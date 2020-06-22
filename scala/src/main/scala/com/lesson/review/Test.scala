package com.lesson.review

/**
 * @author LiuJing
 * @create 2020-06-21 21:01
 */
object Test {
  def main(args: Array[String]): Unit = {
    def foo(one:Int,others:Int*) ={
      others
    }
    val array = Array(1,2,3,4)

    //将数组元素传给函数参数
    println(foo(1, array: _*))

    //自定义map
    def myMap(array:Array[Int], op : Int => Int):Array[Int] ={ //op表示对map的操作
      //for推导
      for(elem <- array) yield op(elem)
    }

    //map有返回值,foreach没有返回值
    val array1: Array[Int] = myMap(array,x => x*x)
    println(array1.mkString(","))

    //自定义filter
    def myFilter(array:Array[Int])(op : Int => Boolean) ={
      //for推导
      for(elem <- array) yield {
        val flag: Boolean = op(elem)
        if(flag == true) {
          elem
        }
      }
    }
    val array2= myFilter(array1)(x => x%2==0)
    array2.foreach(println)
  }
}
