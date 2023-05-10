package com.test.test;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

/**
 * @author lwh
 * @date 2021/10/25 9:10
 */
//@Data
@Getter
@Setter
@ToString
public class Student {
    String name;
    String address;
    int age;
    List file;
    Long orgId;
    boolean isLeader;
    boolean aeader;
    List<Long> longList;
    Long id;
    Double score;




}
