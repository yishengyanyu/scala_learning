package com.lesson.chapter7

/**
 * @author LiuJing
 * @create 2020-05-26 15:57
 */
object Scala01_Collection_Array {
  def main(args: Array[String]): Unit = {
    //Scala - 集合 - 数组
    //Scala中[]里面写的是泛型
    //创建数组对象
    //new Array[String](5)编译后自动生成Java中的数组代码
    //java : String[] array = new String[5];
    //  array[0] = "zhangsan"
    val array = new Array[String](5)
    //可以设定泛型改变数组的类型
    //改变类型后:[Ljava.lang.String;@7c75222b
    println(array)
    //数组的字符串打印(Object类型):[Ljava.lang.Object;@48140564
    //向数组中添加数据
    //Scala中访问数组指定元素,需要使用(),而不是[]
    array(0) = "zhangsan"
    array(1) = "zhangsan1"
    array(2) = "zhangsan2"
    array(3) = "zhangsan3"
    array(4) = "zhangsan4"
    //...

    //遍历数组中的数据
    //只要是集合就可以采用for循环遍历
    for(s <- array){
      println(s)
    }

    //按照规则生成字符串,以","分隔开
    println(array.mkString(","))

  }

}
