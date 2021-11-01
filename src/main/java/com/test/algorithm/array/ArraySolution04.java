package com.test.algorithm.array;

import org.apache.commons.collections4.CollectionUtils;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author lwh
 * @date 2021/10/18 9:20
 */
public class ArraySolution04 {

    /**
     *  存在重复元素
     *     给定一个整数数组，判断是否存在重复元素。
     *     如果存在一值在数组中出现至少两次，函数返回 true 。如果数组中每个元素都不相同，则返回 false 。
     */
    public boolean containsDuplicate(int[] nums) {
        //使用Java提供的排序，然后遍历，如果出现重复的数据，这两个数据肯定挨着，然后进行判断
        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                return true;
            }
        }
        return false;
    }

    @Test
    public void testlist(){
        ArrayList<Long> arrayList = new ArrayList<>();
        Long a=1l;

//        arrayList.add(1l);
//        arrayList.add(1l);
        System.out.println(arrayList);

        List<Long> list = new ArrayList<>();
        if (CollectionUtils.isNotEmpty(arrayList)) {
            for (Long co : arrayList) {
                //list去重复，内部重写equals
                if (!list.contains(co)) {
                    list.add(co);
                }
            }
        }
        System.out.println(list);


    }
}
