package com.study.designPatterns.proxy.dynamicProxy.cglib;

import java.util.Map;

/**
 * @author lwh
 * @date 2022/8/10 17:04
 */
public class GoodsDaoImpl {


    /**
     * ��Ʒ���
     * @param map
     * @return
     */
    public int add(Map map){
        System.out.println("ģ����ӡ�����");
        return -1;
    }

    /**
     * ��Ʒɾ��
     * @param map
     * @return
     *
     * ���дfinal�Ļ� �޷������˷�������Ϊ����д�ģ�final�ǲ��е�
     */
    public final int delete(Map map){
        System.out.println("ģ��ɾ��������");
        return -1;
    }

    /**
     * ��Ʒ�޸�
     * @param map
     * @return
     */
    public int update(Map map){
        System.out.println("ģ���޸ġ�����");
        return -1;
    }


}
