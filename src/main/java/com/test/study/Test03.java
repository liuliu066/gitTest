package com.test.study;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author lwh
 * @date 2021/11/6 15:17
 */
public class Test03 {
    //这是main方法，程序的入口
    public static void main(String[] args) {
        Map<Student,Integer> map = new TreeMap<>(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return ((Double)(o1.getHeight())).compareTo((Double)(o2.getHeight()));
            }
        });
        map.put(new Student(19,"blili",170.5),1001);
        map.put(new Student(18,"blili",150.5),1003);
        map.put(new Student(19,"alili",180.5),1023);
        map.put(new Student(17,"clili",140.5),1671);
        map.put(new Student(10,"dlili",160.5),1891);
        System.out.println(map);
        System.out.println(map.size());
    }
}
class Student {
    int age;
    String name;
    double Height;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getHeight() {
        return Height;
    }

    public void setHeight(double height) {
        Height = height;
    }

    Student(int age, String name, double Height) {
        this.age = age;
        this.name = name;
        this.Height = Height;

    }

}