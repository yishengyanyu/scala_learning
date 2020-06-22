package com.lesson.practice

/**
 * @author LiuJing
 * @create 2020-05-20 21:58
 */
object Scala02_Function2 {

  /**
   * 1. 如果想把一个任意的数字A通过转换后得到它的2倍，那么这个转换的函数应该如何声明和使用
   *
   * 2. 如果上一题想将数字A转换为任意数据B（不局限为数字），转换规则自己定义，该如何声明
   *
   * 3. 如果函数调用：  test(10,20,c)的计算结果由参数c来决定，这个参数c你会如何声明
   *
   * 4. 如果设计一个用于过滤的函数，你会如何做？
   * 要求：对传递的包含多个单词的字符串参数,根据指定的规则对word进行过滤
   * 例子："hello world scala spark" => 首写字母为s => "scala, spark"
   */
  def main(args: Array[String]): Unit = {
    //1.得到A*2
    def testA(a:Double) = a*2
    println(testA(3))

    //2,A转换为B
    def testChange(a:Double, f:(Double)=>Any) : Any = {
//      f()
    }
    //3.参数c的声明:将参数c赋值为函数
    def test(x:Int,y:Int,c:(Int,Int)=>Any) = {
      c(x,y)
    }
    test(10,20, _ + _)

    //4.
    def filter(s:String) {
      val words = s.split(" ")
//      for(word <- words) ){
//        if(words[i].subString())
//      }
    }



  }
}
