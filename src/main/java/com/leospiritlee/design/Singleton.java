package com.leospiritlee.design;

import java.io.Serializable;

/**
 * @Project: CodeSegment
 * @ClassName Singleton
 * @description: 单例模式反射、序列化漏洞及解决方案
 * @author: leospiritlee
 * @create: 2020-03-31 20:11
 **/
public class Singleton implements Serializable {

    private static final long serialVersionUID = -730825263883030248L;

    private static final Singleton singleton = new Singleton();

    private Singleton() {
        //防止反射
        if(null != singleton){
            throw new RuntimeException();
        }
    }

    /**
     * 防止被readObject重新初始化
     * @see java.io.ObjectInputStream
     * Object rep = desc.invokeReadResolve(obj);
     * @return
     */
    public Object readResolve(){
        return singleton;
    }


    public static Singleton getInstance() {
        return singleton;
    }
}
