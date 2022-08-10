package com.study.designPatterns.proxy.staticProxy;

/**
 * @author lwh
 * 委托类
 * @date 2022/8/10 11:13
 */
public class Client implements Account{


    private String clientName;

    public Client(String clientName) {
        this.clientName = clientName;
    }


    @Override
    public void queryMoney() {
        System.out.println("客户"+clientName+"进行了余额查询操作。。。。。");
    }

    @Override
    public void modifyMoney(double money) {
        System.out.println("客户"+clientName+"进行了存取"+money+"操作。。。。。");
    }
}
