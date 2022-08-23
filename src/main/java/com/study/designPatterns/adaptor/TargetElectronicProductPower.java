package com.study.designPatterns.adaptor;

/**
 * @author lwh
 * @description:
 * @date 2022/8/11 14:19
 */
public interface TargetElectronicProductPower {

    /**
     * 直流电充电电源方法
     * 1、苹果
     * 2、安卓
     * 3、平板
     * 4、不适配
     */
    void chargePowerDCNV(int powerType);

}
