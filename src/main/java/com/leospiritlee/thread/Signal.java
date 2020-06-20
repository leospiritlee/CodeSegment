package com.leospiritlee.thread;

/**
 * @Project: CodeSegment
 * @ClassName Signal
 * @description: 信号量
 * @author: leospiritlee
 * @create: 2020-06-20 16:40
 **/
public class Signal {

    private static volatile int signal = 0;

    static class Thread_a implements Runnable{
        @Override
        public void run() {
            while (signal < 5){
                if(signal %2 == 0){
                    System.out.println("thread_A signal: " + signal);
                    signal++;
                }
            }
        }
    }

    static class Thread_b implements Runnable{
        @Override
        public void run() {
            while (signal < 5){
                if(signal % 2 == 1){
                    System.out.println("Thread_b signal: " + signal);
                    signal++;
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        new Thread(new Thread_a()).start();
        Thread.sleep(1000);
        new Thread(new Thread_b()).start();
    }

}
