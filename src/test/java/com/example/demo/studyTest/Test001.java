package com.example.demo.studyTest;

/**
 * @author lwh
 * @date 2022/5/14 13:57
 */
public class Test001 {


    public static void main(String[] args){
        System.out.println(sum(-1)); // -1
        System.out.println(sum(2)); // 3
        System.out.println(sum(3)); // 6
        System.out.println(sum(1)); //1
    }

    // µÝ¹é ·µ»Ø n µÄºÍ
    public static  int sum(int n){
        if (n <= 0) return n;
        if (n == 1)return  1;
        return n + sum( n -1);
    }
}
