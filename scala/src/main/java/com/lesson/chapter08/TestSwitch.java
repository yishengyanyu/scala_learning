package com.lesson.chapter08;

/**
 * @author LiuJing
 * @create 2020-05-30 9:05
 */
public class TestSwitch {
    public static void main(String[] args) {
        int a = 10;

        //switch穿透:满足一个条件没有跳出, 会继续向后匹配执行
        switch (a) {
            case 5:
                System.out.println("5");
                break;
            case 6:
                System.out.println("6");
                break;
            case 7:
                System.out.println("7");
                break;
            case 10:
                System.out.println("10");

            default:
                System.out.println("default");
        }
    }
}
