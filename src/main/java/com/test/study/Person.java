package com.test.study;

import java.io.Serializable;

/**
 * @author lwh
 * @date 2021/10/11 16:12
 * 序列化
 */
public class Person implements Serializable {

    String name;
    int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
