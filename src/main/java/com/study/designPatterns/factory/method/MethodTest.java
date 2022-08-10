package com.study.designPatterns.factory.method;

import com.study.designPatterns.factory.simple.SoftwareTechnology;

/**
 * @author lwh
 * @date 2022/7/29 17:06
 */
public class MethodTest {
    public static void main(String[] args) {
        WuhanAAAFactory wuhanAAAFactory = new WuhanAAAFactory();

        SoftwareTechnology softwareTechnology = wuhanAAAFactory.teachST();
        softwareTechnology.study();
    }
}
