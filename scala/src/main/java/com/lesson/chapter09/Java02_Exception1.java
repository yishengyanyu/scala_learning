package com.lesson.chapter09;

/**
 * @author LiuJing
 * @create 2020-05-30 14:45
 */
public class Java02_Exception1 {
    public static void main(String[] args) {
       try {
           //可能发生异常的代码
           int i = 0;
           int j = 10 / i;

           //异常捕捉的顺序:先捕捉范围小的异常,再捕捉范围大的异常
       }catch(java.lang.ArithmeticException e){
           e.printStackTrace();
       }catch(Exception e){
           //如果发生异常,处理的方案
           System.out.println("Exceptiopn...");
       }finally{
           //无论是否发生异常,都会执行的代码
           //资源的释放
       }
    }
}
