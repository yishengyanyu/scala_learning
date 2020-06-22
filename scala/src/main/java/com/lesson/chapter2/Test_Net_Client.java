package com.lesson.chapter2;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author LiuJing
 * @create 2020-05-19 8:58
 */
public class Test_Net_Client {
    public static void main(String[] args) throws  IOException {
        //客户端
        Socket client = new Socket("localhost",9999);//指定服务器和端口号



        client.getOutputStream().write(10);

        System.out.println("客户端发送的数据为: 10" );

        client.close();

    }
}
