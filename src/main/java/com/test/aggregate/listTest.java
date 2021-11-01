package com.test.aggregate;

import java.util.LinkedList;
import java.util.List;

/**
 * @author lwh
 * @date 2021/9/22 11:17
 */
public class listTest {
    public static void main(String[] args) {
        ListStudent student1 = new ListStudent("liuwenhao",22);
        ListStudent student2 = new ListStudent("liuliu",21);
        List<ListStudent> listStudents = new LinkedList<>();
//        listStudents.add(student1);
//        listStudents.add(student2);
//        listStudents.add(0,student1);
//        listStudents.add(1,student2);
//        System.out.println(listStudents.get(0).toString());

        listTest listTest=new listTest();
        ListStudent list = listTest.getlist("1");
        System.out.println(list);

    }


    public ListStudent getlist(String id){
        return null;
    }

}
