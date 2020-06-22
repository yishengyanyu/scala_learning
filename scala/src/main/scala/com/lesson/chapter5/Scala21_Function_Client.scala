package com.lesson.chapter5

import java.io.ObjectOutputStream
import java.net.Socket


/**
 * @author LiuJing
 * @create 2020-05-31 21:08
 */
object Scala21_Function_Client {
  def main(args: Array[String]): Unit = {
//    start("socket"){
//      val client: Socket = envData.asInstanceOf[Socket]

//      val outObject = new ObjectOutputStream(client.getOutputStream)
//      // Out -> function -> 对象
//      // 函数对象
//      // Scala中的类默认都是已经序列化
//      val task = new Task()
//      task.data = 10
//      task.logic = (x:Int)=>{x * 2}
//      //task.logic = _ * 2
//      outObject.writeObject(task)
//      outObject.flush()
//      // 关闭socket的输出流，但是输入流可用
//      client.shutdownOutput()
//
//      // In
//      val inObject = new ObjectInputStream(client.getInputStream)
//      val result: Int = inObject.readObject().asInstanceOf[Int]
//      println("获取计算结果 ：" + result)
//      //client.shutdownInput()
//      inObject.close()
//    }
  }
}
