package com.leospiritlee.thread;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

/**
 * @Project: CodeSegment
 * @ClassName CountDownLatchDemo
 * @description: CountDownLatch demo
 *  需要注意的是构造器中的计数值（count）实际上就是闭锁需要等待的线程数量。
 *  这个值只能被设置一次，而且CountDownLatch没有提供任何机制去重新设置这个计数值。
 *
 *  CyclicBarrier  reset 可以重置屏障
 *
 * @author: leospiritlee
 * @create: 2020-06-21 19:44
 **/
public class CountDownLatchDemo {

    public static void main(String[] args) {

        CountDownLatch countDownLatch = new CountDownLatch(3);


        new Thread(()->{

            try {
                System.out.println("等待数据加载...");
                System.out.println(String.format("还有%d个前置任务", countDownLatch.getCount()));


                countDownLatch.await();
                System.out.println("数据加载完成，正式开始游戏！");

            }catch (InterruptedException e){
                e.printStackTrace();
            }

        }).start();


        new Thread(new PreTaskThread("加载地图数据", countDownLatch)).start();
        new Thread(new PreTaskThread("加载人物模型", countDownLatch)).start();
        new Thread(new PreTaskThread("加载背景音乐", countDownLatch)).start();
    }

    static class PreTaskThread implements Runnable{

        private String task;
        private CountDownLatch countDownLatch;

        public PreTaskThread(String task, CountDownLatch countDownLatch) {
            this.task = task;
            this.countDownLatch = countDownLatch;
        }

        @Override
        public void run() {

            try {
                Random random = new Random();

                Thread.sleep(random.nextInt(1000));

                System.out.println(task + " - 任务完成");

                countDownLatch.countDown();
            }catch (InterruptedException e){
                e.printStackTrace();
            }

        }
    }

}
