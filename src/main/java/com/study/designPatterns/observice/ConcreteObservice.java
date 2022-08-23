package com.study.designPatterns.observice;

/**
 * @author lwh
 * 具体的观察者
 * @date 2022/8/11 10:44
 */
public class ConcreteObservice implements Observice{

    // 定义ob名称
    private String observiceName;

    // 添加构造


    public ConcreteObservice(String observiceName) {
        this.observiceName = observiceName;
    }

    @Override
    public void update(String message) {
        System.out.println("观察者："+observiceName+"获取了主题消息："+message+";根据消息，做出。。。。。操作。。。。");
    }
}
