package com.test.inherit;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class testAA {

    public test1 add(String id){
        test1 test1= new test1();
        return test1;


    }


    @Test
    public void listForEachTest(){
        List<Integer> list = new ArrayList<>();
        int a=1;
        list.add(11);
        list.add(22);
        list.add(33);

        list.forEach(integer -> {

        });

    }

}
