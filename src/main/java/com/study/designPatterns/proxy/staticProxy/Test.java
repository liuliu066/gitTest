package com.study.designPatterns.proxy.staticProxy;

/**
 * @author lwh
 * @date 2022/8/10 11:14
 */
public class Test {

    public static void main(String[] args) {
        // ʵ����ί����
        Client client = new Client("С��");
        // ʵ����������
        Employee employee = new Employee(client);

        //������ִ�з���
        employee.queryMoney();
        employee.modifyMoney(122);
    }


}
