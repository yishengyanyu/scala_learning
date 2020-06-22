package com.lesson.chapter11;

import com.sun.xml.internal.bind.v2.TODO;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author LiuJing
 * @create 2020-06-01 8:53
 */
public class Java01_Generic {
    public static void main(String[] args) {

        //TODO 泛型 - JDK1.5 - pizza - 马丁
        //泛型类
        //泛型方法
        //作用:类型约束
        List<String> list = new ArrayList();
        List<Integer> list1 = new ArrayList();
        list.add("");
        String s = list.get(0);

        //类型擦除
        //Java虚拟机没有泛型的概念,所以泛型只在编译器层次起作用
        test(list);

        ArrayList list2 = new ArrayList();
        list2.add("zhangsan");
//        List<Integer> list3 = list2;    //无法识别类型

        //TODO 泛型问题
        //数据类型和泛型不是一个层面的东西
        //如果能够泛型转化的话,那么底层就会出现类型转换
        //那么就可能出现风险,编译不允许这种情况出现
        //内部类型影响外部类型
        List<String> stringList = new ArrayList();
        test(stringList);

        //TODO 泛型的使用
        //  为了能够让泛型更加方便地使用,Java提供了特殊操作
        //  <? extends User> or <? super User>

        //泛型其实在两个维度进行操作
        //外部类型:List
        //内部类型:<String>
        //如果内部类型相同,那么类型存可以在上下级关系
        List<String> stringList1 = new ArrayList<String>();
        test1(stringList1);


    }
    public static void test(List<String> list){

    }

    public static void test1(Collection<String> list){

    }
}
