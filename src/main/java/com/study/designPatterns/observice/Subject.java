package com.study.designPatterns.observice;

/**
 * @author lwh
 * 主题(被观察者) 接口
 * @date 2022/8/11 10:34
 */
public interface Subject {


    /**
     * 注册（添加）观察者
     * @param observice
     */
    void  registerObject(Observice observice);

    /**
     * 删除观察者
     * @param observice
     */
    void  removeObject(Observice observice);

    /**
     * 提醒（唤醒）所有观察者 主题状态变化，通知所有观察者
     * @param message
     */
    void  notifyAllObject(String message);

}
