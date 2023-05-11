package com.test.file;

/**
 * @author lwh
 * @description:
 * @date 2023/5/10 10:47
 */


import java.io.*;
import java.util.*;

/**
 * 2:������ѧ���������л���ȥ����ȡ�������ο�һ��txt�����������
 *	������Ҫʵ��Serializable
 * */
public class FileOperationTest implements Serializable{
    public static void main(String[] args) {
        Student stu[]=new Student[3];
        FileOutputStream f1=null;
        ObjectOutputStream f2=null;

        //初始化三个学生的数据
        stu[0]=new Student("小明",18,"男");
        stu[1]=new Student("小白",19,"女");
        stu[2]=new Student("小张",20,"男");

        //学生信息的序列化
        try {
            f1=new FileOutputStream("Student.txt");
            f2=new ObjectOutputStream(f1);
            for (int i = 0; i < stu.length; i++) {
                f2.writeObject(stu[i]);
            }

        } catch (Exception e) {
            // TODO: handle exception
        }finally {
            try {
                f2.close();
                f1.close();
            } catch (Exception e2) {
                // TODO: handle exception
            }
        }


        //学生信息的取出(反序列化)
        FileInputStream f3=null;
        ObjectInputStream f4=null;
        List<Object> list1=null;

        try {
            f3=new FileInputStream("Student.txt");
            f4=new ObjectInputStream(f3);
            System.out.println("学生的姓名\t年龄\t性别\t");
            for (int i = 0; i < stu.length; i++) {
                System.out.println(stu[i].getName()+"\t"+stu[i].getAge()+"\t"+stu[i].getGender());
            }

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally {
            try {
                f4.close();
                f3.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

    }

    static class Student implements Serializable{
        private String name;
        private Integer age;
        private String gender;


        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }

        public String getGender() {
            return gender;
        }

        public void setGender(String gender) {
            this.gender = gender;
        }


        public Student(String name, Integer age, String gender) {
            this.name = name;
            this.age = age;
            this.gender = gender;
        }
    }
}


