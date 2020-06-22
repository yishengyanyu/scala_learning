package com.lesson.chapter2;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author LiuJing
 * @create 2020-05-19 8:57
 */
public class Test_Net_Server {
    public static void main(String[] args) throws IOException {
//        //服务器
//        ServerSocket server = new ServerSocket(9999);
//        //接收客户端请求
//        Socket client = server.accept();
//
//        //input
//        int data = client.getInputStream().read();
//        System.out.println("从客户端接收的数据为:" + data);
//
//        server.close();
        ServerSocket server = new ServerSocket(9999);

        while(true){
            final Socket client = server.accept();
            //创建线程
            new Thread(
                    new Runnable() {
                        public void run() {
                            try {
                                int data = client.getInputStream().read();
                                System.out.println("从客户端接收的数据为:" + data);
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    }
            ).start();

        }

    }
}
