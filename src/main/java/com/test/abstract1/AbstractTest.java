package com.test.abstract1;

/**
 * @author lwh
 * @date 2021/12/27 11:09
 */
public class AbstractTest {

    public static void main(String[] args) {
        Person a = new Person() {
            @Override
            public String toString() {
                return super.toString();
            }
        };
        a.setAge(11);
        System.out.println(a.getAge());


        Person.eat();
        System.out.println();

    }
}
