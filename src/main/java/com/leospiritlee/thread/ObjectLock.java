package com.leospiritlee.thread;

/**
 * @Project: CodeSegment
 * @ClassName NoneLock
 * @description: synchronize 锁测试
 * @author: leospiritlee
 * @create: 2020-06-20 11:49
 **/
public class ObjectLock {

    private static Object lock = new Object();


    static class Thread_a implements Runnable{

        @Override
        public void run() {
            synchronized (lock){
                for(int i = 0; i < 100; i++){
                    System.out.println("Thread_a " + i);
                }
            }
        }
    }

    static class Thread_b implements Runnable{

        @Override
        public void run() {
            synchronized (lock){
                for(int i = 0; i < 100; i++){
                    System.out.println("Thread_b " + i);
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        new Thread(new Thread_a()).start();
        //保证a先拿到锁
        Thread.sleep(10);
        new Thread(new Thread_b()).start();
    }

}
