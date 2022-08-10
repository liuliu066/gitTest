package com.study.designPatterns.proxy.dynamicProxy.jdk;

import com.study.designPatterns.proxy.staticProxy.Account;
import com.study.designPatterns.proxy.staticProxy.Client;

/**
 * @author lwh
 * @date 2022/8/10 15:21
 */
public class Test {

    public static void main(String[] args) {

        System.out.println("---------------------------ʹ��JDK����account---------------------------------------");
        Client client = new Client("С��");
        JDKProxyClass jdkProxyClass = new JDKProxyClass();
        // ��ί���࣬�����ش������   ���� ��������ָ���������
        Account account = (Account)jdkProxyClass.bind(client);
        // ִ�д�����ķ���
        account.queryMoney();
        account.modifyMoney(122);

        System.out.println("---------------------------ʹ��JDK����deptService---------------------------------------");
        // ʵ����ί����
        DeptService deptService = new DeptServiceImpl();
        // ʵ����������
        JDKProxyClass jdkProxyClass1 = new JDKProxyClass();
        // ��ί���࣬�����ش������   ���� ��������ָ���������
        DeptService deptService1 = (DeptService)jdkProxyClass1.bind(deptService);

        // ִ�д����෽��
        deptService1.remove(null);
        deptService1.save(null);
        deptService1.update(null);








    }



}
