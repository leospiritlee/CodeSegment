package com.leospiritlee.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

/**
 * @Project: CodeSegment
 * @ClassName TaskCallable
 * @description: FutureTask的使用
 * @author: leospiritlee
 * @create: 2020-06-17 23:10
 **/
public class TaskCallable implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        Thread.sleep(1000);
        return 2;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService executorService = Executors.newCachedThreadPool();
        FutureTask<Integer> futureTask = new FutureTask<>(new TaskCallable());
        executorService.submit(futureTask);
        System.out.println(futureTask.get());
    }
}
