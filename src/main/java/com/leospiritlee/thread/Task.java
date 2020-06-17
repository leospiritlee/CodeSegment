package com.leospiritlee.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @Project: CodeSegment
 * @ClassName Task
 * @description: Callable 实现demo
 * @author: leospiritlee
 * @create: 2020-06-17 21:39
 **/
public class Task implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {

        Thread.sleep(1000);
        return 2;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        Task task = new Task();
        Future<Integer> result = executorService.submit(task);
        System.out.println(result.get());
    }
}
