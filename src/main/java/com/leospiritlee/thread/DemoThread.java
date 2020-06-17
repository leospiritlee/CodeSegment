package com.leospiritlee.thread;

/**
 * @Project: CodeSegment
 * @ClassName Demo
 * @description: demo 继承 thread demo
 * @author: leospiritlee
 * @create: 2020-06-17 21:23
 **/
public class DemoThread {
    public static class MyThread extends Thread{

        @Override
        public void run() {
            System.out.println("This is my thread");
        }
    }

    public static void main(String[] args) {
        Thread myThread = new MyThread();
        myThread.start();
    }
}
