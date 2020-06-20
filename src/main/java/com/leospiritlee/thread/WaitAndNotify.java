package com.leospiritlee.thread;

/**
 * @Project: CodeSegment
 * @ClassName WaitAndNotify
 * @description: 释放锁等待和通知
 * @author: leospiritlee
 * @create: 2020-06-20 16:33
 **/
public class WaitAndNotify {

    private static Object lock = new Object();

    static class Thread_a implements Runnable{

        @Override
        public void run() {
            synchronized (lock){
                for(int i = 0; i < 5; i++){
                    try {
                        System.out.println("Thread_a " + i);
                        //通知另一个同样锁等待中的线程
                        lock.notify();
                        //释放锁
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    static class Thread_b implements Runnable{

        @Override
        public void run() {
            synchronized (lock){
                for(int i = 0; i < 5; i++){
                    try {
                        System.out.println("Thread_b " + i);
                        //通知另一个同样锁等待中的线程
                        lock.notify();
                        //释放锁
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        new Thread(new Thread_a()).start();
        Thread.sleep(100);
        new Thread(new Thread_b()).start();
    }

}
