package com.study.designPatterns.observice;

/**
 * @author lwh
 * 观察者接口
 * @date 2022/8/11 10:36
 */
public interface Observice {



    /**
     * 根据观察主题状态的变化，跳转自己的状态
     * @param message
     */
    void update(String message);




}
