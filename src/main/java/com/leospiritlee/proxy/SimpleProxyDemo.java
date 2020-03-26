package com.leospiritlee.proxy;

/**
 * @Project: CodeSegment
 * @ClassName SimpleProxy
 * @description: 简单代理demo
 * @author: leospiritlee
 * @create: 2020-03-26 22:25
 **/
public class SimpleProxyDemo {


    private static void consumer(Interface inFace){
        inFace.doSomething();
        inFace.doSomethingElse("test");
    }

    public static void main(String[] args) {
        consumer(new RealObject());
        consumer(new SimpleProxy(new RealObject()));
    }

}


interface Interface{
    void doSomething();
    void doSomethingElse(String arg);
}

class RealObject implements Interface{

    @Override
    public void doSomething() {
        System.out.println("realObject doSomething");
    }

    @Override
    public void doSomethingElse(String arg) {
        System.out.println("realObject doSomethingElse arg: " + arg);
    }
}

class SimpleProxy implements Interface{

    private Interface obj;

    public SimpleProxy(Interface obj) {
        this.obj = obj;
    }

    @Override
    public void doSomething() {
        System.out.println("SimpleProxy doSomething");
        obj.doSomething();
    }

    @Override
    public void doSomethingElse(String arg) {
        System.out.println("SimpleProxy doSomethingElse arg: " + arg);
        obj.doSomethingElse(arg);
    }
}

