package com.example.demo.test;

import org.junit.Test;

/**
 * @author lwh
 * @date 2022/1/17 14:38
 */
public class ForTest {

    public static void main(String[] args) {
        System.out.println(m());
    }


    //try catch finally÷¥––À≥–Ú
    public static int m(){
        int i = 100;
        int[] a= {1,11};
        int[] b= new int[2];

        try {
            System.out.println(000);
            return i;
        } finally {
            i++;
            System.out.println(111);
            System.out.println(++i);
            System.out.println(i++);

        }
    }

    @Test
    public void TestWhile(){
        int i=1;
        while (i<10) {
            if(i==2){
                i+=2;
            }
            if(i==6){
                i+=2;
            }
            System.out.println(i);
            i++;

        }
    }
}
