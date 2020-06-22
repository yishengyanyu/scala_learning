package com.lesson.chapter6

/**
 * @author LiuJing
 * @create 2020-05-23 14:36
 */
object Scala13_Field4_Access {
  def main(args: Array[String]): Unit = {
    //Scala-面向对象-访问权限
    /*
    java: 4种访问权限
    private: 私有权限,同类 //子类可以继承父类的私有属性,但是没有访问权限
    default: 包权限,本类可以访问,同包可以访问
    protected: 受保护的权限,本类,同包,子类
    public: 公共权限,任意地方

    Scala: 4种访问权限
    private: 私有权限, 同类
    private[包名]: 包私有权限, 同类,同包
    protected: 受保护的权限,同类,子类 //同包不能用
    (default): 公共权限,任意地方  Scala中没有public关键字
     */
  }

  class User{
  private var name:String = _

  }
}





