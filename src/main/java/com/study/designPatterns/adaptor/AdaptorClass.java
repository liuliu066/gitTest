package com.study.designPatterns.adaptor;

/**
 * @author lwh
 * @description: ������������������ ��Դ�ӿ�ת��ΪĿ���ܹ�ʹ�õĽӿ�
 * @date 2022/8/11 14:21
 */
public class AdaptorClass extends AdapteeHomePower implements TargetElectronicProductPower{


    @Override
    public void chargePowerDCNV(int powerType) {
        int outputPower220 = this.outputPower();
        int input5VdC = outputPower220 / 44;
        if (powerType == 1){
            System.out.println("ƻ���ֻ��������ѹΪ"+input5VdC+"����1A");
        }else if (powerType == 2){
            System.out.println("��׿�ֻ��������ѹΪ"+input5VdC+"����2A");
        }else if (powerType == 3){
            System.out.println("ƽ�壬�����ѹΪ"+input5VdC+"����3A");
        }else {
            System.out.println("�����䣬�����ѹΪ"+input5VdC+"����4A");
        }
    }
}
