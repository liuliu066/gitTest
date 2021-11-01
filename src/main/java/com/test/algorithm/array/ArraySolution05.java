package com.test.algorithm.array;

import org.junit.Test;

import java.util.Arrays;
import java.util.Hashtable;

/**
 * @author lwh
 * @date 2021/10/18 9:31
 */
public class ArraySolution05 {
    /**
     * 只出现一次的数字
     * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
     * 说明：
     * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
     */

    public static void main(String[] args) {
        ArraySolution05 arraySolution05=new ArraySolution05();
        int[] a = new int[]{1,2,3,4,3,2,1};
        int[] b;
        b =new int[3];
        b[0]=11;
        b[1]=12;
        b[2]=11;

        int aa = arraySolution05.singleNumber(a);
//        System.out.println(aa);
        int[] test = arraySolution05.test();
        System.out.println(test[1]);


    }
    public int singleNumber(int[] nums) {
        int reduce = 0;
        for (int num : nums) {
            //使用异或 异或具有交换律，如果相同为假，不同为真， a^a = 0 ;0^a = a； a^b^a = a^a^b = b
            reduce =  reduce ^ num;
        }
        return reduce;
    }


    public int[] test(){
        int[] a= new int[5];
        a[0]=1;
//        System.out.println(a);
        return a;

    }



}
