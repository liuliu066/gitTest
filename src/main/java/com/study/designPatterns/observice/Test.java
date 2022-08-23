package com.study.designPatterns.observice;

/**
 * @author lwh
 * @date 2022/8/11 11:12
 */
public class Test {
    public static void main(String[] args) {
//        ʵ����ob
        Observice observice1 = new ConcreteObservice("��1");
        Observice observice2 = new ConcreteObservice("��2");
        Observice observice3 = new ConcreteObservice("��3");
        Observice observice4 = new ConcreteObservice("��4");
        Observice observice5 = new ConcreteObservice("��5");

        //ʵ�������۲���
        Subject subject = new ConcreteSubject();
        subject.registerObject(observice1);
        subject.registerObject(observice2);
        subject.registerObject(observice3);
        subject.registerObject(observice4);
        subject.registerObject(observice5);

        // ����״̬�仯��������Ϣ����������ob
        subject.notifyAllObject("����Ϣ������������");
        // �Ƴ�һ��
        subject.removeObject(observice1);
        subject.notifyAllObject("�������������ַ���Ϣ������������");


    }
}
