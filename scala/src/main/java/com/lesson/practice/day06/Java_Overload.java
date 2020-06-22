package com.lesson.practice.day06;

import org.testng.annotations.Test;

/**
 * @author LiuJing
 * @create 2020-05-25 20:58
 */
public class Java_Overload {
    public static void main(String[] args) {
        User4 user1 = new User4();
        test1(user1);   //User4....

        Person4 user2 = new User4();
        test1(user2);   //Person4....
        test1((User4)user2);    //User4....
    }

    public static void test1(Person4 p){
        System.out.println("Person4...");
    }

    public static void test1(User4 u){
        System.out.println("User4...");
    }
}

class Person4{

}

class User4 extends Person4{

}





