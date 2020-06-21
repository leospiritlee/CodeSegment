package com.leospiritlee.thread;

/**
 * @Project: CodeSegment
 * @ClassName PlainRecursionDemo
 * @description: plainRecursion demo
 * @author: leospiritlee
 * @create: 2020-06-21 21:42
 **/
public class PlainRecursionDemo {

    private int plainRecursion(int n){
        if(n == 1 || n == 2){
            return 1;
        }else {
            return plainRecursion(n - 1) + plainRecursion(n -2);
        }
    }

    public static void main(String[] args) {
        PlainRecursionDemo plainRecursionDemo = new PlainRecursionDemo();
        long start = System.currentTimeMillis();
        int result = plainRecursionDemo.plainRecursion(40);
        long end = System.currentTimeMillis();
        System.out.println("计算结果:" + result);
        System.out.println(String.format("耗时：%d millis",  end -start));
    }
}
