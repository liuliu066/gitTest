package com.study;

import com.baomidou.mybatisplus.core.enums.IEnum;

/**
 * @author lwh
 * @date 2022/6/7 17:06
 */
public enum EnumBo implements IEnum<String>{
    StaffQuit("staffQuit","离职流程"),
    StaffTransfer("staffTransfer","内部调动"),
    StaffChange("staffChange","员工岗位变动"),
    StaffLoan("staffLoan","员工借调");

    /**
     * 枚举code
     */
    private String code;

    /**
     * 枚举message
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
