package com.study.designPatterns.proxy.dynamicProxy.jdk;

import java.util.Map;

/**
 * @author lwh
 * @date 2022/8/10 15:44
 */
public class DeptServiceImpl implements DeptService{

    /**
     * ģ��ҵ���߼�����
     * @param var1
     * @return
     */

    @Override
    public boolean save(Map var1) {
        System.out.println("ģ�ⲿ����ӡ�����");
        return false;
    }

    @Override
    public boolean remove(Map var1) {
        System.out.println("ģ�ⲿ��ɾ��������");
        return false;
    }

    @Override
    public boolean update(Map var1) {
        System.out.println("ģ�ⲿ�Ÿ�ϸ������");
        return false;
    }
}
