package com.test.dateTest;

import cn.hutool.core.date.DateUtil;
import lombok.Data;
import lombok.ToString;

import java.util.Date;

/**
 * @author lwh
 * @description:
 * @date 2022/9/30 14:55
 */

@Data
@ToString
public class BabyEntity {

     private Long id;

    private String name;
    //  类型改成String
    private String birthday;

    private int sex;
    // 并修改getter方法
    public Date getBirthday() {
        return DateUtil.parseDate(birthday).toJdkDate();
    }
}
