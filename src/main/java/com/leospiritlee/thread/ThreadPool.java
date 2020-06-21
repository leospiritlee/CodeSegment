package com.leospiritlee.thread;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @Project: CodeSegment
 * @ClassName ThreadPool
 * @description: ThreadPool
 * @author: leospiritlee
 * @create: 2020-06-21 21:53
 **/
public class ThreadPool {

    /**
     *  核心线程数 1
     *  采用默认工厂
     */
    private static final ScheduledExecutorService executor = new ScheduledThreadPoolExecutor(
            1, Executors.defaultThreadFactory()
    );

    private static SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");


    /**
     * scheduleAtFixedRate
     * 该方法在initialDelay时长后第一次执行任务，以后每隔period时长，
     * 再次执行任务。注意，period是从任务开始执行算起的。
     * 开始执行任务后，定时器每隔period时长检查该任务是否完成，如果完成则再次启动任务，否则等该任务结束后才再次启动任务。
     *
     * scheduleWithFixDelay
     *  该方法在initialDelay时长后第一次执行任务，以后每当任务执行完成后，等待delay时长，再次执行任务。
     *
     * @param args
     */
    public static void main(String[] args) {
        executor.scheduleWithFixedDelay(new Runnable() {
            @Override
            public void run() {
                if (haveMsgAtCurrentTime()) {
                    System.out.println(df.format(new Date()));
                    System.out.println("大家注意了，我要发消息了");
                }
            }
        }, 1, 1, TimeUnit.SECONDS);
    }

    /**
     * 测试方法 默认返回true
     * @return
     */
    public static boolean haveMsgAtCurrentTime(){
        //查询数据库，有没有当前时间需要发送的消息
        //这里省略实现，直接返回true
        return true;
    }
}
