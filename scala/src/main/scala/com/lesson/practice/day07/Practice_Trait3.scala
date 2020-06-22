package com.lesson.practice.day07

/**
 * @author LiuJing
 * @create 2020-05-26 22:32
 */
object Practice_Trait3 {
  def main(args: Array[String]): Unit = {
    //MysqlA -> DBA -> OperateA( operData() )
    //MysqlA -> LogA -> OperateA( operData() )
    new MysqlA().operData()
    //

  }
}

trait OperateA{
  def operData(): Unit ={
    println("操作数据")
  }
}
trait DBA extends OperateA{
  override def operData(): Unit ={
    print("向数据库中")
    super.operData()
  }
}
trait LogA extends OperateA{
  override def operData(): Unit ={
    print("向日志中") //[Operate37]
    super[OperateA].operData() //指定特质类型,改变执行顺序
  }
}
class MysqlA extends DBA with LogA {

}


