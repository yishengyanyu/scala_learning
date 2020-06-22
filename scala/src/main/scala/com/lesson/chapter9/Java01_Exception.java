package com.lesson.chapter9;

import java.io.FileNotFoundException;

/**
 * @author LiuJing
 * @create 2020-05-31 16:44
 */
public class Java01_Exception {
    public static void main(String[] args) throws Exception {
        // Java在调用scala对象时，并没有明确的处理异常
        // 如果想要在处理时，明确异常的处理，那么需要在scala对象的方法前增加注解
        // @throws[异常类型]
        Dept02 dept = new Dept02();
        dept.test();
    }
}
