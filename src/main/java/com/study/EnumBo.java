package com.study;

import com.baomidou.mybatisplus.core.enums.IEnum;

/**
 * @author lwh
 * @date 2022/6/7 17:06
 */
public enum EnumBo implements IEnum<String>{
    StaffQuit("staffQuit","��ְ����"),
    StaffTransfer("staffTransfer","�ڲ�����"),
    StaffChange("staffChange","Ա����λ�䶯"),
    StaffLoan("staffLoan","Ա�����");

    /**
     * ö��code
     */
    private String code;

    /**
     * ö��message
     */
    private String message;

    EnumBo(String code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public String getValue() {
        return code;
    }

    public String getMessage() {
        return message;
    }

}
