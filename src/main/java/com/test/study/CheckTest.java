package com.test.study;


import org.junit.Test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatterBuilder;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author lwh
 * @date 2021/10/22 14:28
 */
public class CheckTest {

    @Test
    public void test00(){

        List<String> strings = new ArrayList<>();
        strings.add("111");
        strings.add("222");
        strings.add("aaa");


        System.out.println("1111");
        int i=1;
        while (strings.size()>0 && strings!=null){
            strings = new ArrayList<>();
            strings.add("111");
            System.out.println(i);
            i++;
            strings.remove(0);

            System.out.println(strings);
        }
        System.out.println("222");

    }


    /**
     * 手机号校验
     */
    @Test
    public void test01(){
        String phone = "17612345678";
        /**
         *
         * 大陆手机号码11位数，匹配格式：前三位固定格式+后8位任意数
         * 此方法中前三位格式有：
         * 13+任意数
         * 145,147,149
         * 15+除4的任意数(不要写^4，这样的话字母也会被认为是正确的)
         * 166
         * 17+3,5,6,7,8
         * 18+任意数
         * 198,199
         * @param str
         * @return 正确返回true
         * @throws PatternSyntaxException
         */
        String regex = "^((13[0-9])|(14[5,7,9])|(15[0-3,5-9])|(166)|(17[3,5,6,7,8])" +
                "|(18[0-9])|(19[8,9]))\\d{8}$";

        if(phone.length() != 11){
            System.out.println("手机号应为11位数");
        }else{
            Pattern p = Pattern.compile(regex);
            Matcher m = p.matcher(phone);
            boolean isMatch = m.matches();
            if(isMatch){
                System.out.println("您的手机号" + phone + "是正确格式@——@");
            } else {
                System.out.println("您的手机号" + phone + "是错误格式！！！");
            }
        }
    }




    @Test
    public void test03(){
        String idNumber = isIDNumber("412825199909237122");
        System.out.println(idNumber);
    }

    public  String isIDNumber(String IDNumber) {
        if (IDNumber == null || "".equals(IDNumber)) {
            return "身份证号不能为空!";
        }
        // 定义判别用户身份证号的正则表达式（15位或者18位，最后一位可以为字母）
        String regularExpression = "(^[1-9]\\d{5}(18|19|20)\\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\\d{3}[0-9Xx]$)|" +
                "(^[1-9]\\d{5}\\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\\d{3}$)";
        //假设18位身份证号码:41000119910101123X  410001 19910101 123X
        //^开头
        //[1-9] 第一位1-9中的一个      4
        //\\d{5} 五位数字           10001（前六位省市县地区）
        //(18|19|20)                19（现阶段可能取值范围18xx-20xx年）
        //\\d{2}                    91（年份）
        //((0[1-9])|(10|11|12))     01（月份）
        //(([0-2][1-9])|10|20|30|31)01（日期）
        //\\d{3} 三位数字            123（第十七位奇数代表男，偶数代表女）
        //[0-9Xx] 0123456789Xx其中的一个 X（第十八位为校验值）
        //$结尾

        //假设15位身份证号码:410001910101123  410001 910101 123
        //^开头
        //[1-9] 第一位1-9中的一个      4
        //\\d{5} 五位数字           10001（前六位省市县地区）
        //\\d{2}                    91（年份）
        //((0[1-9])|(10|11|12))     01（月份）
        //(([0-2][1-9])|10|20|30|31)01（日期）
        //\\d{3} 三位数字            123（第十五位奇数代表男，偶数代表女），15位身份证不含X
        //$结尾

        boolean matches = IDNumber.matches(regularExpression);

        //判断第18位校验值
        if (matches) {

            if (IDNumber.length() == 18) {
                try {
                    char[] charArray = IDNumber.toCharArray();
                    //前十七位加权因子
                    int[] idCardWi = {7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2};
                    //这是除以11后，可能产生的11位余数对应的验证码
                    String[] idCardY = {"1", "0", "X", "9", "8", "7", "6", "5", "4", "3", "2"};
                    int sum = 0;
                    for (int i = 0; i < idCardWi.length; i++) {
                        int current = Integer.parseInt(String.valueOf(charArray[i]));
                        int count = current * idCardWi[i];
                        sum += count;
                    }
                    char idCardLast = charArray[17];
                    int idCardMod = sum % 11;
                    if (idCardY[idCardMod].toUpperCase().equals(String.valueOf(idCardLast).toUpperCase())) {
                        return "";
                    } else {
                        return "身份证号校验不通过，请输入正确身份证号！";
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println("异常:" + IDNumber);
                    return "身份证号格式错误";
                }
            }

        }
        return "身份证号校验不通过，请输入正确身份证号！!";
    }

    /**
     * 校验时间字符串是否合法
     *
     * @return the boolean
     */

    @Test
    public void test05(){
        boolean b = validDateStr("2017-11-21");
        System.out.println(b);
    }
    public  boolean validDateStr(String dateStr) {
        String pattern = "yyyy-MM-dd";
        try {
            LocalDate.parse(dateStr, new DateTimeFormatterBuilder().appendPattern(pattern).parseStrict().toFormatter());
            return true;
        } catch (Exception e) {
            return false;
        }
    }


    @Test
    public void dateTimeTransfer(){

        String datestr = "2020-08-31";
        String newdate = "";
        try {
            Date date = new SimpleDateFormat("yyyy-MM-dd").parse(datestr);
            Calendar calendar = new GregorianCalendar();
            calendar.setTime(date);
            calendar.add(Calendar.DATE, 1);
            date = calendar.getTime();
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            newdate = format.format(date);
            System.out.println(newdate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }


    @Test
    public void dateTimeTransfer111(){

        //2020-08-31  2012-01-11
        String datestr = "2022-08-31";
        String newdate = "2020-11-11";
        int i = datestr.compareTo(newdate);
        System.out.println(i);
        Date date = new Date();

        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");

        String now = format.format(date); //2013-01-14
        System.out.println(now);

    }



}
