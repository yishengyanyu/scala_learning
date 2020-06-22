package com.lesson.spark;

import java.util.Random;

/**
 * @author LiuJing
 * @create 2020-06-05 10:06
 */
public class TestRandom {
    public static void main(String[] args) {
        Random r1 = new Random(10);
        for(int i = 1; i <= 5; i++){
            System.out.println(r1.nextInt(10));
        }

    }
}
