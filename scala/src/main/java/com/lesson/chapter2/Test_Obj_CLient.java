package com.lesson.chapter2;

import javax.sound.midi.SoundbankResource;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * @author LiuJing
 * @create 2020-05-19 18:21
 */
public class Test_Obj_CLient {
    public static void main(String[] args) throws IOException {
        //获取服务器
        Socket client = new Socket("localhost",10000);
        //获取对象
        User05 user = new User05();
        user.name = "zhangsan";
        //序列化对象
        ObjectOutputStream oos = new ObjectOutputStream(client.getOutputStream());
        oos.writeObject(user);

        client.close();
    }
}
