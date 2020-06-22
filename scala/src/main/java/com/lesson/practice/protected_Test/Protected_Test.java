package com.lesson.practice.protected_Test;

import com.lesson.practice.day06.Person3;
import org.testng.annotations.Test;

/**
 * @author LiuJing
 * @create 2020-05-25 20:07
 */
public class Protected_Test extends Person3{
    //protected测试2
    @Test
    public void test1(){
        Protected_Test p1 = new Protected_Test();
        System.out.println(p1.name);
        p1.test1();
//        System.out.println(p1.age);
    }

}


