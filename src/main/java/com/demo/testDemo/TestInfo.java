package com.demo.testDemo;

import com.alibaba.fastjson.JSON;
import com.test.test.Student;
import org.apache.commons.codec.digest.DigestUtils;
import org.junit.Test;
import org.springframework.util.StringUtils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoField;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author lwh
 * @description:
 * @date 2023/4/4 14:28
 */
public class TestInfo {



    @Test
    public void testDate(){

        String date ="2022-01";
        Boolean aBoolean = checkDateFormat(date, "yyyy-MM");
        System.out.println(aBoolean);


    }



    @Test
    public void testDate11(){

        Student student = new Student();

        Student student1 = new Student();
        student1.setLeader(true);
        student1.setAge(11);
        System.out.println(student);
        System.out.println(student1);

        student= student1;
        System.out.println(student);

    }

    /**
     * 校验日期格式
     * 无法解析2022-01
     * @param inputDate
     * @param pattern
     * @return
     */
    public static boolean isValidDate(String inputDate, String pattern) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        try {
            LocalDate.parse(inputDate, formatter);
            return true;
        } catch (DateTimeParseException e) {
            System.out.println(e);
            return false;
        }
    }


    @Test
    public void test001(){

        String a="{\"code\":\"s\",\"error\":\"\",\"data\":{\"salaryinfolist\":[],\"totalpayablesalary\":0.0,\"totalpaidsalary\":0.0}}";


       Map resMap = (Map) JSON.parse(a);
        System.out.println(resMap);
    }


    public static boolean isValidDate11(String inputDate, String pattern) {
        DateTimeFormatter formatter = new DateTimeFormatterBuilder()
                .appendPattern(pattern)
                .parseDefaulting(ChronoField.DAY_OF_MONTH, 1)
                .toFormatter();
        try {
            LocalDate.parse(inputDate, formatter);
            return true;
        } catch (DateTimeParseException e) {
            return false;
        }
    }

    public static void main(String[] args) {
        String inputDate = null;
        String pattern = "yyyy-MM";
        boolean isValid = isValidDate11(inputDate, pattern);
        System.out.println(isValid);
    }


    @Test
    public void tes11t(){

        for (int i = 0; i < 10; i++) {
            System.out.println(i);
            if (i>3 && i<8){
                continue;
            }
            System.out.println(i);
        }


    }


    public static Boolean checkDateFormat(String dateInfo,String format){
        if (StringUtils.isEmpty(dateInfo)){
            return false;
        }
        try {
            DateFormat dateFormat = new SimpleDateFormat(format);
            dateFormat.parse(dateInfo);
        }catch (Exception e){
            return false;
        }
        return true;
    }


    @Test
    public void testJav11a(){
        List<String> a = new ArrayList<>();
        a.add("222");

        List<String> b = new ArrayList<>();
        a.add("11");
        b.add("2222");

        b.addAll(a);
        System.out.println(b);
    }
    @Test
    public void testJav1121a(){
        Set<String> stringSet = new HashSet<>();
        setInfo(stringSet);
        System.out.println(stringSet);
        setInfo1(stringSet);

        System.out.println(stringSet);


    }

    private void setInfo(Set<String> stringSet){
        stringSet.add("xx");
    }
    private void setInfo1(Set<String> stringSet){
        stringSet.add("x11x");
    }



    @Test
    public void test(){

        String zhtandlwh075347 = getMd5Hex(3, "EkZR6hS1dC+naRXX076768");
        System.out.println(zhtandlwh075347);

    }


    /**
     * mD5加密
     *
     * @return
     */

    public static String getMd5Hex(Integer signNum, String Str) {
        while (signNum > 0) {
            Str = DigestUtils.md5Hex(Str);
            signNum--;
            return getMd5Hex(signNum, Str);
        }
        return Str;
    }


    @Test
    public void testJava(){
        System.out.println(3*0.2);
    }




    @Test
    public void testDate2211(){
        Date date = new Date();

        System.out.println(date);


        Date currentDate = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String formattedDate = dateFormat.format(currentDate);
        System.out.println(formattedDate);

        System.out.println(compareDate(currentDate,null));


    }



    /**
     * 比较两个日期的大小
     * @param first 第一个参数
     * @param second 第二个参数
     * @return
     */
    public Boolean compareDate(Date first,Date second){
        // 使用Calendar来比较两个日期
        Calendar cal1 = Calendar.getInstance();
        Calendar cal2 = Calendar.getInstance();
        cal1.setTime(first);
        cal2.setTime(second);
        int result = cal1.compareTo(cal2);
        if (result >0){
            return  true;
        }
        return false;
    }



    @Test
    public void test11221111(){
        int size = 10;
        List<String> strings = new ArrayList<>();
        strings.add("222");
        strings.add("222");
        strings.add("222");
        int a= strings.size();

        float taskRate = ((size - a)/size) *100;
        System.out.println(taskRate);
        System.out.println((size - 2)/size);
        System.out.println(1.00/2.00);


        int listSize = strings.size();
        float pageS= size;
        int count = (int) Math.ceil(listSize / pageS);
        System.out.println(count);
    }

    @Test
    public void test1122121111() {
        Student student = new Student();
        student.setName("5");
        Student student1 = new Student();
        student1.setName("1");
        Student student2 = new Student();
        student2.setName("3");
        Student student3 = new Student();
        student3.setName("4");
        Student student4 = new Student();
        student4.setName("1");

        List<Student> studentList = new ArrayList<>();
        studentList.add(student);
        studentList.add(student1);
        studentList.add(student2);
        studentList.add(student3);
        studentList.add(student4);

        System.out.println(studentList);

        List<Student> collect = studentList.stream().sorted(Comparator.comparing(Student::getName))
                .collect(Collectors.toList());

        System.out.println("22222222222222222222222222222");
        System.out.println(collect);

    }


    @Test
    public void test0011(){

        Date date1 = new Date(); // 第一个日期
        Date date2 = new Date(System.currentTimeMillis() + (1000 * 60 * 60 * 24 * 3)+22); // 第二个日期，比第一个日期多3天

        Calendar calendar1 = Calendar.getInstance(); // 获取Calendar实例
        calendar1.setTime(date1); // 设置日期1

        Calendar calendar2 = Calendar.getInstance(); // 获取Calendar实例
        calendar2.setTime(date2); // 设置日期2

        long diffInMillis = calendar2.getTimeInMillis() - calendar1.getTimeInMillis(); // 两个日期的毫秒差
        long diffInDays = diffInMillis / (1000 * 60 * 60 * 24); // 两个日期的天数差

        System.out.println("日期1：" + date1);
        System.out.println("日期2：" + date2);
        System.out.println( diffInDays);

        System.out.println(calculateDelayDays(date1,date2));
    }

    /**
     * 计算两个日期之间的延期天数
     */
    public static int calculateDelayDays(Date date1, Date date2) {
        // 将两个日期转换成 Calendar 类型
        Calendar cal1 = Calendar.getInstance();
        Calendar cal2 = Calendar.getInstance();
        cal1.setTime(date1);
        cal2.setTime(date2);
        // 计算相差的天数，去掉小时、分钟和秒钟

        long diff = cal2.getTimeInMillis() - cal1.getTimeInMillis();
        int diffDays = (int) (diff / (24 * 60 * 60 * 1000));
        return diffDays > 0 ? diffDays : 0; // 延期天数为正数，如果小于等于0则返回0
    }







    @Test
    public  void testSort() {
        List<Student> studentList = Arrays.asList(
//                new Student(1L, "张三", 95.5d),
//                new Student(2L, "李四", 97.5d),
//                new Student(3L, "王五", 95.5d),
//                new Student(4L, "赵六", 96.5d),
//                new Student(5L, "钱七", 98.5d),
//                new Student(6L, "小二", 97d)
        );

        Comparator<Student> byScore = Comparator.comparing(Student::getScore, (s1, s2) -> {
            return s2.compareTo(s1);
        });//按照分数降序

        Comparator<Student> byName = Comparator.comparing(Student::getName);//按照名字字典升序

        Collections.sort(studentList,byScore.thenComparing(byName));//先按照分数降序,再按照名字升序

        System.out.println(studentList);
    }



}
