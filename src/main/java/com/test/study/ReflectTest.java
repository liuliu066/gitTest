package com.test.study;

import org.junit.Test;

import java.util.Random;

/**
 * @author lwh
 * @date 2021/10/11 17:03
 */
public class ReflectTest {
//
//    Reflection（反射)是被视为动态语言的关键，反射机制允许程序在执行期借助于Reflection API取得任何
//    类的内部信息，并能直接操作任意对象的内部属性及方法。
//    框架 = 反射 + 注解 + 设计模式。
//            3.体会反射机制的“动态性”

    //体会反射的动态性
    @Test
    public void test2(){

        for(int i = 0;i < 10;i++){
            int num = new Random().nextInt(3);//0,1,2
            String classPath = "";
            switch(num){
                case 0:
                    classPath = "java.util.Date";
                    break;
                case 1:
                    classPath = "java.lang.Object";
                    break;
                case 2:
                    classPath = "com.test.study.Person";
                    break;
            }

            try {
                Object obj = getInstance(classPath);
                System.out.println(obj);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }


    public Object getInstance(String classPath) throws Exception {
        Class clazz =  Class.forName(classPath);
        return clazz.newInstance();
    }
}
