package com.examples.provider;

/**
 * @author lwh
 * @description:
 * @date 2023/3/8 14:51
 */
/**
 * Implement for DemoService
 */
public class DemoServiceProvider implements DemoService {

    @Override
    public String sayHello() {
        return "hello world";
    }
}