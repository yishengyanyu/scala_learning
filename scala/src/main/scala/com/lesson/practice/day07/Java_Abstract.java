package com.lesson.practice.day07;

import scala.Int;

/**
 * @author LiuJing
 * @create 2020-05-25 22:16
 */
public class Java_Abstract {
}

abstract class Person {
    public abstract void eat();

    protected abstract void walk();

    abstract void run();

    private void sleep(){

    }
}

abstract class Student extends Person{  //抽象类中可以没有抽象方法,有抽象方法的一定是抽象类

    public void eat() {

    }

    protected void walk() {

    }

    void run() {

    }
}

abstract class Student1 extends Person{
    //abstract和static,final不能共存
//    public static abstract void run(){
//
//    }

    public static final String name = "lisi";

//    public abstract final void walk(){
////
////    }
}

//模板方法设计模式
abstract class Produce{
    private static final String color = "red";
    private static final String pattern = "triangle";
    private Produce p;

    public Double time(){
        return p.craft()/0.5 + p.numberOfWorker()/0.3;
    }

    public abstract double craft(); //工艺

    public abstract int numberOfWorker();   //人数
}
