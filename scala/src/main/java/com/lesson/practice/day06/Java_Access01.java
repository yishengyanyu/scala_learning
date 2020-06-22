package com.lesson.practice.day06;

import org.testng.annotations.Test;

/**
 * @author LiuJing
 * @create 2020-05-25 19:47
 */
public class Java_Access01 {
    public static void main(String[] args) {
        Person1 p1 = new Person1();
        //protected测试
//        p1.clone();//无法调用

        Object p2 = new Person1();
//        p2.clone();//无法调用

        //Person1继承的Object和Java_Access01继承的Object不一样
    }
}

class Person1{

    public void test1() throws CloneNotSupportedException {
        Person1 p1 = new Person1();
        p1.clone(); //可以调用
    }
}