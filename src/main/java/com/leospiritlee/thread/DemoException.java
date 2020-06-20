package com.leospiritlee.thread;

/**
 * @Project: CodeSegment
 * @ClassName DemoException
 * @description: 统一异常处理
 * @author: leospiritlee
 * @create: 2020-06-20 09:54
 **/
public class DemoException {

    public static void main(String[] args) {

        ThreadGroup threadGroup = new ThreadGroup("group_1"){

            /**
             *  继承threadGroup 重写 uncaughtException 方法
             *  group下的线程成员抛出unchecked  exception 执行以下方法
             *      会捕获 thread_1 抛出的运行时异常
             * @param t
             * @param e
             */
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                System.out.println("throw exception thread :" + t.getName()+ ",error: " + e.getMessage());

            }
        };

        //线程组线程异常测试
        Thread thread_1 = new Thread(threadGroup, new Runnable() {
            @Override
            public void run() {
                throw new RuntimeException("thread 测试异常");
            }
        });

        thread_1.start();

        //非线程组异常测试 会抛出上层处理
        Thread thread_2 = new Thread( new Runnable() {
            @Override
            public void run() {
                throw new RuntimeException("thread 测试异常");
            }
        });

        thread_2.start();
    }

}
