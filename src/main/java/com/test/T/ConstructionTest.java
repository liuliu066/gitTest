package com.test.T;

import java.io.Serializable;
import java.lang.reflect.Constructor;

/**
 * @author lwh
 * @description:
 *
 * Constructor类及其用法
 * Constructor类存在于反射包(java.lang.reflect)中，反映的是Class 对象所表示的类的构造方法。
 * 获取Constructor对象是通过Class类中的方法获取的，Class类与Constructor相关的主要方法如下：方法返回值方法名称方法说明
 * static Class<?>forName(String className)返回与带有给定字符串名的类或接口相关联的 Class 对象。
 * ConstructorgetConstructor(Class<?>... parameterTypes)返回指定参数类型、具有public访问权限的构造函数对象Constructor<?>[]getConstructors()返回所有具有public访问权限的构造函数的Constructor对象数组ConstructorgetDeclaredConstructor(Class<?>... parameterTypes)返回指定参数类型、所有声明的（包括private）构造函数对象Constructor<?>[]getDeclaredConstructors()返回所有声明的（包括private）构造函数对象TnewInstance()调用无参构造器创建此 Class 对象所表示的类的一个新实例。下面看一个简单例子来了解Constructor对象的使用：
 * ------
 * 著作权归@pdai所有
 * 原文链接：https://pdai.tech/md/java/basic/java-basic-x-reflection.html
 * @date 2023/5/11 17:06
 */
public class ConstructionTest implements Serializable {
    public static void main(String[] args) throws Exception {

        Class<?> clazz = null;

        //获取Class对象的引用
        clazz = Class.forName("com.test.T.User");

        //第一种方法，实例化默认构造方法，User必须无参构造函数,否则将抛异常
        User user = (User) clazz.newInstance();
        user.setAge(20);
        user.setName("Jack");
        System.out.println(user);

        System.out.println("--------------------------------------------");

        //获取带String参数的public构造函数
        Constructor cs1 =clazz.getConstructor(String.class);
        //创建User
        User user1= (User) cs1.newInstance("hiway");
        user1.setAge(22);
        System.out.println("user1:"+user1.toString());

        System.out.println("--------------------------------------------");

        //取得指定带int和String参数构造函数,该方法是私有构造private
        Constructor cs2=clazz.getDeclaredConstructor(int.class,String.class);
        //由于是private必须设置可访问
        cs2.setAccessible(true);
        //创建user对象
        User user2= (User) cs2.newInstance(25,"hiway2");
        System.out.println("user2:"+user2.toString());

        System.out.println("--------------------------------------------");

        //获取所有构造包含private
        Constructor<?> cons[] = clazz.getDeclaredConstructors();
        // 查看每个构造方法需要的参数
        for (int i = 0; i < cons.length; i++) {
            //获取构造函数参数类型
            Class<?> clazzs[] = cons[i].getParameterTypes();
            System.out.println("构造函数["+i+"]:"+cons[i].toString() );
            System.out.print("参数类型["+i+"]:(");
            for (int j = 0; j < clazzs.length; j++) {
                if (j == clazzs.length - 1)
                    System.out.print(clazzs[j].getName());
                else
                    System.out.print(clazzs[j].getName() + ",");
            }
            System.out.println(")");
        }
    }
}

