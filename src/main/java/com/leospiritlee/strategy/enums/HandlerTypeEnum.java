package com.leospiritlee.strategy.enums;

/**
 *  handler 类型枚举
 */
public enum HandlerTypeEnum {

    HANDLER_A("HANDLER_A"),
    HANDLER_B("HANDLER_B"),
    HANDLER_C("HANDLER_C"),

    ;

    private String name;

    public String getName() {
        return name;
    }

    HandlerTypeEnum(String name) {
        this.name = name;
    }
}
