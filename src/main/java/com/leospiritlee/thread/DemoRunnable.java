package com.leospiritlee.thread;

/**
 * @Project: CodeSegment
 * @ClassName DemoRunnable
 * @description: demo 实现 runnable 接口
 * @author: leospiritlee
 * @create: 2020-06-17 21:27
 **/
public class DemoRunnable {
    public static class MyThread implements Runnable{

        @Override
        public void run() {
            System.out.println("This is my thread");
        }

    }

    public static void main(String[] args) {
        new Thread(new MyThread()).start();

        new Thread(()->{

            System.out.println("Java 8 匿名内部类");
        }).start();
    }
}
