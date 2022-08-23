package com.study.designPatterns.proxy.dynamicProxy.cglib;

/**
 * @author lwh
 * @date 2022/8/10 17:06
 */
public class Test {

    public static void main(String[] args) {
//        ʵ����ί����
        EmpServiceImpl empService = new EmpServiceImpl();
        // ʵ��������Ļص���
        CglibProxyClass cglibProxyClass = new CglibProxyClass();
        // ������ ί���������
        EmpServiceImpl empService1 = (EmpServiceImpl)cglibProxyClass.bind(empService);
        empService1.add(null);
        empService1.delete(null);
        empService1.update(null);


        System.out.println("-----------------------------------------------");

        //        ʵ����ί����
        GoodsDaoImpl  goodsDao = new GoodsDaoImpl();
        // ʵ��������Ļص���
        CglibProxyClass cglibProxyClass1 = new CglibProxyClass();
        // ������ ί���������
        GoodsDaoImpl empService2 = (GoodsDaoImpl)cglibProxyClass1.bind(goodsDao);
        empService2.add(null);
        empService2.delete(null);
        empService2.update(null);

    }
}
