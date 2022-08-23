package com.study.designPatterns.adaptor;

/**
 * @author lwh
 * @description: 适配器（对象适配器） 把源接口转化为目标能够使用的接口
 * @date 2022/8/11 14:29
 */
public class AdaptorObject  implements TargetElectronicProductPower{


    // 使用实例化属性的方式，拿到源角色类，方便调用方法
    private AdapteeHomePower adapteeHomePower;

    /**
     * 使用构造赋值
     * @param adapteeHomePower
     */
    public AdaptorObject(AdapteeHomePower adapteeHomePower) {
        this.adapteeHomePower = adapteeHomePower;
    }

    @Override
    public void chargePowerDCNV(int powerType) {
        int outputPower220 = adapteeHomePower.outputPower();
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
