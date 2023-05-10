package com.test;

import com.examples.provider.DemoService;

import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * @author lwh
 * @description:
 * @date 2023/3/8 14:55
 */
public class App {

    public static void main(String[] args) throws Exception{
        ServiceLoader<DemoService> demoServices = ServiceLoader.load(DemoService.class);
        Iterator<DemoService> iterator = demoServices.iterator();
        while (iterator.hasNext()) {
            DemoService demoService = iterator.next();
            System.out.println(demoService.getClass().getName());
            System.out.println(demoService.getClass().getClassLoader());
            System.out.printf(demoService.sayHello());
        }

    }
}