package com.lesson.chapter6;

import org.testng.annotations.Test;

/**
 * @author LiuJing
 * @create 2020-05-25 10:44
 */
public class Java06_Access {
}

class Person06{

    public void test1(){
        System.out.println("person test....");
    }
}

class User06 extends Person06{

    public void test1(){
        System.out.println("user test....");
    }
}
