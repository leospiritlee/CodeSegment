package com.leospiritlee.thread;

import java.util.stream.IntStream;

/**
 * @Project: CodeSegment
 * @ClassName DemoPriority
 * @description: 线程优先级 demo
 *      Java程序中对线程所设置的优先级只是给操作系统一个建议，操作系统不一定会采纳。
 *      而真正的调用顺序，是由操作系统的线程调度算法决定的。
 *
 * @author: leospiritlee
 * @create: 2020-06-20 09:40
 **/
public class DemoPriority {

    public static class T1 extends Thread{
        @Override
        public void run() {
            super.run();
            System.out.println("current thread name is:" + Thread.currentThread().getName());
            System.out.println("current thread priority is:" + Thread.currentThread().getPriority());
        }
    }


    public static void main(String[] args) {
        Thread thread_a = new Thread();
        System.out.println("thread_a priority:" + thread_a.getPriority());

        Thread thread_b = new Thread();
        thread_b.setPriority(10);
        System.out.println("set thread_b priority:" + thread_b.getPriority());

        IntStream.range(1,10).forEach(i->{
            Thread thread = new Thread(new T1());
            thread.setPriority(i);
            thread.start();
        });



    }

}
