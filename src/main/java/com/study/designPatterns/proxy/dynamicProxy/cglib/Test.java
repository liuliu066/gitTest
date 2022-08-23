package com.study.designPatterns.proxy.dynamicProxy.cglib;

/**
 * @author lwh
 * @date 2022/8/10 17:06
 */
public class Test {

    public static void main(String[] args) {
//        实例化委托类
        EmpServiceImpl empService = new EmpServiceImpl();
        // 实例化代理的回调类
        CglibProxyClass cglibProxyClass = new CglibProxyClass();
        // 代理类 委托类的子类
        EmpServiceImpl empService1 = (EmpServiceImpl)cglibProxyClass.bind(empService);
        empService1.add(null);
        empService1.delete(null);
        empService1.update(null);


        System.out.println("-----------------------------------------------");

        //        实例化委托类
        GoodsDaoImpl  goodsDao = new GoodsDaoImpl();
        // 实例化代理的回调类
        CglibProxyClass cglibProxyClass1 = new CglibProxyClass();
        // 代理类 委托类的子类
        GoodsDaoImpl empService2 = (GoodsDaoImpl)cglibProxyClass1.bind(goodsDao);
        empService2.add(null);
        empService2.delete(null);
        empService2.update(null);

    }
}
