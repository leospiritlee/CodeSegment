package com.leospiritlee.thread;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @Project: CodeSegment
 * @ClassName SemaphoreTest
 * @description: Semaphore 模拟学生打饭场景
 * @author: leospiritlee
 * @create: 2020-06-20 16:45
 **/
public class SemaphoreTest {


    static Semaphore semaphore = new Semaphore(3);

    public static void main(String[] args) {
        for(int i = 1; i <= 10; i++){
            new Student(semaphore, "学生" + i).start();
        }
    }

}


class Student extends Thread{

    private Semaphore semaphore = null;
    private String name = null;

    public Student(Semaphore semaphore, String name) {
        this.semaphore = semaphore;
        this.name = name;
    }

    @Override
    public void run() {
        try {
            System.out.println(name + " 进入了餐厅");
            semaphore.acquire();
            System.out.println(name + " 拿到了打饭许可");
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println(name + " 打好了饭，释放打饭窗口");
            semaphore.release();
        }

    }
}