package com.leospiritlee.strategy.factory;

import com.leospiritlee.strategy.enums.HandlerTypeEnum;
import com.leospiritlee.strategy.handler.AbstractHandler;
import com.leospiritlee.util.FilterAnnotationUtil;

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

    private static Map<HandlerTypeEnum, Class> handlerFactoryMap = new HashMap<>();

    /**
     *  init
     */
    static {
        Map<HandlerTypeEnum, Class> newHandlerFactoryMap = FilterAnnotationUtil.getClazzByAnnotation(TARGET_PACKAGE);
        if(null != newHandlerFactoryMap && newHandlerFactoryMap.size() > 0 ){
            handlerFactoryMap = newHandlerFactoryMap;
        }
    }

    /**
     * 获取 handler class
     * @param handlerType
     * @return
     */
    public static AbstractHandler getHandlerClass(HandlerTypeEnum handlerType) throws IllegalAccessException, InstantiationException {
        Class<?> clazz = handlerFactoryMap.get(handlerType);
        if(null == clazz){
            return null;
        }
        return (AbstractHandler) clazz.newInstance();
    }






}
