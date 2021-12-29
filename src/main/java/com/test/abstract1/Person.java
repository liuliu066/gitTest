package com.test.abstract1;

import lombok.Data;

/**
 * @author lwh
 * @date 2021/12/27 11:08
 */
@Data
public abstract class Person {

    int age;
    String name;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public static void eat(){
        System.out.println(11111111);
    }
}
