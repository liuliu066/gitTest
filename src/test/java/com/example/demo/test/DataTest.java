package com.example.demo.test;

import org.junit.Test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author lwh
 * @date 2022/4/8 16:22
 */
public class DataTest {


    @Test
    public void test111() {

        System.out.println(stringToDate("2021-1-1"));
    }


    public Date stringToDate(String time) {
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");//���ڸ�ʽ
        Date date = null;
        try {
            date = format.parse(time);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    private static boolean isValidDate(String str) {
        boolean convertSuccess = true;
        // ָ�����ڸ�ʽΪ��λ��/��λ�·�/��λ���ڣ�ע��yyyy/MM/dd���ִ�Сд��
        SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        try {
            // ����lenientΪfalse.
            // ����SimpleDateFormat��ȽϿ��ɵ���֤���ڣ�����2007/02/29�ᱻ���ܣ���ת����2007/03/01
            format.setLenient(false);
            format.parse(str);
        } catch (ParseException e) {
            // e.printStackTrace();
            // ���throw java.text.ParseException����NullPointerException����˵����ʽ����
            convertSuccess = false;
        }
        return convertSuccess;
    }



    public Boolean testCheck(String date){

        String reg = "^((\\\\d{2}(([02468][048])|([13579][26]))[\\\\-\\\\/\\\\s]?((((0?[13578])|(1[02]))[\\\\-\\\\/\\\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\\\-\\\\/\\\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\\\-\\\\/\\\\s]?((0?[1-9])|([1-2][0-9])))))|(\\\\d{2}(([02468][1235679])|([13579][01345789]))[\\\\-\\\\/\\\\s]?((((0?[13578])|(1[02]))[\\\\-\\\\/\\\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\\\-\\\\/\\\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\\\-\\\\/\\\\s]?((0?[1-9])|(1[0-9])|(2[0-8]))))))$";
        String rexp = "^((\\d{2}(([02468][048])|([13579][26]))[\\-\\/\\s]?((((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])))))|(\\d{2}(([02468][1235679])|([13579][01345789]))[\\-\\/\\s]?((((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?((0?[1-9])|(1[0-9])|(2[0-8]))))))";

        Pattern pat = Pattern.compile(rexp);
        Matcher mat = pat.matcher(date);
        boolean dateType = mat.matches();
     return dateType;
    }
    @Test
    public void testRe(){
        /**
         * ���ڸ�ʽ��ȷ
         */
        String date1 = "2014-01-03";
        /**
         * ���ڷ�Χ����ȷ---ƽ�����û��29��
         */
        String date2 = "2014-02-29";
        /**
         * �����·ݷ�Χ����ȷ---�·�û��13��
         */
        String date3 = "2014-13-03";
        /**
         * ���ڷ�Χ����ȷ---����û��31��
         */
        String date4 = "2014-06-31";
        /**
         * ���ڷ�Χ����ȷ ----1�³���31��
         */
        String date5 = "2014-01-32";
        /**
         * ����������
         */
        String date6 = "0014-01-03";
        String date7 = "9014/21/3";
        String date8 = "0014/011/03";
        System.out.println(1111);
        System.out.println(testCheck(date1));
        System.out.println(222);
        System.out.println(testCheck(date2));
        System.out.println(33);
        System.out.println(testCheck(date3));
        System.out.println(444);
        System.out.println(testCheck(date4));
        System.out.println(555);
        System.out.println(testCheck(date5));
        System.out.println(666);
        System.out.println(testCheck(date6));
        System.out.println(77);
        System.out.println(testCheck(date7));
        System.out.println(88);
        System.out.println((testCheck(date8)));

    }



}