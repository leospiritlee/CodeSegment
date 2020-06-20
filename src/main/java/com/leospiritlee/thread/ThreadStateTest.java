package com.leospiritlee.thread;

/**
 * @Project: CodeSegment
 * @ClassName ThreadStateTest
 * @description: state测试
 * Thread.interrupt()：
 *          中断线程。这里的中断线程并不会立即停止线程，而是设置线程的中断状态为true（默认是false）；
 * Thread.interrupted()：
 *          测试当前线程是否被中断。线程的中断状态受这个方法的影响，意思是调用一次使线程中断状态设置为true，
 *          连续调用两次会使得这个线程的中断状态重新转为false；
 * Thread.isInterrupted()：
 *          测试当前线程是否被中断。
 *          与上面方法不同的是调用这个方法并不会影响线程的中断状态。
 *
 * @author: leospiritlee
 * @create: 2020-06-20 11:20
 **/
public class ThreadStateTest {

    public static void main(String[] args) throws InterruptedException {

        ThreadStateTest threadStateTest = new ThreadStateTest();
//        threadStateTest.blockTest();
//        threadStateTest.runnableTest();
        threadStateTest.timedWaitingTest();
    }


    private void timedWaitingTest() throws InterruptedException{
        Thread a = new Thread(new Runnable() {
            @Override
            public void run() {
                testMethod();
            }
        });

        Thread b = new Thread(new Runnable() {
            @Override
            public void run() {
                testMethod();
            }
        });

        a.start();
        a.join(1000);
        b.start();

        System.out.println("a current thread name: " + a.getName() + ",state: " + a.getState());
        System.out.println("b current thread name: " + b.getName() + ",state: " + b.getState());
    }

    private void runnableTest() throws InterruptedException{
        Thread a = new Thread(new Runnable() {
            @Override
            public void run() {
                testMethod();
            }
        });

        Thread b = new Thread(new Runnable() {
            @Override
            public void run() {
                testMethod();
            }
        });

        a.start();
        a.join();
        b.start();
        System.out.println("a current thread name: " + a.getName() + ",state: " + a.getState());
        System.out.println("b current thread name: " + b.getName() + ",state: " + b.getState());
    }


    private void blockTest() throws InterruptedException {
        Thread a = new Thread(new Runnable() {
            @Override
            public void run() {
                testMethod();
            }
        });

        Thread b = new Thread(new Runnable() {
            @Override
            public void run() {
                testMethod();
            }
        });


        /**
         *  没有任何休眠 a RUNNABLE  b BLOCKED
         *  a b中间休眠1s  a TIMED_WAITING b BLOCKED
         *  最后 休眠5s  当前a执行完 b执行完 TERMINATED
         */
        a.start();
//        Thread.sleep(1000L);
        b.start();

//        Thread.sleep(5000L);
        System.out.println("a current thread name: " + a.getName() + ",state: " + a.getState());
        System.out.println("b current thread name: " + b.getName() + ",state: " + b.getState());

    }


    /**
     *  模拟真实方法
     */
    private synchronized void testMethod(){
        try {
            Thread.sleep(2000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

}
