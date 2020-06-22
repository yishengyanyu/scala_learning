package com.lesson.practice.day06;

/**
 * @author LiuJing
 * @create 2020-05-25 21:20
 */
public class Java_Override {
    public static void main(String[] args) {
        Person5 user1 = new User5();
        System.out.println(user1.sum());

        User5 user2 = new User5();
        System.out.println(user2.sum());
    }
}

class Person5{
    int i = 10;
    public int getI(){
        return i;
    }

    public int sum(){
        return getI() + 10;
    }
}

class User5 extends Person5{
    int i = 20;
    public int getI(){
        return i;
    }

//    public int sum(){
//        return i + 20;
//    }

}
