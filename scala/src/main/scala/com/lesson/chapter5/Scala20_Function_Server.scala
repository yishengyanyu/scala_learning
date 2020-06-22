package com.lesson.chapter5

import java.net.{ServerSocket, Socket}



/**
 * @author LiuJing
 * @create 2020-05-31 21:07
 */
object Scala20_Function_Server{
  def main(args: Array[String]): Unit = {
//    start("serverSocket") {
//      val server: ServerSocket = envData.asInstanceOf[ServerSocket]
//      while ( true ) {
//        var client: Socket = server.accept()
//        new Thread(
//          new Runnable {
//            override def run(): Unit = {
//              // In
//              val inObject = new ObjectInputStream(client.getInputStream)
//              val task = inObject.readObject().asInstanceOf[Task]
//              //inObject.close()
//              // 关闭socket的输入流，但同时输出流可用
//              client.shutdownInput()
//              // Out
//              val outObject = new ObjectOutputStream(client.getOutputStream)
//              val result = task.compute()
//              // Out -> function -> 对象
//              outObject.writeObject(result)
//              outObject.flush()
//              outObject.close()
//
//              if ( !client.isClosed ) {
//                client.close()
//              }
//              client = null
//            }
//          }
//        ).start()
//      }
//    }
  }
}
