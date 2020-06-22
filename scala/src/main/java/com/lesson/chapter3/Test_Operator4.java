package com.lesson.chapter3;

import org.junit.jupiter.api.Test;

/**
 * @author LiuJing
 * @create 2020-05-19 11:53
 */
public class Test_Operator4 {
    public static void main(String[] args) {
        //阶乘
        System.out.println(test1(5));
    }
    
    @Test
    public static int test1(int num){
        if(num <= 1){
            return 1;
        } else {
//            return num * test1(num--);//出现栈滚动错误
            return num * test1(num - 1);
        }
    }
}
