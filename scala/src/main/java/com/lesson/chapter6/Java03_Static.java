package com.lesson.chapter6;

/**
 * @author LiuJing
 * @create 2020-05-23 16:01
 */
public class Java03_Static {
    public static void main(String[] args) throws Exception {
        Thread t1 = new Thread();
        Thread t2 = new Thread();

        t1.start();
        t2.start();

        //1.时间  2.对象锁
        //所有的区别来自于对象和成员

        //核心区别在字体上...
        //sleep()和t1无关,不可能让t1休眠,让当前正在执行的线程(main)休眠,休眠的是main,不是t1
        //sleep无法释放对象锁
        t1.sleep(500);  //静态方法和类型相关,和对象无关
        //wait()和t2相关,能够让t2等待
        //wait可以释放对象锁
        t2.wait(1000);  //成员方法和对象相关,和类型无关

    }
}
