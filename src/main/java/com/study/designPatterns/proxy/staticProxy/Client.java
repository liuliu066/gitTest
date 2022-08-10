package com.study.designPatterns.proxy.staticProxy;

/**
 * @author lwh
 * ί����
 * @date 2022/8/10 11:13
 */
public class Client implements Account{


    private String clientName;

    public Client(String clientName) {
        this.clientName = clientName;
    }


    @Override
    public void queryMoney() {
        System.out.println("�ͻ�"+clientName+"����������ѯ��������������");
    }

    @Override
    public void modifyMoney(double money) {
        System.out.println("�ͻ�"+clientName+"�����˴�ȡ"+money+"��������������");
    }
}
