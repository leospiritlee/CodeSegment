package com.leospiritlee.chain;

import java.util.Random;

/**
 * @Project: CodeSegment
 * @ClassName Enums
 * @description: 枚举随机获取
 * @author: leospiritlee
 * @create: 2020-04-07 21:03
 **/
public class Enums {

    /**固定随机因子*/
    private static Random rand = new Random(47);

    public static <T extends Enum<T>> T random(Class<T> ec){
        return random(ec.getEnumConstants());
    }

    public static <T> T random(T[] values){
        return values[rand.nextInt(values.length)];
    }

}
