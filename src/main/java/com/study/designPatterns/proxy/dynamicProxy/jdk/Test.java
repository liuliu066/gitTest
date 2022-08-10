package com.study.designPatterns.proxy.dynamicProxy.jdk;

import com.study.designPatterns.proxy.staticProxy.Account;
import com.study.designPatterns.proxy.staticProxy.Client;

/**
 * @author lwh
 * @date 2022/8/10 15:21
 */
public class Test {

    public static void main(String[] args) {

        System.out.println("---------------------------使用JDK代理account---------------------------------------");
        Client client = new Client("小豪");
        JDKProxyClass jdkProxyClass = new JDKProxyClass();
        // 绑定委托类，并返回代理对象   对象 父类引用指向子类对象
        Account account = (Account)jdkProxyClass.bind(client);
        // 执行代理类的方法
        account.queryMoney();
        account.modifyMoney(122);

        System.out.println("---------------------------使用JDK代理deptService---------------------------------------");
        // 实例化委托类
        DeptService deptService = new DeptServiceImpl();
        // 实例化代理类
        JDKProxyClass jdkProxyClass1 = new JDKProxyClass();
        // 绑定委托类，并返回代理对象   对象 父类引用指向子类对象
        DeptService deptService1 = (DeptService)jdkProxyClass1.bind(deptService);

        // 执行代理类方法
        deptService1.remove(null);
        deptService1.save(null);
        deptService1.update(null);








    }



}
