package com.leospiritlee.thread;

import java.util.concurrent.TimeUnit;

/**
 * @Project: CodeSegment
 * @ClassName ThreadLocalDemo
 * @description: ThreadLocal 使用
 *
 *  InheritableThreadLocal
 *      InheritableThreadLocal类与ThreadLocal类稍有不同，
 *      Inheritable是继承的意思。
 *      它不仅仅是当前线程可以存取副本值，而且它的子线程也可以存取这个副本值。
 *
 * @author: leospiritlee
 * @create: 2020-06-20 17:06
 **/
public class ThreadLocalDemo {

    static class Thread_a implements Runnable{

        private ThreadLocal<String> threadLocal;

        public Thread_a(ThreadLocal<String> threadLocal) {
            this.threadLocal = threadLocal;
        }

        @Override
        public void run() {
            threadLocal.set("A");
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Thread_a out : " + threadLocal.get());
        }
    }

    static class Thread_b implements Runnable{

        private ThreadLocal<String> threadLocal;

        public Thread_b(ThreadLocal<String> threadLocal) {
            this.threadLocal = threadLocal;
        }

        @Override
        public void run() {
            threadLocal.set("B");
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Thread_b out : " + threadLocal.get());
        }
    }

    public static void main(String[] args) {

        ThreadLocal<String> threadLocal = new ThreadLocal<>();
        new Thread(new Thread_a(threadLocal)).start();
        new Thread(new Thread_b(threadLocal)).start();
    }


}
