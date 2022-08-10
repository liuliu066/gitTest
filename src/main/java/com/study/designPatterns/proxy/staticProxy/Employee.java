package com.study.designPatterns.proxy.staticProxy;

/**
 * @author lwh
 * ������
 * @date 2022/8/10 11:14
 */
public class Employee implements Account{

    private Client client;

    public Employee(Client client){
        this.client = client;
    }


    @Override
    public void queryMoney() {

        System.out.println("����׼����ATM����������");
        client.queryMoney();
        System.out.println("�º�ά��ATM����������");

    }

    @Override
    public void modifyMoney(double money) {
        System.out.println("ȡǮ֮ǰ��������");
        client.modifyMoney(money);
        System.out.println("ȡǮ֮�󡣡�����");
    }

}
