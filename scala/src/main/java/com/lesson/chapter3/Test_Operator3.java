package com.lesson.chapter3;

/**
 * @author LiuJing
 * @create 2020-05-19 11:32
 */
public class Test_Operator3 {
    public static void main(String[] args) {
        int i = 0;
        int j = i++;
        System.out.println("i = " + i + ", j =" + j );
        //什么叫赋值
        //将等号右边的计算结果给左边的过程叫做赋值
        //++放在变量后面,先赋值,再+1(不准确)
        //++放在变量前面,先+1,再赋值(不准确)
        int m = 0;
        m = m++;//反编译看一下
        System.out.println(m);//0
    }
}
