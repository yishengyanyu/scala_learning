package com.lesson.chapter6;

import org.testng.annotations.Test;

/**
 * @author LiuJing
 * @create 2020-05-25 14:14
 */
public class Java07_Overload {
    public static void main(String[] args) {
        byte b = 10;

        //byte b (10)
        //0000 1010 =>  byte = 10
        //0000 0000 0000 1010   => short = 10
        //0000 0000 0000 0000 0000 0000 0000 1010   => int = 10
        test1(b);
        //输出结果为bbbb
        //当bbbb注释掉,输出ssss
        //当ssss也注释掉,输出iiii
        //绝对不可能输出cccc,原因:char类型没有负数,不可能提升精度到char
        //byte,short无法转换为char


    }

    public static void test1(byte b){
        System.out.println("bbbb");
    }

    public static void test1(short s){
        System.out.println("ssss");
    }

    public static void test1(char c){
        System.out.println("cccc");
    }

    public static void test1(int i){
        System.out.println("iiii");
    }
}
