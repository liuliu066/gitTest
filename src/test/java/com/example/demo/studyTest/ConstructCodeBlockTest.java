package com.example.demo.studyTest;

import java.util.Map;

/**
 * @author lwh
 * @date 2022/5/26 14:33
 */
public class ConstructCodeBlockTest {


        public static int count = 0;
        {
            count++;
            System.out.println(111);
            System.out.println(count);
        }

        public ConstructCodeBlockTest() {
            System.out.println(222);
            System.out.println(count);

        }

        public ConstructCodeBlockTest(int i) {
            this();
            System.out.println(223332);
            System.out.println(count);

        }



        public ConstructCodeBlockTest(String string) {
        }

        public static void main(String[] args) {
            new ConstructCodeBlockTest();
            new ConstructCodeBlockTest(1);
//            new ConstructCodeBlockTest("1");
            System.out.println(ConstructCodeBlockTest.count);
        }




}
