package com.test.abstracts;

import org.junit.Test;

/**
 * @author lwh
 * @date 2021/11/12 9:41
 */
public class abstractTest {


    public static void main(String[] args) {
        /* People people = new People(); */ //错误
        People p = new Man();
        p.eat();
        p.drink();
        /* p.palyGames() */ //此方法错误
        Man man = new Man();
        man.eat();
        man.playGames();
        Women women = new Women();
        women.eat();
        women.dressing();
    }
    //抽象类中，必须创建子类的实例，调用的方法只能调用抽象父类有的方法
    @Test
    public void test001(){
        People p = new Man();
        p.eat();
        p.drink();
        /* p.palyGames() */ //此方法错误

    }
    @Test
    public void test002(){
        Man man = new Man();
        man.eat();
        man.playGames();

    }

    @Test
    public void test003(){
        People p = new Man();
        p.eat();
        p.drink();

    }

    abstract static class People {
        String name;
        int age;
        float height;
        float weight;

        public void eat() {
            System.out.println("人都会吃饭");
        }

        public abstract void drink();
    }

    static class Man extends People {
        float short_hair;

        public void playGames() {
            System.out.println("男的独有的打游戏技能");
        }

        @Override
        public void drink() {
            System.out.println("man drink 酒");
        }
    }

    static class Women extends People {
        float long_hair;

        public void dressing() {
            System.out.println("女的独有的化妆技能");
        }

        @Override
        public void drink() {
            System.out.println("women drink 饮料");
        }
    }
}




