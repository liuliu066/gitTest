package com.study.designPatterns.proxy.dynamicProxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author lwh
 * ��̬����jdk�������Զ�̬���������нӿڵ��ࣩ
 * ������
 * @date 2022/8/10 14:40
 */
public class JDKProxyClass implements InvocationHandler {

    // ����ί���ࣨ������Դ�������ί���࣬����д����object��
    private Object obj;

    /**
     * ��ί���࣬�����ش������ʵ��
     * @param obj
     * @return
     */
    public Object bind(Object obj){
        this.obj = obj;
        /**
         * ʹ��jdk�ṩ��proxyʵ�����������ʵ��
         *   ����1 ������(obj.getClass().getClassLoader())
         *   ����2 ί����ʵ�ֵ����нӿ� obj.getClass().getInterfaces() ί�л�ȡ���нӿڵķ���
         *   ����3 ������InvocationHandler �ӿڵ����࣬������Դ�������ί�еĽӿ��з��� �õ�ǰ��ʵ����InvocationHandler�ӿڣ�ʹ��this
         */
        Class<?>[] interfaces = obj.getClass().getInterfaces();
        System.out.println("ί����obj�Ľӿ��У�");
        for (Class<?> anInterface : interfaces){
            System.out.println(anInterface.getName());
        }
        return Proxy.newProxyInstance(obj.getClass().getClassLoader(), interfaces,this);

    }


    /**
     * ����ί�����нӿڵķ��� ��һ��һ������
     * @param proxy ���������
     * @param method ί�������нӿ��е�ÿһ������
     * @param args ί�������нӿ��е�ÿһ�������Ĳ���
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println("----------������: ��ǰ���в���");
        // ʹ�÷��䣬ִ�з���
        Object returnObj = method.invoke(this.obj, args);
        System.out.println("----------������: �º���в���");
        return returnObj;
//        Object returnObj = null;
//        String name = method.getName();
//        if ("queryMoney".equals(name)){
//            System.out.println("------------�����ࣺ���ȡ�������������");
//            System.out.println("--------------�����࣬�º󡣡���������");
//        }else {
//            System.out.println("ȡǮ֮ǰ��������");
//            returnObj = method.invoke(this.obj, args);
//            System.out.println("ȡǮ֮�󡣡�����");
//        }
//        return returnObj;

    }
}
