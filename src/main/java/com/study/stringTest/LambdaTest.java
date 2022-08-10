package com.study.stringTest;

import org.junit.Test;

/**
 * @author lwh
 * @date 2022/7/28 20:28
 */
public class LambdaTest {

    private static class Dog{
        String name;
        int age;
        //�޲ι���
        public Dog(){
            System.out.println("һ��Dog����ͨ���޲ι��챻ʵ������");
        }
        //�вι���
        public Dog(String name,int age){
            System.out.println("һ��Dog����ͨ���вι��챻ʵ������");
            this.name = name;
            this.age = age;
        }
    }
    //����һ������ʽ�ӿ�,���Ի�ȡ�޲εĶ���
    @FunctionalInterface
    private interface GetDog{
        //���˷���������Ϊ�˻��һ��Dog���󣬶���ͨ���޲ι���ȥ��ȡһ��Dog������Ϊ����ֵ
        Dog test();
    }

    //����һ������ʽ�ӿ�,���Ի�ȡ�вεĶ���
    @FunctionalInterface
    private interface GetDogWithParameter{
        //���˷���������Ϊ�˻��һ��Dog���󣬶���ͨ���вι���ȥ��ȡһ��Dog������Ϊ����ֵ
        Dog test(String name,int age);
    }

    // ����
    public static void main(String[] args) {
        //lambda���ʽʵ�ֽӿ�
        GetDog lm = Dog::new; //���õ�Dog���е��޲ι��췽������ȡ��һ��Dog����
        Dog dog = lm.test();
        System.out.println("�޹������֣�"+dog.name+" �޹������䣺"+dog.age); //�޹������֣�null �޹������䣺0
        GetDogWithParameter lm2 = Dog::new;//���õ�Dog���е��вι��죬����ȡһ��Dog����
        Dog dog1 = lm2.test("��ĦҮ",2);
        System.out.println("�޹������֣�"+dog1.name+" �޹������䣺"+dog1.age);//�޹������֣���ĦҮ �޹������䣺2

    }


    @Test
    public void test001(){
        //lambda���ʽʵ�ֽӿ�

        GetDog lm = () -> {
            return new Dog();
        }; //���õ�Dog���е��޲ι��췽������ȡ��һ��Dog����

        Dog dog = lm.test();
        System.out.println("�޹������֣�"+dog.name+" �޹������䣺"+dog.age); //�޹������֣�null �޹������䣺0
        GetDogWithParameter lm2 = Dog::new;//���õ�Dog���е��вι��죬����ȡһ��Dog����
        Dog dog1 = lm2.test("��ĦҮ",2);
        System.out.println("�޹������֣�"+dog1.name+" �޹������䣺"+dog1.age);//�޹������֣���ĦҮ �޹������䣺2


    }
}
