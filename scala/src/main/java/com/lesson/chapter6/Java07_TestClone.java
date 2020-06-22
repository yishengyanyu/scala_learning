package com.lesson.chapter6;

/**
 * @author LiuJing
 * @create 2020-05-25 15:34
 */
public class Java07_TestClone {
    public static void main(String[] args) throws CloneNotSupportedException {
        AAA aaa = new AAA();
        //方法的提供者:com.lesson.chapter6.AAA
        //方法的调用者:com.lesson.chapter6.Java07_TestClone
        aaa.clone();

        //方法的提供者:java.lang.Object
        //方法的调用者:com.lesson.chapter6.Java07_TestClone
        Object bbb = new AAA();
//        bbb.clone();  //用不了
        bbb.toString();
    }
}

class AAA {
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
