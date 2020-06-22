package com.lesson.practice.day11;

import java.util.ArrayList;
import java.util.List;

/**
 * @author LiuJing
 * @create 2020-06-01 20:34
 */
public class Java01_Generic1 {
    public static void main(String[] args) {
        //泛型
        List<String> list = new ArrayList<>();
        List list1 = new ArrayList();
        list1.add("string");

        //类型擦除
//        List<Integer> list2 = list1;

        test(list);

        //泛型上限
        //? extends class
        List<SubClass1> list2 = new ArrayList<>();
        test1(list2);


        //? super class
        List<ParentClass> list3 = new ArrayList<>();
        test2(list3);
    }

    public static void test(List<String> list){

    }

    public static void test1(List<? extends SubClass> list){

    }

    public static void test2(List<? super SubClass> list){

    }
}

class ParentClass {

}
class SubClass extends ParentClass{

}
class SubClass1 extends SubClass{

}
