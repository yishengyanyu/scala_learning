package com.lesson.chapter6;

/**
 * @author LiuJing
 * @create 2020-05-25 14:45
 */
public class Java07_Override {
    public static void main(String[] args) {
        //User2 user = new User2();


        // 第一个问题：40
        // 第二个问题：40
        // 第三个问题：20
        // 第四个问题：30
        Person1 user = new User1(); // 多态
        System.out.println(user.sum());

    }
}

class Person1{
    public int i = 10; // 父类的i
    public int sum() {
        return getI() + 10;
        //return i + 10;
    }
    public int getI() {
        return i;
    }
}

class User1 extends Person1{
    public int i = 20;//当前类的i
    public int getI() {
        return i;
    }
}