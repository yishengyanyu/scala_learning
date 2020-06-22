package com.lesson.chapter3;

/**
 * @author LiuJing
 * @create 2020-05-19 14:22
 */
public class Test_Operator6 {
    public static void main(String[] args) {
        byte b = 127;
        b = (byte)(127+1);
        System.out.println(b);//-128,精度损失

        // 0111 1111  127 ==> byte类型(8)
        //         1
        // 0000 0000 0000 0000 0000 0000 1000 0000  ==> int类型(32)
        //截取精度: 1000 0000 ==> -128(负数的最小值)
        //1111 1111 ==> -1(负数的最大值)
    }
}
