package com.study.designPatterns.proxy.staticProxy;

/**
 * @author lwh
 * @date 2022/8/10 11:14
 */
public interface Account {

    /**
     * ��ѯ���
     */
    void queryMoney();


    /**
     * ��/ȡǮ
     * @param money
     */
    void modifyMoney(double money);




}
