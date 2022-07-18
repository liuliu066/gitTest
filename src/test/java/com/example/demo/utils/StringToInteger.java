package com.example.demo.utils;

import org.apache.poi.ss.formula.functions.T;
import org.junit.Test;
import org.springframework.util.StringUtils;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.*;
import java.util.regex.Pattern;

/**
 * @author lwh
 * @date 2022/6/17 8:26
 */
public class StringToInteger {


    @Test
    public void test001(){

        String aa = null;
//        System.out.println(isInteger(aa));

        String bb = "1";


        String cc = "1212.11";
        String dd = "12a12";
        String ee = "121刘2";
        String ff = "-1212.11";
//        System.out.println(isInteger(bb));
//        System.out.println(isInteger(cc));
//        System.out.println(isInteger(dd));
//        System.out.println(isInteger(ee));
//        System.out.println(isInteger(ff));

//        System.out.println(isNumber(bb));
//        System.out.println(isNumber(cc));
//        System.out.println(isNumber(dd));
//        System.out.println(isNumber(ee));
//        System.out.println(isNumber(ff));

        System.out.println(isNumeric2(bb));
        System.out.println(isNumeric2(cc));
        System.out.println(isNumeric2(dd));
        System.out.println(isNumeric2(ee));
        System.out.println(isNumeric2(ff));


    }



    // 该方法判断的是整数
    public static boolean isInteger(String str) {
        Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");

        return pattern.matcher(str).matches();
    }

    public static boolean isNumber(String str) {
        //?:0或1个, *:0或多个, +:1或多个
        Boolean strResult = str.matches("-?[0-9]+.？[0-9]*");
        if(strResult == true) {
            System.out.println("Is Number!");
        } else {
            System.out.println("Is not Number!");
        }
        return true;
    }

    public static boolean isNumeric2(String str) {
        try {
            if (str.startsWith(".") || str.endsWith(".")){
                return false;
            }
            new BigDecimal(str);
        } catch (Exception e) {
            return false;//异常 说明包含非数字。
        }
        return true;
    }

    @Test
    public void test0101() {


        String bb = "211；；";

        String substring = bb.substring(0, bb.length() - 1);
        System.out.println(bb.substring(0, bb.length() - 1));

    }

    private String getString(String a){
        return a;
    }


    @Test
    public void test0102() {
        String TT= "";
        TT= getString("")+ getString("212")+getString("321")+getString("312 ");
        System.out.println(TT);

    }

    @Test
    public void test012() {
        String time = "";
        String aa = "das";
        String bb = "问我";
        System.out.println(stringToInstant(time));
        System.out.println(stringToInstant(aa));
        System.out.println(stringToInstant(bb));
        System.out.println(11);



    }


    public static Instant stringToInstant(String time) {
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");//日期格式
        Date date = null;
        if (StringUtils.isEmpty(time)){
            return null;
        }
        try {
            date = format.parse(time);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        if (date != null){
            return date.toInstant();
        }else {
            return null;
        }
    }

    public static BigDecimal isNumber2122(String str) {
        try {
            if (str.startsWith(".") || str.endsWith(".")){
                return null;
            }
            return new BigDecimal(str);
        } catch (Exception e) {
            return null;//异常 说明包含非数字。
        }
    }
    @Test
    public void test20122() {


        System.out.println(isNumber2122("dsadas"));
        System.out.println(isNumber2122("11"));
        System.out.println(isNumber2122("22.11"));
        System.out.println(isNumber2122("-1"));
    }

    @Test
    public void test20121() {


        List<Long> longList = new ArrayList<>();
        longList = null;
        longList.add(11l);
        System.out.println(longList);
        List<Long> longList1 = new ArrayList<>();
        longList1.add(11l);
        longList1.add(22l);
        longList = longList1;
        System.out.println(longList);
    }

    @Test
    public void test202122() {

        StringJoiner joiner = new StringJoiner("；");
        joiner.add("ndsjkabn");
        joiner.add("fcsdava");

        System.out.println(joiner.toString());

    }

    @Test
    public void test201112() {
        String s = UUID.randomUUID().toString().replaceAll("-", "");

        String string = UUID.randomUUID().toString();
        UUID uuid = UUID.randomUUID();
        System.out.println(s);
        System.out.println(string);
        System.out.println(uuid);
    }


    @Test
    public void test2012() {
        Integer result = null;
        result= 11;
        System.out.println(result);


    }

    @Test
    public void test20112() {
       String aa = "21";
       String bb = "sadas";
       aa = bb+aa;
        System.out.println(aa);


    }






    }
