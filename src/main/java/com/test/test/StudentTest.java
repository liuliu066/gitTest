package com.test.test;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lwh
 * @date 2021/11/4 14:20
 */
public class StudentTest {

    @Test
    public void CopyTst(){
        List<Student> studentList =new ArrayList<>();
        //例如，先在前面声明一个student对象，只new了一个，只创建了一个对象
        // 当对这个对象进行赋值时，添加到list后，在改变student对象的属性值，list中的student也会发生改变

        Student student = new Student();
        student.setAddress("aaa");
        student.setAge(11);
        student.setName("bbb");
        System.out.println(student);
        studentList.add(student);
        System.out.println(studentList);
        student.setAge(22);
        System.out.println(student);
        System.out.println(studentList);

    }

    @Test
    public void test001(){
        Student student = new Student();
        student.setAge(1);
        student.setLeader(true);
        System.out.println(student);
    }



}
