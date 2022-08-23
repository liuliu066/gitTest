package com.study.designPatterns.adaptor;

/**
 * 适配器模式
 * @author lwh
 * @description: 源角色（被适配者）
 * @date 2022/8/11 14:12
 */
public class AdapteeHomePower {

    /**
     * 提供一个方法为220v输出电源
     * @return
     */
    public int outputPower(){
        return 220;
    }



}
