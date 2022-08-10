package com.study.designPatterns.proxy.staticProxy;

/**
 * @author lwh
 * @date 2022/8/10 11:14
 */
public class Test {

    public static void main(String[] args) {
        // 实例化委托类
        Client client = new Client("小马");
        // 实例化代理类
        Employee employee = new Employee(client);

        //代理类执行方法
        employee.queryMoney();
        employee.modifyMoney(122);
    }


}
