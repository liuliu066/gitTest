package com.test.enum1;

/**
 * @author lwh
 * @date 2021/10/13 14:35
 */


public enum EmpInfoLanguageGrade {
    /**
     * 枚举id与枚举名称
     */
    LANGUAGE_GRADE_01(1, "英语应用能力考试A级"),
    LANGUAGE_GRADE_02(2, "英语应用能力考试B级"),
    LANGUAGE_GRADE_03(3, "剑桥商务英语初级"),
    LANGUAGE_GRADE_04(4, "剑桥商务英语中级"),
    LANGUAGE_GRADE_05(5, "剑桥商务英语高级"),
    LANGUAGE_GRADE_06(6, "大学英语三级"),
    LANGUAGE_GRADE_07(7, "大学英语四级"),
    LANGUAGE_GRADE_08(8, "大学英语六级"),
    LANGUAGE_GRADE_09(9, "英语专业四级"),
    LANGUAGE_GRADE_10(10, "英语专业八级"),
    LANGUAGE_GRADE_11(11, "雅思3.0"),
    LANGUAGE_GRADE_12(12, "雅思4.0"),
    LANGUAGE_GRADE_13(13, "雅思4.5"),
    LANGUAGE_GRADE_14(14, "雅思5.0"),
    LANGUAGE_GRADE_15(15, "雅思5.5"),
    LANGUAGE_GRADE_16(16, "雅思6.0"),
    LANGUAGE_GRADE_17(17, "雅思6.5"),
    LANGUAGE_GRADE_18(18, "雅思7.0"),
    LANGUAGE_GRADE_19(19, "雅思7.5"),
    LANGUAGE_GRADE_20(20, "雅思8.0"),
    LANGUAGE_GRADE_21(21, "全国英语等级考试1级B"),
    LANGUAGE_GRADE_22(22, "全国英语等级考试1级"),
    LANGUAGE_GRADE_23(23, "全国英语等级考试2级"),
    LANGUAGE_GRADE_24(24, "全国英语等级考试3级"),
    LANGUAGE_GRADE_25(25, "全国英语等级考试4级"),
    LANGUAGE_GRADE_26(26, "全国英语等级考试5级"),
    LANGUAGE_GRADE_27(27, "托福51-60"),
    LANGUAGE_GRADE_28(28, "托福61-70"),
    LANGUAGE_GRADE_29(29, "托福71-80"),
    LANGUAGE_GRADE_30(30, "托福81-90"),
    LANGUAGE_GRADE_31(31, "托福91-100"),
    LANGUAGE_GRADE_32(32, "托福101-110"),
    LANGUAGE_GRADE_33(33, "托福110-120"),
    LANGUAGE_GRADE_34(34, "托业A级"),
    LANGUAGE_GRADE_35(35, "托业B级"),
    LANGUAGE_GRADE_36(36, "托业C级"),
    LANGUAGE_GRADE_37(37, "托业D级"),
    LANGUAGE_GRADE_38(38, "托业E级"),
    LANGUAGE_GRADE_39(39, "职称英语A级"),
    LANGUAGE_GRADE_40(40, "职称英语B级"),
    LANGUAGE_GRADE_41(41, "职称英语C级"),
    LANGUAGE_GRADE_42(42, "大学日语二级"),
    LANGUAGE_GRADE_43(43, "大学日语四级"),
    LANGUAGE_GRADE_44(44, "日语能力测试N1级"),
    LANGUAGE_GRADE_45(45, "日语能力测试N2级"),
    LANGUAGE_GRADE_46(46, "日语能力测试N3级"),
    LANGUAGE_GRADE_47(47, "日语能力测试N4级"),
    LANGUAGE_GRADE_48(48, "日语能力测试N5级"),
    LANGUAGE_GRADE_49(49, "日语等级考试"),
    LANGUAGE_GRADE_50(50, "大学俄语四级"),
    LANGUAGE_GRADE_51(51, "大学俄语六级"),
    LANGUAGE_GRADE_52(52, "对外俄语等级3级"),
    LANGUAGE_GRADE_53(53, "俄语国家水平考试2级"),
    LANGUAGE_GRADE_54(54, "俄语专业四级"),
    LANGUAGE_GRADE_55(55, "俄语专业八级"),
    LANGUAGE_GRADE_56(56, "葡萄牙等级考试A1"),
    LANGUAGE_GRADE_57(57, "葡萄牙等级考试A2"),
    LANGUAGE_GRADE_58(58, "葡萄牙等级考试B1"),
    LANGUAGE_GRADE_59(59, "葡萄牙等级考试B2"),
    LANGUAGE_GRADE_60(60, "葡萄牙等级考试C1"),
    LANGUAGE_GRADE_61(61, "葡萄牙等级考试C2"),
    LANGUAGE_GRADE_62(62, "西班牙语DELE考试A1"),
    LANGUAGE_GRADE_63(63, "西班牙语DELE考试A2"),
    LANGUAGE_GRADE_64(64, "西班牙语DELE考试B1"),
    LANGUAGE_GRADE_65(65, "西班牙语DELE考试B2"),
    LANGUAGE_GRADE_66(66, "西班牙语DELE考试C1"),
    LANGUAGE_GRADE_67(67, "西班牙语DELE考试C2"),
    LANGUAGE_GRADE_68(68, "TOPIK能力考试3级"),
    LANGUAGE_GRADE_69(69, "TOPIK能力考试4级"),
    LANGUAGE_GRADE_70(70, "TOPIK能力考试5级"),
    LANGUAGE_GRADE_71(71, "法语专业四级"),
    LANGUAGE_GRADE_72(72, "法语专业八级"),
    LANGUAGE_GRADE_73(73, "阿拉伯语专业四级"),
    LANGUAGE_GRADE_74(74, "大学德语四级"),
    LANGUAGE_GRADE_75(75, "大学德语六级"),
    LANGUAGE_GRADE_76(76, "欧标A2.1"),
    LANGUAGE_GRADE_77(77, "欧标B2.1"),
    LANGUAGE_GRADE_78(78, "德语DSH1"),
    LANGUAGE_GRADE_79(79, "德语DSH2"),
    LANGUAGE_GRADE_80(80, "德语DSH3");

    /**
     *  枚举值
     */

    private  Integer code;

    /**
     *枚举描述
     */

    private  String message;

    EmpInfoLanguageGrade(Integer code, String message) {
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

    public static String getMsgByLanguageGradeCode(Integer code) {
        for (EmpInfoLanguageGrade empInfoLanguageGrade: EmpInfoLanguageGrade.values()) {
            if (empInfoLanguageGrade.getCode() == code) {
                return empInfoLanguageGrade.message;
            }
        }
        return null;
    }

}
