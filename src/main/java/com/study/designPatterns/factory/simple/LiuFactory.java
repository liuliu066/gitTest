package com.study.designPatterns.factory.simple;

/**
 * @author lwh
 * @date 2022/7/29 16:48
 */
public class LiuFactory {


    /**
     * ����ģʽ
     * ���������ķ���
     * @param type
     * @return
     */
    public SoftwareTechnology createProduct(int type){
        if (type == 1){
            return new JavaDevelopTechnology();
        }else if (type == 2){
            return new PythonTechnology();
        }else if (type == 3){
            return new BigDateTechnology();
        }else {
            return null;
        }
    }
}
