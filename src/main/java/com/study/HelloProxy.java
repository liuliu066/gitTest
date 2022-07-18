package com.study;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author lwh
 * @date 2022/7/12 19:34
 */
public class HelloProxy  implements InvocationHandler {
    private Object target;
    public HelloProxy(Object obj) {
        this.target = obj;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before .....");
        method.invoke(this.target, null);
        return null;
    }
}
