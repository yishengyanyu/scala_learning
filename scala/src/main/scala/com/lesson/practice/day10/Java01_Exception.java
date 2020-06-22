package com.lesson.practice.day10;

/**
 * @author LiuJing
 * @create 2020-05-31 20:13
 */
public class Java01_Exception {
    public static void main(String[] args) {
        User1 user = new User1();
        try {
            user.test();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
