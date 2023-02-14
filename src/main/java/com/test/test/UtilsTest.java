package com.test.test;

import org.junit.Test;
import org.springframework.util.StringUtils;

/**
 * @author lwh
 * @description:
 * @date 2023/1/29 8:35
 */
public class UtilsTest {


    @Test
    public void testHasNext(){
        String text = "";
        boolean result = StringUtils.hasText(text);
        System.out.println(result);

        String text1 = "     ";
        boolean result1 = StringUtils.hasText(text1);
        System.out.println(result1);

        String text2 = null;
        boolean result2 = StringUtils.hasText(text2);
        System.out.println(result2);
    }
}
