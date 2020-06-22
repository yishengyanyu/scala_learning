package com.lesson.chapter09;

import java.util.List;

/**
 * @author LiuJing
 * @create 2020-05-30 14:19
 */
public class Java01_Exception {
    public static void main(String[] args) {
        User user = null;
        //TODO 空指针异常,调用一个为空(null)的对象的成员属性或成员方法就会发生空指针异常
        //JVM执行程序是发生的错误,不是源码中的错误,是字节码运行的错误
        System.out.println(user.age);

        //age(Integer) => test => age(int)
        //拆箱操作可能会导致空指针异常
        //Integer.intValue
        test(user.age);

        Integer id1 = 200;
        Integer id2 = 200;   //引用类型
        //包装类型的数据比较一般用equals()
        //Integer的比较:-127-128比较相等,超过128不等
        //底层为valueOf
        //装箱:Integer.valueOf(static)
        System.out.println(id1 == id2);

//        Integer.valueOf(5)

        List list = null;
        //list.iterator() (member)
        //所有可迭代的对象都可以使用增强for循环
        for (Object o : list) {
            System.out.println(o);
        }

    }

    public static void test(int age){
        System.out.println("年龄 = " + age);
    }
}

class User {
    public static Integer age;
    public static Integer id;
}
