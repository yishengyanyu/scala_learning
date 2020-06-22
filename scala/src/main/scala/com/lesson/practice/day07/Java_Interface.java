package com.lesson.practice.day07;

/**
 * @author LiuJing
 * @create 2020-05-25 22:32
 */
public class Java_Interface {
    public static void main(String[] args) {
        Phone p = new Phone();

        Listen l = p;

    }
}

interface Listen{
    public static final String way = "耳机";  //常量

    public void sing();

    public abstract void music();
}

interface Watch{
    public void novel();

    public abstract void movies();
}

interface Play{
    public int Players = 2;

    public void games();
}

class Phone implements Listen,Watch,Play{
    public static String model;
    public static double price;

    public void sing() {

    }

    public void music() {

    }

    public void novel() {

    }

    public void movies() {

    }

    public void games() {

    }
}
