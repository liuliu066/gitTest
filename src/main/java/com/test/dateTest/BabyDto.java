package com.test.dateTest;

import lombok.Data;

import java.util.Date;

/**
 * @author lwh
 * @description:
 * @date 2022/9/30 14:57
 */
@Data
public class BabyDto {


    private Long id;

    private String name;

    private Date birthday;

    private int sex;
}