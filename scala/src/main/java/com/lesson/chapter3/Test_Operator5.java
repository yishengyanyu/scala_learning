package com.lesson.chapter3;

/**
 * @author LiuJing
 * @create 2020-05-19 14:13
 */
public class Test_Operator5 {
    public static void main(String[] args) {
        String s = null;
        System.out.println(isNotEmpty(s));
    }

    public static boolean isNotEmpty(String s){
        return s != null && !s.trim().equals("");//关键在于&&的选择
    }
}
