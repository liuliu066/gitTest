package com.study.designPatterns.factory.method;

import com.study.designPatterns.factory.simple.SoftwareTechnology;

/**
 * @author lwh
 * @date 2022/7/29 17:04
 */
public class WuhanAAAFactory implements AAAStandardFactory{


    @Override
    public SoftwareTechnology teachST() {
        return new CDevTechnology();
    }
}
