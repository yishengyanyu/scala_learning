package com.lesson.chapter6

/**
 * @author LiuJing
 * @create 2020-05-26 9:04
 */
object Scala25_Test {
  def main(args: Array[String]): Unit = {
    //构建对象的两种方式
    //方式一:new的方式
//    val dept1 = new Dept03
//    //方式二:apply
//    val dept2 = Dept03()
//    //方式三:反射
//    val clazz = classOf[Dept03]
//    val dept3 = clazz.newInstance()
//    //方式四:clone => 访问权限 => 父子类 => 重载/重写 => 继承 => Any
//    val dept4 = dept3.clone()
    //方式五:反序列化

    //方式六:单例(不算)

    //将多个子类共通方法放在父类中 => protected("子类共通")

    //创建单例对象
  }
}

//class Dept03{
//  def this(name:String){
//    this()
//  }
//
//  def this(name:String,age:Int){
//    this(name)
//  }
//
//  protected def getDeptName(): String ={
//    return "xxxx"
//  }
//}
//
//object Dept03{
//  def apply(): Dept03 = {
//    new Dept03()
//  }
//}
//
//class SubDept1 extends Dept03 {
//
//}
//
//class SubDept2 extends Dept03 {
//
//}




