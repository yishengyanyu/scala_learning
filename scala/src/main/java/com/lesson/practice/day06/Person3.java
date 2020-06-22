package com.lesson.practice.day06;

import org.testng.annotations.Test;

/**
 * @author LiuJing
 * @create 2020-05-25 19:57
 */
public class Person3{
    //protected测试2
    protected String name = "zhangsan";
    int age = 0;

    protected void test1(){
        System.out.println("lisi");
    }
}

class User3 extends Person3{

    public void test2(){
        User3 user = new User3();
        user.test1();
        System.out.println(user.age);
    }
}
