package com.lesson.chapter2;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author LiuJing
 * @create 2020-05-19 18:21
 */
public class Test_Obj_Server {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        //创建服务器
        ServerSocket server = new ServerSocket(10000);
        //获取客户端
        Socket client = server.accept();
        //获取输入流
        ObjectInputStream ois = new ObjectInputStream(client.getInputStream());
        User05 user = (User05)ois.readObject();
        System.out.println("服务器读取的用户数据为 " + user.name);
        server.close();
    }
}
