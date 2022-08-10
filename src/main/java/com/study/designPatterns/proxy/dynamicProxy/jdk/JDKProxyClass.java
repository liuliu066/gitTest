package com.study.designPatterns.proxy.dynamicProxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author lwh
 * 动态代理（jdk代理，可以动态代理任意有接口得类）
 * 代理类
 * @date 2022/8/10 14:40
 */
public class JDKProxyClass implements InvocationHandler {

    // 定义委托类（代理可以代理任意委托类，所以写类型object）
    private Object obj;

    /**
     * 绑定委托类，并返回代理类得实例
     * @param obj
     * @return
     */
    public Object bind(Object obj){
        this.obj = obj;
        /**
         * 使用jdk提供得proxy实例化代理类得实例
         *   参数1 构造器(obj.getClass().getClassLoader())
         *   参数2 委托类实现的所有接口 obj.getClass().getInterfaces() 委托获取所有接口的方法
         *   参数3 必须是InvocationHandler 接口的子类，该类可以处理所有委托的接口中方法 让当前类实现了InvocationHandler接口，使用this
         */
        Class<?>[] interfaces = obj.getClass().getInterfaces();
        System.out.println("委托类obj的接口有：");
        for (Class<?> anInterface : interfaces){
            System.out.println(anInterface.getName());
        }
        return Proxy.newProxyInstance(obj.getClass().getClassLoader(), interfaces,this);

    }


    /**
     * 处理委托类中接口的方法 （一个一个处理）
     * @param proxy 代理类对象
     * @param method 委托类所有接口中的每一个方法
     * @param args 委托类所有接口中的每一个方法的参数
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println("----------代理类: 事前进行操作");
        // 使用反射，执行方法
        Object returnObj = method.invoke(this.obj, args);
        System.out.println("----------代理类: 事后进行操作");
        return returnObj;
//        Object returnObj = null;
//        String name = method.getName();
//        if ("queryMoney".equals(name)){
//            System.out.println("------------代理类：事先。。。。。。。");
//            System.out.println("--------------代理类，事后。。。。。。");
//        }else {
//            System.out.println("取钱之前。。。。");
//            returnObj = method.invoke(this.obj, args);
//            System.out.println("取钱之后。。。。");
//        }
//        return returnObj;

    }
}
