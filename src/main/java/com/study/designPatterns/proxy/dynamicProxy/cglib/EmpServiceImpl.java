package com.study.designPatterns.proxy.dynamicProxy.cglib;

import java.util.Map;

/**
 * @author lwh
 * @date 2022/8/10 17:02
 */
public class EmpServiceImpl {


    /**
     * Ա�����
     * @param map
     * @return
     */
    public int add(Map map){
        System.out.println("ģ����ӡ�����");
        return -1;
    }

    /**
     * Ա��ɾ��
     * @param map
     * @return
     */
    public int delete(Map map){
        System.out.println("ģ��ɾ��������");
        return -1;
    }

    /**
     * Ա���޸�
     * @param map
     * @return
     */
    public int update(Map map){
        System.out.println("ģ���޸ġ�����");
        return -1;
    }


}
