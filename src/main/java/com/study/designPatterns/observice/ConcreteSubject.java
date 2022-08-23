package com.study.designPatterns.observice;

import cn.hutool.core.collection.CollUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lwh
 * 主题（被观察者）具体实现类
 * @date 2022/8/11 10:57
 */
public class ConcreteSubject implements Subject{


    //需要有个观察者集合
    private List<Observice>  observiceList = new ArrayList<>();

    @Override
    public void registerObject(Observice observice) {
        observiceList.add(observice);
    }

    @Override
    public void removeObject(Observice observice) {
        observiceList.remove(observice);
    }

    @Override
    public void notifyAllObject(String message) {
        if (CollUtil.isNotEmpty(observiceList)){
            for (Observice observice : observiceList) {
                observice.update(message);
            }
        }

    }
}
