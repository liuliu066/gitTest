package com.study.stringTest;

import lombok.Data;

/**
 * @author lwh
 * @date 2022/7/28 15:05
 */
@Data
public class Person {
    private String name;  // ����
    private int salary; // н��
    private int age; // ����
    private String sex; //�Ա�
    private String area;  // ����

    // ���췽��
    public Person(String name, int salary, int age, String sex, String area) {
        this.name = name;
        this.salary = salary;
        this.age = age;
        this.sex = sex;
        this.area = area;
    }
}