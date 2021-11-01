package com.test.inherit;

import java.util.Scanner;


/*
 * 	进入debug界面，程序向下一步执行点击step over
 * 	代码区域-看程序的执行流程
 * 	debug区域-看程序的执行流程
 * 	Variables-看变量的变化
 * 	Console-看程序的输入和输出
 *
 * 	去掉多个断点再debug视图中找到Breakpoints
 */

public class debug {

    public static void main(String[] args) {
        // TODO
		int a =10;
		int b =20;
		int c =a+b;
		System.out.println(c);
        int sum =0;
        for (int x=1;x<=5;x++) {
            sum+=x;
        }
        System.out.println(sum);

        //求和方法的调用
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入第一个数据：");
        int x = sc.nextInt();
        System.out.println("请输入第二个数据：");
        int y = sc.nextInt();

        int result = sum(x,y);
        System.out.println("result:"+result);

    }
    //在对函数的调用过程中进行断点调试时，要在主函数和调用函数两个函数加断点
    public static int sum(int a,int b) {
        int y=10;
        int x=11;
        int c=a+b;
        return c;
    }
}



