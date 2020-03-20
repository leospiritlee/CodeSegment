package com.leospiritlee.strategy.factory;

import com.leospiritlee.strategy.enums.HandlerTypeEnum;

import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

/**
 * @Project: CodeSegment
 * @ClassName HandlerFactory
 * @description: 处理器工厂
 * @author: leospiritlee
 * @create: 2020-03-19 23:03
 **/
public class HandlerFactory {

    private final static String TARGET_PACKAGE = "com.leospiritlee.strategy.handler";

    private Map<HandlerTypeEnum, Class> handlerFactoryMap = new HashMap<>();


    public void init(){

    }




}
