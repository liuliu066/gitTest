package com.test.study;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * @author lwh
 * @date 2021/12/16 14:10
 */
public class Apple {

    private int price;

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public static void main(String[] args) throws Exception{
        //正常的调用
        Apple apple = new Apple();
        apple.setPrice(5);
        System.out.println("Apple Price:" + apple.getPrice());
        //使用反射调用
        Class clz = Class.forName("com.test.study.Apple");
        System.out.println("Class"+clz);
        Method setPriceMethod = clz.getMethod("setPrice", int.class);
        System.out.println("setPriceMethod"+setPriceMethod);

        Constructor appleConstructor = clz.getConstructor();
        System.out.println("appleConstructor"+appleConstructor);

        Object appleObj = appleConstructor.newInstance();
        System.out.println("appleObj"+appleObj);

        setPriceMethod.invoke(appleObj, 14);
        Method getPriceMethod = clz.getMethod("getPrice");
        System.out.println("getPriceMethod"+getPriceMethod);

        System.out.println("Apple Price:" + getPriceMethod.invoke(appleObj));
    }
}
