package com.leospiritlee.util;

import com.leospiritlee.strategy.annotation.HandlerType;
import com.leospiritlee.strategy.enums.HandlerTypeEnum;

import java.lang.annotation.Annotation;
import java.lang.annotation.Inherited;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Project: CodeSegment
 * @ClassName FilterAnnotationUtil
 * @description: 注解过滤工具类  从指定包中读取类， 过滤指定注解
 * @author: leospiritlee
 * @create: 2020-03-20 22:36
 **/
public class FilterAnnotationUtil {

    public static void main(String[] args) {
        String packName = "com.leospiritlee.strategy.handler";
        Map<HandlerTypeEnum, Class>  classesMap = getClazzByAnnotation(packName);
        classesMap.forEach((k, v)->{
            System.out.println("key:" + k);
            System.out.println("value:" + v.getName());
        });
    }

    /**
     * 获取指定包下 指定注解的class对象  HandlerType
     * @param packageName
     * @return
     */
    public static Map<HandlerTypeEnum, Class> getClazzByAnnotation(String packageName){

        List<String> classNameList = ClassLoadUtil.getClazzName(packageName, true);
        if(null == classNameList || classNameList.size() == 0){
            return null;
        }

        Map<HandlerTypeEnum, Class>  classesMap = new HashMap<>();
        classNameList.stream().forEach(className ->{
            try {
                Class<?> clazz = Class.forName(className);
                if(isValidAnnotationClass(clazz, HandlerType.class)){
                    classesMap.put(clazz.getAnnotation(HandlerType.class).value(), clazz);
                }

            }catch (Exception e){
                System.err.println("Class.forName("+className+") exception." + e);
            }
        });

        return classesMap;
    }

    /**
     * 是否是标记注解的class 对象
     * @param clazz  待校验class
     * @param annotationClass  注解class
     * @return
     */
    private static <A extends Annotation> boolean isValidAnnotationClass(Class clazz, Class<A> annotationClass){

        if(null == clazz){
            return false;
        }

        if(clazz.getAnnotation(annotationClass) != null){
            return true;
        }

        return false;
    }



}
