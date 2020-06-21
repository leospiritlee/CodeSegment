package com.leospiritlee.thread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.RecursiveTask;

/**
 * @Project: CodeSegment
 * @ClassName FibonacciTest
 * @description: fork join 测试
 * @author: leospiritlee
 * @create: 2020-06-21 21:35
 **/
public class FibonacciTest {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        System.out.println("CPU核数：" + Runtime.getRuntime().availableProcessors());

        long startMillis = System.currentTimeMillis();

        Fibonacci fibonacci = new Fibonacci(40);

        Future<Integer> future = forkJoinPool.submit(fibonacci);
        System.out.println(future.get());

        long endMillis = System.currentTimeMillis();
        System.out.println(String.format("耗时：%d millis", (endMillis - startMillis)));
    }

    static class Fibonacci extends RecursiveTask<Integer>{

        int n;

        public Fibonacci(int n) {
            this.n = n;
        }

        /**
         *  核心逻辑在compute
         * @return
         */
        @Override
        protected Integer compute() {

            if(n < 1){
                return n;
            }else {
                // f(n-1)
                Fibonacci f1 = new Fibonacci(n-1);
                f1.fork();

                // f(n-2)
                Fibonacci f2 = new Fibonacci(n-2);
                f2.fork();

                //f(n) = f(n-1) + f(n-2)
                return f1.join() + f2.join();

            }
        }
    }

}
