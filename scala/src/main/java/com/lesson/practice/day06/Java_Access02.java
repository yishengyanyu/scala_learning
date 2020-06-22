package com.lesson.practice.day06;

import org.testng.annotations.Test;

/**
 * @author LiuJing
 * @create 2020-05-25 19:54
 */
public class Java_Access02 {
    public static void main(String[] args) {
        //private测试
        Person2 p = new Person2();
//        System.out.println(p.name);//编译不通过
    }
}

class Person2{
    private String name;

    class User{
        @Test
        public void test(){
            Person2 p = new Person2();
            System.out.println(p.name);
        }
    }
}
