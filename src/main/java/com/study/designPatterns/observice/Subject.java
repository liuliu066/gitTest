package com.study.designPatterns.observice;

/**
 * @author lwh
 * ����(���۲���) �ӿ�
 * @date 2022/8/11 10:34
 */
public interface Subject {


    /**
     * ע�ᣨ��ӣ��۲���
     * @param observice
     */
    void  registerObject(Observice observice);

    /**
     * ɾ���۲���
     * @param observice
     */
    void  removeObject(Observice observice);

    /**
     * ���ѣ����ѣ����й۲��� ����״̬�仯��֪ͨ���й۲���
     * @param message
     */
    void  notifyAllObject(String message);

}
