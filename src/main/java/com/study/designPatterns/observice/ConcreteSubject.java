package com.study.designPatterns.observice;

import cn.hutool.core.collection.CollUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lwh
 * ���⣨���۲��ߣ�����ʵ����
 * @date 2022/8/11 10:57
 */
public class ConcreteSubject implements Subject{


    //��Ҫ�и��۲��߼���
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
