package com.study.designPatterns.adaptor;

/**
 * @author lwh
 * @description: 适配器测试，把源角色 转化为目标角色信息
 * @date 2022/8/11 14:28
 */
public class Test {

    public static void main(String[] args) {
        AdaptorClass adaptorClass = new AdaptorClass();
        adaptorClass.chargePowerDCNV(4);
    }
}
