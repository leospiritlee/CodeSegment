package com.leospiritlee.proxy;

import org.omg.CORBA.portable.InvokeHandler;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

/**
 * @Project: CodeSegment
 * @ClassName SimpleDynamicProxyDemo
 * @description: 简单动态代理demo
 * @author: leospiritlee
 * @create: 2020-03-26 22:33
 **/
public class SimpleDynamicProxyDemo {

    private static void consumer(Interface inFace){
        inFace.doSomething();
        inFace.doSomethingElse("test");
    }

    public static void main(String[] args) {
        RealObject realObject = new RealObject();
        consumer(realObject);

        Interface proxy = (Interface) Proxy.newProxyInstance(
          Interface.class.getClassLoader(),
                new Class[]{Interface.class},
                new DynamicProxyHandler(realObject)
        );

        consumer(proxy);
    }

}


/**
 *  动态代理handler
 */
class DynamicProxyHandler implements InvocationHandler{

    private Object proxied;

    public DynamicProxyHandler(Object proxied) {
        this.proxied = proxied;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println("--- proxy: " + proxy.getClass() + ", method: " + method + ", args: " + args );

        if(args != null){
            Arrays.asList(args).stream().forEach(o->{
                System.out.println("arg :" + o);
            });
        }

        return method.invoke(proxied, args);
    }
}