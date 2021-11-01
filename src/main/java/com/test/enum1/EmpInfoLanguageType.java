package com.test.enum1;

/**
 * @author lwh
 * @date 2021/10/13 14:04
 */
public enum EmpInfoLanguageType {
    /**
     * 枚举id与枚举名称
     */
    LANGUAGE_TYPE_02(2, "英语"),
    LANGUAGE_TYPE_03(3, "日语"),
    LANGUAGE_TYPE_04(4, "俄语"),
    LANGUAGE_TYPE_05(5, "葡萄牙语"),
    LANGUAGE_TYPE_06(6, "西班牙语"),
    LANGUAGE_TYPE_07(7, "朝鲜语"),
    LANGUAGE_TYPE_08(8, "法语"),
    LANGUAGE_TYPE_09(9, "阿拉伯语"),
    LANGUAGE_TYPE_10(10, "德语");




    /**
     *  枚举值
     */

    private  Integer code;

    /**
     *枚举描述
     */

    private  String message;


    EmpInfoLanguageType(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;

    }

    public String getMessage() {
        return message;

    }
    public void setCode(){
        this.code=code;
    }

    public void setMessage(){
        this.message=message;
    }
    /**
     * 通过code获取msg
     */

    public static String getMsgByLanguageTypeCode(Integer code) {
        for (EmpInfoLanguageType empInfoLanguageType: EmpInfoLanguageType.values()) {
            if (empInfoLanguageType.getCode() == code) {
                return empInfoLanguageType.message;
            }
        }
        return null;
    }


}
