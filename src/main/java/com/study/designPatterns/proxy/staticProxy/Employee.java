package com.study.designPatterns.proxy.staticProxy;

/**
 * @author lwh
 * 代理类
 * @date 2022/8/10 11:14
 */
public class Employee implements Account{

    private Client client;

    public Employee(Client client){
        this.client = client;
    }


    @Override
    public void queryMoney() {

        System.out.println("事先准备好ATM机。。。。");
        client.queryMoney();
        System.out.println("事后维修ATM机。。。。");

    }

    @Override
    public void modifyMoney(double money) {
        System.out.println("取钱之前。。。。");
        client.modifyMoney(money);
        System.out.println("取钱之后。。。。");
    }

}
