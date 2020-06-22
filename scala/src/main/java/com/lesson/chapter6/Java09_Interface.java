package com.lesson.chapter6;

/**
 * @author LiuJing
 * @create 2020-05-26 11:33
 */
public class Java09_Interface {
    public static void main(String[] args) {
        Test09 test = new Person09();
        System.out.println(test);

        System.out.println(User099.class.getInterfaces().length);   //结果:0
        //User099并未实现Test09接口
        //真正的写法
        //多态的传递
        Test09 test1 = new Person09();
        Person09 person = new User099();
    }
}

interface Test09{

}

class Person09 implements Test09{

}

class User099 extends Person09{

}