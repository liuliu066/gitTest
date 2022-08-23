package com.study.designPatterns.proxy.dynamicProxy.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author lwh
 *
 * Cglib ����
 * @date 2022/8/10 16:16
 */
public class CglibProxyClass implements MethodInterceptor {

    // ί���� ��̬���� ����ί������ί�������
    private Object obj;


    /**
     * ��ί���ำֵ������ί�����������Ϊ������
     * @param obj
     * @return
     */
    public Object bind(Object obj){
        this.obj = obj;

        // ʵ������ǿ�࣬����������ί�����������Ϊ������
        Enhancer enhancer = new Enhancer();
        // ����ί����ΪҪ���ɴ���ĸ���
        enhancer.setSuperclass(obj.getClass());
        // ���ûص��������õ�ί�������з��������ص�����
        enhancer.setCallback(this);
        // ����ί�е����࣬������
        return enhancer.create();
    }

    /**
     *
     * @param proxy ������
     * @param method ί����ķ���
     * @param objects ί����ִ�еĲ���
     * @param methodProxy ������Ҫִ�еķ���
     * @return
     * @throws Throwable
     */
    @Override
    public Object intercept(Object proxy, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        // ʹ�÷�����ô�����ķ���
        System.out.println("-----------------�����࣬��ǰ��ʲô����-----------");
        Object returnObj = methodProxy.invoke(this.obj, objects);
        System.out.println("-----------------�����࣬�º���ʲô����-----------");
        return returnObj;
    }
}
