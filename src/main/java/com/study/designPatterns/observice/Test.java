package com.study.designPatterns.observice;

/**
 * @author lwh
 * @date 2022/8/11 11:12
 */
public class Test {
    public static void main(String[] args) {
//        实例化ob
        Observice observice1 = new ConcreteObservice("王1");
        Observice observice2 = new ConcreteObservice("王2");
        Observice observice3 = new ConcreteObservice("王3");
        Observice observice4 = new ConcreteObservice("王4");
        Observice observice5 = new ConcreteObservice("王5");

        //实例化被观察者
        Subject subject = new ConcreteSubject();
        subject.registerObject(observice1);
        subject.registerObject(observice2);
        subject.registerObject(observice3);
        subject.registerObject(observice4);
        subject.registerObject(observice5);

        // 主题状态变化、发送消息、提醒所有ob
        subject.notifyAllObject("发消息拉。。。。。");
        // 移除一个
        subject.removeObject(observice1);
        subject.notifyAllObject("我我我我又又又发消息拉。。。。。");


    }
}
