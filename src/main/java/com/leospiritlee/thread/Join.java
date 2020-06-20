package com.leospiritlee.thread;

import java.util.concurrent.TimeUnit;

/**
 * @Project: CodeSegment
 * @ClassName Join
 * @description: 主线程等待子线程处理完毕后执行
 * sleep方法是不会释放当前的锁的，而wait方法会
 *
 * wait可以指定时间，也可以不指定；而sleep必须指定时间。
 * wait释放cpu资源，同时释放锁；sleep释放cpu资源，但是不释放锁，所以易死锁。
 * wait必须放在同步块或同步方法中，而sleep可以再任意位置
 *
 * @author: leospiritlee
 * @create: 2020-06-20 17:00
 **/
public class Join {

    static class Thread_a implements Runnable{

        @Override
        public void run() {
            try {
                System.out.println("This is a son thread ,then sleep 1s");
                TimeUnit.SECONDS.sleep(1);
                System.out.println("This is a son thread ,after sleep 1s");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new Thread_a());
        thread.start();
        thread.join();
        System.out.println("if not exist join(), the program will exist");
    }

}
