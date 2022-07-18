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
        HelloProxy helloProxy = new HelloProxy(hello);//�����������࣬ʵ��InvocationHandler�ӿڵķ������ڷ���֮ǰ��֮����в���
        IHello o = (IHello)Proxy.newProxyInstance(Hello.class.getClassLoader(), new Class[]{HelloProxy.class}, helloProxy);
        o.sayHello();
    }
}
