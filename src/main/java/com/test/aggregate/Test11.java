package com.test.aggregate;

/**
 * @author lwh
 * @date 2021/10/9 9:37
 */
public class Test11 {
    public static void main(String[] args) {
        ListStudent listStudent =new ListStudent();
        listStudent.setAge(11);
        listStudent.setName("www");
        System.out.println(listStudent+"\n");
        System.out.println(listStudent.getAge());
    }
}
