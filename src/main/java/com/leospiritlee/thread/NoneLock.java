package com.leospiritlee.thread;

/**
 * @Project: CodeSegment
 * @ClassName NoneLock
 * @description: 无锁测试
 * @author: leospiritlee
 * @create: 2020-06-20 11:49
 **/
public class NoneLock {


    static class Thread_a implements Runnable{

        @Override
        public void run() {
            for(int i = 0; i < 100; i++){
                System.out.println("Thread_a " + i);
            }
        }
    }

    static class Thread_b implements Runnable{

        @Override
        public void run() {
            for(int i = 0; i < 100; i++){
                System.out.println("Thread_b " + i);
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        new Thread(new Thread_a()).start();
        new Thread(new Thread_b()).start();
    }

}
