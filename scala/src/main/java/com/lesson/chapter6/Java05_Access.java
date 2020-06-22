package com.lesson.chapter6;

import org.testng.annotations.Test;

/**
 * @author LiuJing
 * @create 2020-05-25 10:07
 */
public class Java05_Access {
    public static void main(String[] args) {
        User05 user = new User05();
        //Object提供的方法:private,protected,public
        //user.clone();  //用不了
        //访问权限:权利和限制
        //protected:同类,同包,子类
        //方法的提供者:java.lang.Object
        //方法的调用者:com.lesson.chapter6.User05
        //问题1:方法的调用者不是User05
        //  而是:com.lesson.chapter6.Java05_Access
        //问题2:"."的作用?   //表示从属关系
        user.name = "zhangsan"; //给user对象的属性name赋值为"张三"
        //user.clone(); 表示Java05_Access通过main()调用user对象的clone()方法
        //问题3:Java05_Access和Object没有父子关系
        //构建一个对象就有一个Object,两个Object之间互不相干

    }
}

//声明一个类,会默认继承Object类,继承Object中的方法
class User05{
    String name;
    User05 user = new User05();

    @Test
    public void test1() throws CloneNotSupportedException {
        user.clone();
    }
}
