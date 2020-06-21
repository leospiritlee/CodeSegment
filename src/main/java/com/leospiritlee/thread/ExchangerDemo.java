package com.leospiritlee.thread;

import java.util.concurrent.Exchanger;

/**
 * @Project: CodeSegment
 * @ClassName ExchangerDemo
 * @description: Exchanger类用于两个线程交换数据 支持泛型
 *  此类提供对外的操作是同步的；
 *  用于成对出现的线程之间交换数据；
 *  可以视作双向的同步队列；
 *  可应用于基因算法、流水线设计等场景。
 *
 *  Exchanger只能是两个线程交换数据吗？
 *          那三个调用同一个实例的exchange方法会发生什么呢？
 *          答案是只有前两个线程会交换数据，第三个线程会进入阻塞状态。
 *  exchange是可以重复使用的。也就是说。两个线程可以使用Exchanger在内存中不断地再交换数据。
 *
 * @author: leospiritlee
 * @create: 2020-06-21 19:35
 **/
public class ExchangerDemo {

    public static void main(String[] args) throws InterruptedException {

        Exchanger<String> exchanger = new Exchanger<>();

        new Thread(()->{

            try {
                System.out.println("这是线程A，得到了另一个线程的数据："
                        + exchanger.exchange("这是来自线程A的数据"));
            }catch (InterruptedException e){
                e.printStackTrace();
            }

        }).start();

        System.out.println("这个时候线程A是阻塞的，在等待线程B的数据");
        Thread.sleep(1000);

        new Thread(() -> {
            try {
                System.out.println("这是线程B，得到了另一个线程的数据："
                        + exchanger.exchange("这是来自线程B的数据"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }


}
