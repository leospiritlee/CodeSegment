package com.leospiritlee.thread;

/**
 * @Project: CodeSegment
 * @ClassName DemoGroup
 * @description: Thread group
 *  ThreadGroup是一个标准的向下引用的树状结构，
 *  这样设计的原因是防止"上级"线程被"下级"线程引用而无法有效地被GC回收。
 *
 * @author: leospiritlee
 * @create: 2020-06-20 09:34
 **/
public class DemoGroup {

    public static void main(String[] args) {
        Thread testThread = new Thread(()->{
            System.out.println("当前线程组的名称:" + Thread.currentThread().getThreadGroup().getName());
            System.out.println("当前线程名称:" + Thread.currentThread().getName());
        });

        testThread.start();
        System.out.println("执行main方法线程的名字:" + Thread.currentThread().getName());
    }

}
