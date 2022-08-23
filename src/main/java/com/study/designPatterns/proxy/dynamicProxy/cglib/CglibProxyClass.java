package com.study.designPatterns.proxy.dynamicProxy.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author lwh
 *
 * Cglib 代理
 * @date 2022/8/10 16:16
 */
public class CglibProxyClass implements MethodInterceptor {

    // 委托类 动态代理 可以委托任意委托类对象
    private Object obj;


    /**
     * 给委托类赋值，生成委托类的子类作为代理类
     * @param obj
     * @return
     */
    public Object bind(Object obj){
        this.obj = obj;

        // 实例化增强类，依赖它生成委托类的子类作为代理类
        Enhancer enhancer = new Enhancer();
        // 设置委托类为要生成代理的父类
        enhancer.setSuperclass(obj.getClass());
        // 设置回调方法，拿到委托类所有方法，做回调处理
        enhancer.setCallback(this);
        // 设置委托的子类，并返回
        return enhancer.create();
    }

    /**
     *
     * @param proxy 代理类
     * @param method 委托类的方法
     * @param objects 委托类执行的参数
     * @param methodProxy 代理类要执行的方法
     * @return
     * @throws Throwable
     */
    @Override
    public Object intercept(Object proxy, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        // 使用反射调用代理类的方法
        System.out.println("-----------------代理类，事前做什么工作-----------");
        Object returnObj = methodProxy.invoke(this.obj, objects);
        System.out.println("-----------------代理类，事后做什么工作-----------");
        return returnObj;
    }
}
