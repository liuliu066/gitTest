package com.study.designPatterns.adaptor;

/**
 * @author lwh
 * @description: 适配器（类适配器） 把源接口转化为目标能够使用的接口
 * @date 2022/8/11 14:21
 */
public class AdaptorClass extends AdapteeHomePower implements TargetElectronicProductPower{


    @Override
    public void chargePowerDCNV(int powerType) {
        int outputPower220 = this.outputPower();
        int input5VdC = outputPower220 / 44;
        if (powerType == 1){
            System.out.println("苹果手机，输入电压为"+input5VdC+"电流1A");
        }else if (powerType == 2){
            System.out.println("安卓手机，输入电压为"+input5VdC+"电流2A");
        }else if (powerType == 3){
            System.out.println("平板，输入电压为"+input5VdC+"电流3A");
        }else {
            System.out.println("不适配，输入电压为"+input5VdC+"电流4A");
        }
    }
}
