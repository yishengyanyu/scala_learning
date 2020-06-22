package com.lesson.practice.day10




/**
 * @author LiuJing
 * @create 2020-05-31 17:35
 */
object Practice_Match1 {
  def main(args: Array[String]): Unit = {
    val a = 10
    val b = 20
    val operator = 30

    //匹配常量
    val result  = operator match {
      case 10 => "a"
      case 20 => "b"  //scala.MatchError
      case _ => "Nothing"
    }
    println(result)

    //匹配类型
    def typeMatch(i:Any):Unit={
      val result = i match {
        case 20 => "Int"
        case s:Short =>  "Short"
        case ss:String => "String"
        case list:List[String] => "List"
        case array:Array[String] => "Array[List]"
        case map:Map[_,_] => "Map"
        case _ => "something else"
      }
      println(result)
    }
    val list = List(1,2,3,4)
    typeMatch(list)

    val tuple: (Int, String, Int) = (1,"zhangsan",20)
    typeMatch(tuple)

    val array = Array(1,2,3,4,5)
    val array1 = Array("zhangsan","lisi","wangwu")
    typeMatch(array)
    typeMatch(array1)

    //匹配数组
    def arrayMatch(array:Array[_]): Unit = {
      val result = array match{
        case Array(0,_*) => "以0开头的数组"
        case Array(1,1) => "false"
        case Array(1,_*) => "以1开头的数组"
        case Array(0,0) => "true"
        case Array(1,1,1) => 3
        case s => "something else"
      }
      println(s"数组:$array+匹配的返回值为$result")
    }
    val array2 = Array(1,2,3,4,5,"zhangsan")
    arrayMatch(array2)

    val array3 = Array(Array(0), Array(1, 0), Array(0, 1, 0),
      Array(1, 1, 0), Array(1, 1, 0, 1), Array("hello", 90))
    for (elem <- array3) {
      arrayMatch(elem)
    }


    //匹配列表1
    for(list <- List(
      List(0),
      List(1,8),
      List(1,2,5,4,3),
      List("hello",1,2,3)
    )){
      val result = list match {
        case List(0) => "0"
        case List(x, y) => x + "," + y
        case List(0, _*) => "0 ..."
        case _ => "something else"
      }
      println(result)
    }

    //匹配列表2
    val list1 = List(1,2,"hello","zhangsan",30)
    def listMatch(list:List[_]): Unit ={
      list match{
        case first::second::rest => println(first + "-" + second + "-" + rest)
        case _ => println("什么都不是")
      }
    }
    listMatch(list1)

    //匹配元组
    for (tuple <- Array(
      (0, 1),   //0 ...
      (1, 0),   //10
      (1, 1),   //1 1
      (1, 0, 2))) { //something else
      val result = tuple match {
        case (0, _) => "0 ..." //是第一个元素是0的元组
        case (y, 0) => "" + y + "0" // 匹配后一个元素是0的对偶元组
        case (a, b) => "" + a + " " + b
        case _ => "something else" //默认
      }
      println(result)
    }

    val p1 = new Person_Match1("zhangsan",20)
    val p2 = new Person_Match1("lisi",30)
    val p = new Person_Match1("zhangsan",20)

    p match {
      case p1 => println("zhangsan,20")
      case p2 => println("lisi,20")
      case _ => "somrthing else"
    }

  }
}

class Person_Match1(val name :String,val age:Int){

}

object Person_Match1{
  def apply(name: String, age: Int): Person_Match1 = new Person_Match1(name, age)

  def unapply(arg: Person_Match1): Option[(String, Int)] = {
    Option((arg.name,arg.age))
  }
}
