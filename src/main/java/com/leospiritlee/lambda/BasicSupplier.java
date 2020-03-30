package com.leospiritlee.lambda;

import com.leospiritlee.stack.LinkedStack;

import java.util.function.Supplier;
import java.util.stream.Stream;

/**
 * @Project: CodeSegment
 * @ClassName BasicSupplier
 * @description: 通过Supplier构造对象
 * @author: leospiritlee
 * @create: 2020-03-30 21:25
 **/
public class BasicSupplier<T> implements Supplier<T> {

    private Class<T> type;

    public BasicSupplier(Class<T> type) {
        this.type = type;
    }

    @Override
    public T get() {
        try {
            return type.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    public static <T> Supplier<T> create(Class<T> type){
        return new BasicSupplier<>(type);
    }


    public static void main(String[] args) {
        Stream.generate(create(LinkedStack.class))
                .limit(5).
                forEach(obj->{
                    obj.push("111");
                });
    }
}
