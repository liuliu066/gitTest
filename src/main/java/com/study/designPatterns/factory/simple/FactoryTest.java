package com.study.designPatterns.factory.simple;

/**
 * @author lwh
 * @date 2022/7/29 16:51
 */
public class FactoryTest {


    public static void main(String[] args) {
        LiuFactory liuFactory = new LiuFactory();

        SoftwareTechnology product = liuFactory.createProduct(1);
        if (product != null){
            product.study();
        }
    }
}
