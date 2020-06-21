package com.leospiritlee.thread;

import java.util.stream.Stream;

/**
 * @Project: CodeSegment
 * @ClassName StreamDemo
 * @description: StreamDemo
 * @author: leospiritlee
 * @create: 2020-06-21 21:45
 **/
public class StreamDemo {

    public static void main(String[] args) {

        Stream.of(1,2,3,4,5,6,7,8,9)
                .reduce((a,b)->{
                    System.out.println(String.format("%s: %d + %d = %d",
                            Thread.currentThread().getName(), a, b, a + b));
                    return a + b;
                }).ifPresent(System.out::println);
    }
}
