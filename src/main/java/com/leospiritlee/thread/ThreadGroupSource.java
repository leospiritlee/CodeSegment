package com.leospiritlee.thread;

/**
 * @Project: CodeSegment
 * @ClassName ThreadGroupSource
 * @description: threadGroup 源码
 * @author: leospiritlee
 * @create: 2020-06-20 09:59
 **/
public class ThreadGroupSource implements Thread.UncaughtExceptionHandler{

    //父threadGroup
    private final ThreadGroup parent = null;
    //threadGroup 名称
    String name;
    //threadGroup 最大优先级
    int maxPriority;
    //是否被销毁
    boolean destroyed;
    //是否守护线程
    boolean daemon;
    //是否可以中断
    boolean vmAllowSuspension;
    //未启动线程的线程数
    int nUnstartedThreads = 0;
    //threadGroup中的线程数目
    int nthreads;
    //threadGroup中的线程
    Thread threads[];
    //线程组数目
    int ngroups;
    //线程组数组
    ThreadGroup groups[];


    @Override
    public void uncaughtException(Thread t, Throwable e) {

    }
}
