package com.lesson.chapter3;

/**
 * @author LiuJing
 * @create 2020-05-19 10:45
 */
public class TestOperator {
    public static void main(String[] args) {
        String a = new String("abc");
        String b = new String("abc");

        System.out.println(a == b);//flase
        System.out.println(a.equals(b));//true

    }
}
