package com.study.designPatterns.observice;

/**
 * @author lwh
 * ����Ĺ۲���
 * @date 2022/8/11 10:44
 */
public class ConcreteObservice implements Observice{

    // ����ob����
    private String observiceName;

    // ��ӹ���


    public ConcreteObservice(String observiceName) {
        this.observiceName = observiceName;
    }

    @Override
    public void update(String message) {
        System.out.println("�۲��ߣ�"+observiceName+"��ȡ��������Ϣ��"+message+";������Ϣ����������������������������");
    }
}
