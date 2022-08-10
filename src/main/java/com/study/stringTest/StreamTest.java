package com.study.stringTest;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lwh
 * @date 2022/7/28 15:03
 */
public class StreamTest {

     List<Person> personList = new ArrayList<Person>(){
        {
            add(new Person("Tom", 8900, 18,"male", "New York"));
            add(new Person("Jack", 7000, 18,"male", "Washington"));
            add(new Person("Lily", 7800, 18,"female", "Washington"));
            add(new Person("Anni", 8200, 18,"female", "New York"));
            add(new Person("Owen", 9500, 18,"male", "New York"));
            add(new Person("Alisa", 7900,18, "female", "New York"));
        }
    };


    @Test
    public void test001(){
        System.out.println(personList);
        new Person("Lily", 7800, 18,"female", "Washington");
        System.out.println( new Person("Lily", 7800, 18,"female", "Washington"));
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(11);
            }
        });



    }

    @Test
    public void test0011() {

        personList.forEach((a) -> System.out.println(a.getAge()));
        personList.forEach(System.out::println);
    }



}
