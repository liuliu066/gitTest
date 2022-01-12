package com.study.stringTest;/**
 * @author  lwh
 * @date  2022/1/7 18:56
 */
public class StringTest {

    public static String replaceLast(String text, String regex, String replacement) {
        return text.replaceFirst("(?s)"+regex+"(?!.*?"+regex+")", replacement);
    }



    public static void main(String[] args) {

        String aa= "isworkBefBef" ;
//        System.out.println(replaceLast("isworkBefBef", "Bef", ""));
        System.out.println(replaceLast(aa,"Bef",""));
        System.out.println(aa.replace("Bef",""));
        System.out.println(aa.endsWith("Bef"));
    }

}
