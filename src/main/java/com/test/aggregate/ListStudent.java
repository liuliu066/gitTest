package com.test.aggregate;

/**
 * @author lwh
 * @date 2021/9/22 11:17
 */
public class ListStudent {

     String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    int age;

    public ListStudent(){

    }

    public ListStudent(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "ListStudent{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
