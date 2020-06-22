package com.lesson.chapter2

/**
 * @author LiuJing
 * @create 2020-05-19 10:00
 */
object Scala18_DataType2 {

  //Nothing: 没有值 (Exception)
  //Unit: 没有返回值(void),放在方法返回值位置, 在函数中用
  def main(args: Array[String]): Unit = {
    //Null
    //Scala将null作为特殊对象进行处理,类型就是Null
    //String是Null的父类
    val s = null;
    val ss : String = null
    //AnyVal类型不能使用Null赋值
//    val i : Int = null //类型不匹配
    //Nothing: 没有值
    //Nil : 空集合
    val nil : List[Nothing] = Nil //空集合

    //Any:Scala语言中最通用类型,可代替AnyRef和AnyVal
    //Object在Java中是所有引用类型的父类, 但基本数据类型和Object无关
    //Any范围
    val a : Any = 1
    val b : Any = "123"
    val r: AnyRef = "123"

  }

  def test1() : Nothing ={
    throw new Exception;
  }
}
