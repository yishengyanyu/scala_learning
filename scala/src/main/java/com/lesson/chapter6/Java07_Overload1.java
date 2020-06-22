package com.lesson.chapter6;

import org.testng.annotations.Test;

/**
 * @author LiuJing
 * @create 2020-05-25 14:29
 */
public class Java07_Overload1 {
    public static void main(String[] args) {
        User user1 = new User();    //User类型
        test1(user1);

        Person user2 = new User();  //Person类型
        test1(user2);
    }

    public static void test1(Person person){
        System.out.println("person...");
    }

//    public static void test1(User user){
//        System.out.println("user...");
//    }
}

class Person{

}

class User extends Person{

}