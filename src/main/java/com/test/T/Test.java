package com.test.T;

/**
 * @author lwh
 * @description:
 * 再来看看 Class类的方法方法名说明forName()(1)获取Class对象的一个引用，但引用的类还没有加载(该类的第一个对象没有生成)就加载了这个类。
 * (2)为了产生Class引用，forName()立即就进行了初始化。
 * Object-getClass()获取Class对象的一个引用，返回表示该对象的实际类型的Class引用。
 * getName()取全限定的类名(包括包名)，即类的完整名字。
 * getSimpleName()获取类名(不包括包名)getCanonicalName()获取全限定的类名(包括包名)isInterface()判断Class对象是否是表示一个接口getInterfaces()返回Class对象数组，表示Class对象所引用的类所实现的所有接口。
 * getSupercalss()返回Class对象，表示Class对象所引用的类所继承的直接基类。应用该方法可在运行时发现一个对象完整的继承结构。newInstance()返回一个Oject对象，是实现“虚拟构造器”的一种途径。
 * 使用该方法创建的类，必须带有无参的构造器。
 * getFields()获得某个类的所有的公共（public）的字段，包括继承自父类的所有公共字段。
 * 类似的还有getMethods和getConstructors。getDeclaredFields获得某个类的自己声明的字段，即包括public、private和proteced，默认但是不包括父类声明的任何字段。
 * 类似的还有getDeclaredMethods和getDeclaredConstructors。
 * ------
 */
import java.lang.reflect.Field;
interface I1 {
}
interface I2 {
}
class Cell{
    public int mCellPublic;
}
class Animal extends  Cell{
    private int mAnimalPrivate;
    protected int mAnimalProtected;
    int mAnimalDefault;
    public int mAnimalPublic;
    private static int sAnimalPrivate;
    protected static int sAnimalProtected;
    static int sAnimalDefault;
    public static int sAnimalPublic;
}
class Dog extends Animal implements I1, I2 {
    private int mDogPrivate;
    public int mDogPublic;
    protected int mDogProtected;
    private int mDogDefault;
    private static int sDogPrivate;
    protected static int sDogProtected;
    static int sDogDefault;
    public static int sDogPublic;
}
public class Test {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
        Class<Dog> dog = Dog.class;
        //类名打印
        System.out.println(dog.getName()); //com.cry.Dog
        System.out.println(dog.getSimpleName()); //Dog
        System.out.println(dog.getCanonicalName());//com.cry.Dog
        //接口
        System.out.println(dog.isInterface()); //false
        for (Class iI : dog.getInterfaces()) {
            System.out.println(iI);
        }
         /*
          interface com.cry.I1
          interface com.cry.I2
         */

        //父类
        System.out.println(dog.getSuperclass());//class com.cry.Animal
        //创建对象
        Dog d = dog.newInstance();
        //字段
        for (Field f : dog.getFields()) {
            System.out.println(f.getName());
        }
        /*
            mDogPublic
            sDogPublic
            mAnimalPublic
            sAnimalPublic
            mCellPublic  //父类的父类的公共字段也打印出来了
         */
        System.out.println("---------");
        for (Field f : dog.getDeclaredFields()) {
            System.out.println(f.getName());
        }
        /** 只有自己类声明的字段
         mDogPrivate
         mDogPublic
         mDogProtected
         mDogDefault
         sDogPrivate
         sDogProtected
         sDogDefault
         sDogPublic
         */
    }
}
