package com.leospiritlee.test.test;

import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.util.Arrays;

/**
 * @Project: CodeSegment
 * @ClassName Tmp
 * @description: TODO
 * @author: leospiritlee
 * @create: 2020-04-09 10:21
 **/
public class Tmp {


    public static void main(String[] args) {
        Integer[] count = new Integer[]{0};
        BigDecimal[] sum = new BigDecimal[]{new BigDecimal(0)};

        Tmp tmp = new Tmp();

        System.out.println("count: " + Arrays.asList(count));
        System.out.println("sum: " + Arrays.asList(sum));

        for(int i = 0 ; i < 10; i++){
            tmp.count(count, sum);
        }

        System.out.println("count: " + Arrays.asList(count));
        System.out.println("sum: " + Arrays.asList(sum));

        int sumTotal = 0;
        int countTotal = 0;
        for(int i = 1, n = 100; i<= n; i++){
            sumTotal += i;
            countTotal++;
        }
        System.out.println(sumTotal);
        System.out.println(countTotal);
    }

    private void count(Integer[] count, BigDecimal[] sum){
        count[0] = count[0] + 1;
        sum[0] = sum[0].add(new BigDecimal(1));
    }



}
