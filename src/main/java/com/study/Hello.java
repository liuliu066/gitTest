package com.study;

import com.IHello;

import java.lang.reflect.Proxy;

/**
 * @author lwh
 * @date 2022/7/12 19:33
 */
public class Hello implements IHello {
    public void sayHello() {
        System.out.println("hello zhangsan");
    }


    public static void main(String[] args) {
        Hello hello = new Hello();
        HelloProxy helloProxy = new HelloProxy(hello);//创建个代理类，实现InvocationHandler接口的方法，在方法之前，之后进行操作
        IHello o = (IHello)Proxy.newProxyInstance(Hello.class.getClassLoader(), new Class[]{HelloProxy.class}, helloProxy);
        o.sayHello();
    }
}
