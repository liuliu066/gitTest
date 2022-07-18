package com.example.demo.test;

import com.cnhtc.hdf.wf.common.web.util.IntekeyUtils;
import com.study.algorithm.DataStructures.src.com.atguigu.stack.Calculator;
import io.swagger.annotations.ApiOperation;
import org.junit.Test;
import org.springframework.util.SocketUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.*;

/**
 * @author lwh
 * @date 2022/1/20 9:01
 */
public class BoPo {


    public static void main(String[] args) {
        Instant instant= null;
        String s = changeDate(instant);
        System.out.println(s);
    }



    @Test
    public void StringBuffer(){
        StringBuffer aaa = new StringBuffer();
        aaa.append("11111   ");
        aaa.append("aaaaaa");
        System.out.println(aaa.toString());

    }



    @Test
    public void testDate(){
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        String date = df.format(new Date());// new Date()为获取当前系统时间，也可使用当前时间戳
        System.out.println(System.currentTimeMillis());
        System.out.println(date);

    }

    public static String changeDate(Instant instantFormDate){
        if(!StringUtils.isEmpty(instantFormDate)){
            Date date = Date.from(instantFormDate);
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            return  formatter.format(date);
        }
        return "";
    }

    @Test
    public void test111(){
      Student student =new Student();
      student.setAge(1);
      student.setName("11");

      Student student1 =new Student();
      student1.setAge(2);
      student1.setName("12");
      ArrayList<Student> arrayList = new ArrayList<>();
      arrayList.add(student1);
      arrayList.add(student);
      System.out.println(arrayList);

      student1.setName("22222");

    //迭代器:完美
        Student sss ;
        Student bbb = new Student();
        System.out.println(bbb);
        for(Student ss :arrayList){
            if(ss.getAge() == 1 ){
                bbb = ss;
            }
        }
        Iterator<Student> iterator = arrayList.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
            sss = iterator.next();
            if(null != sss.getAge() && sss.getAge()==1){
                iterator.remove();
            }
//            if(iterator.next().getAge()==1){
////                System.out.println(iterator.next());
//                sss=iterator.next();
//                iterator.remove();
//            }
        }

        System.out.println(bbb);
//        System.out.println(sss);
//        System.out.println(arrayList);


//        删除索引变了，此时会报错 java.util.ConcurrentModificationException，需要使用迭代器删除
//      for(Student s: arrayList){
//          if (s.getAge() == 1){
//              arrayList.remove(s);
//          }
//      }
//        System.out.println(arrayList);
//
//      if(StringUtils.isEmpty(student)){
//          System.out.println(11);
//      }else{
//          System.out.println(33);
//      }
    }

    @Test
    public void Test0001(){
        List<Student> studentList = new ArrayList<>();
        Student student1 = new Student();
        student1.setName("111");
        student1.setAge(11);
        Student student2 = new Student();
        student2.setName("1222211");
        student2.setAge(122);
        studentList.add(student2);
        studentList.add(student1);
        System.out.println(studentList);
        studentList.forEach(student -> {

            student.setAge(222);
            student.setName("222");
        });

        System.out.println(studentList);

    }

    @Test
    public void Test0002() {
        List<Student> studentList = new ArrayList<>();
        Student student1 = new Student();
        student1.setName("111");
        student1.setAge(11);
        Student student2 = new Student();
        student2.setName("1222211");
        student2.setAge(122);
        studentList.add(student2);
        studentList.add(student1);
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < studentList.size()-1; i++) {
            Student majorBo = studentList.get(i);
            sb.append(majorBo.getName()+"-"+majorBo.getAge()+";");
        }
        Student majorBo = studentList.get(studentList.size() - 1);
        sb.append(majorBo.getName()+"-"+majorBo.getAge());
        System.out.println(sb);
        student1.setName(sb.toString());
        System.out.println(student1);
    }

    @Test
    public void Test0003() {

        Student student1 = new Student();
        student1.setName("111");
        student1.setAge(11);
        Student student2 = student1;

        System.out.println(student1);
        System.out.println(student2);

        student2.setName("21212");
        System.out.println(student1);
        System.out.println(student2);


    }

    @Test
    public void Test00013() {

        switch (3){
            case 1:
                System.out.println(1111);
                break;
            case 2:
                System.out.println(22);
                break;
            default:
                System.out.println(11122222);
        }
        System.out.println(2121231232);


    }

    @Test
    public void Test000113() {

        Long AA=222l;
       String aaa = "wooow"+AA;
//        System.out.println(aaa);
List<String> aa = new ArrayList<>();

aa.forEach(System.out::println);
    }


    @Test
    public void testFloat(){
        Float a= 2f;
        Float b=2f;


        ArrayList aa = new ArrayList();
        aa.add(2l);
        aa.add(6l);
        aa.add(3l);
        aa.add(5l);
        aa.sort(Comparator.naturalOrder());
        System.out.println(aa.size());
        System.out.println(aa);
        aa.remove(0);
        System.out.println(aa.size());
        System.out.println(aa);
        aa.remove(aa.size()-1);
        System.out.println(aa.size());
        System.out.println(aa);

        aa.forEach(System.out::println);

        System.out.println(a+b);
        System.out.println((a+b)/3);;
    }

    @Test
    public void test1121(){

        Long aa = null;
        Long bb = (Long) checkEmpty(checkEmpty(aa));
        System.out.println(bb);
    }

    private Object checkEmpty(Object obj){
        if (obj instanceof String){
            return (obj ==null || obj == "") ? null: (String)obj;
        }else if(obj instanceof Long){
            return  obj == null ? null : (Long)obj;
        }
        return obj;
    }



    @Test
    public void  test11(){
        List<Student> studentList = new ArrayList<>();

        Student student = new Student();
        student.setName("111");
//        student.setAge(11);
        Student student1 = new Student();
        student1.setName("111");
        student1.setAge(11);

//        studentList.add(student);
//        studentList.add(student1);
//        studentList.forEach(System.out::println);
//        System.out.println("---------------");
//        studentList.forEach( student2 ->  aasdd(student2));
//        studentList.forEach(System.out::println);

        System.out.println(student.getAge());



    }

    private Student aasdd(Student s){
        s.setAge(222222);
        return s;
    }





    @Test
    public void  test11111111(){

        String a = "11";
        StringBuilder sb = new StringBuilder();

        if(a.length()==5){
            sb.append(a);
        }else if (a.length()>5){
            sb.append(a.substring(0,5));
        }else {
            sb.append(addZeroForNum(a,5));
        }
        System.out.println(sb.toString());

    }
    private static String addZeroForNum(String str, int strLength) {
        int strLen = str.length();
        if (strLen < strLength) {
            while (strLen < strLength) {
                StringBuffer sb = new StringBuffer();
                sb.append("0").append(str);// 左补0
                // sb.append(str).append("0");//右补0
                str = sb.toString();
                strLen = str.length();
            }
        }
        return str;
    }


}
