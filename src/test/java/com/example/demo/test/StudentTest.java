package com.example.demo.test;

import org.junit.Test;
import org.springframework.beans.BeanUtils;
import org.springframework.util.SocketUtils;
import org.springframework.util.StringUtils;

import java.time.DayOfWeek;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author  lwh
 * @date  2022/3/18 19:23
 */
public class StudentTest {


    @Test
    public void terst111(){
        String aa ="1111";
        System.out.println(aa.length());

        int bb = 6;
        System.out.println(bb/3);
        System.out.println(bb%3);

        int cc = 7;
        System.out.println(cc/3);
        System.out.println(cc%3);




    }



    @Test
    public void terst11111(){

        Map aa = new HashMap();
        aa.put("11",11);
        aa.put("11",22222222);
        aa.put("21",null);
        aa.put("31","11");
        aa.put("41","2121");

        Map bb = new HashMap();
//        内部竞聘改
        bb.put("222",11);

        bb.put("22222",null);
        bb.put("2222","11");
        bb.put("42222221","2121");
        System.out.println(aa);

        aa.putAll(bb);
        System.out.println(aa);

    }


    @Test
    public void test021(){
        List<String> list = new ArrayList<>();

        String aa = new String("aaa");
        String bb = "bbb";
        System.out.println(aa.toUpperCase());
        System.out.println(aa.substring(0,1));
        String cc = "ccc";
        list.add(aa);
        list.add(bb);
        list.add(cc);
        System.out.println(list);
        list.forEach(s ->
            qqq(s)

        );
        System.out.println(list);
        list.forEach(s -> {
            s.substring(0, 1);
        });
        System.out.println(list);

        System.out.println("------------------");


        Student student = new Student();
        student.setAge(11);
        Student student1 = new Student();
        student1.setAge(11);
        Student student2 = new Student();
        System.out.println(student1 == student2 );
        student2.setAge(11);

        Set<Student> sadasd = new HashSet<>();
        sadasd.add(student1);
        sadasd.add(student2);
        System.out.println("111"+sadasd);

        System.out.println("------------------");
        List<Student> studentList = new ArrayList<>();
        studentList.add(student);
        studentList.add(student1);
        studentList.add(student2);
        System.out.println(studentList);

        studentList.forEach(s -> {
//            s.setAge(22);
//            s.setName("1121");
            sss(s);

        });
        System.out.println(studentList);
    }
    public Student sss(Student student){
        student.setName("121212");
        return student;
    }

    public void qqq(String student){
        student = student.toUpperCase();

    }


    /**
     * 测试list的stream（）.map（）的使用
     */
    @Test
    public void testListStreamMap(){

        Student student = new Student();
        student.setAge(11);
        student.setName("liumouren");
        student.setBig("bigya");
        Student student1 = new Student();
        student1.setAge(22);
        student1.setName("qimouren");
        student1.setBig("big哦000");

        List<Student> streamList = new ArrayList<>();
        streamList.add(student);
        streamList.add(student1);
        System.out.println(streamList);
        /**
         * 测试studentList的for循环只要student下的某个属性进入list
         */
        // 方法一
        List<String> nameForList = new ArrayList<>();
        streamList.forEach(student2 -> nameForList.add(student2.getName()));
        System.out.println(nameForList);
        // 方法二
        List<String> nameStreamList = streamList.stream().map(student2 -> student2.getName()).collect(Collectors.toList());
        System.out.println(nameStreamList);
    }


    @Test
    public  void testFlatMap() {
        String[] array = {"HELLO","WORLD"};
        Stream<String> stream = Arrays.stream(array);
        stream.forEach(System.out::println);
        List<String> strings = Arrays.asList("hello", "world");
        List<String[]> collect = strings.stream().map(w -> w.split("")).collect(Collectors.toList());
        System.out.println(collect);
        Stream<Stream<String>> streamStream = collect.stream().map(array1 -> Arrays.stream(array1));
        List<Stream<String>> collect1 = collect.stream().map(array1 -> Arrays.stream(array1)).collect(Collectors.toList());
        collect1.stream().forEach(d -> {
            d.forEach(System.out::println);
        });
        System.out.println(collect1);
        Stream<String> stringStream = strings.stream().map(w -> w.split("")).flatMap(Arrays::stream);
        List<String> collect2 = strings.stream().map(w -> w.split("")).flatMap(Arrays::stream).collect(Collectors.toList());
        System.out.println(collect2);
    }



    @Test
    public void  testNUll(){

        Student student = new Student();
        student.setAge(11);
        student.setName("liumouren");
        student.setBig("bigya");
        Student student1 = new Student();
        student1.setAge(22);
        student1.setName("qimouren");
        student1.setBig("big哦000");

        List<Student> streamList = new ArrayList<>();
//        streamList.add(student);
//        streamList.add(student1);
        System.out.println(streamList);

        List<String> collect = streamList.stream().map(student2 -> student2.getName()).collect(Collectors.toList());
        System.out.println(collect);


    }


    @Test
    public void testSort(){
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(3);
        list.add(2);
        list.add(5);
        list.add(6);
        list.add(4);
        list.add(8);
        System.out.println(list);
//        list.sort(new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return o1.compareTo(o2);
//            }
//        });
//        System.out.println(list);

        Collections.sort(list);
        System.out.println(list);
        Integer number = list.get(list.size()-1);
        System.out.println(number);
        for (int i = 0; i < list.size()-1; i++) {
            if (list.get(i) +1 != list.get(i+1)){
                number = list.get(i);
                break;
            }
        }
        Long aa = 11L;


        System.out.println(number);
    }

    @Test
    public void test01(){

        String aa ="11";
        String bb = "212as";
        Integer cc = Integer.valueOf(aa);
        try {
            Integer dd = Integer.valueOf(bb);
            System.out.println(dd);
        }catch (Exception e){
            System.out.println("崔哦呜");
        }


        System.out.println(cc);

    }


    @Test
    public void test011(){

        String aa ="11";
        String bb = "22";

        System.out.println(aa.compareTo(bb));
        System.out.println(aa.compareTo(aa));
        System.out.println(bb.compareTo(aa));

        System.out.println(aa.equals(null));


    }



    @Test
    public void test01111(){

        Instant now = Instant.now();
        System.out.println(now);


    }

    @Test
    public void testSort11() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(3);
        list.add(2);
        list.add(5);
        list.add(6);
        list.add(4);
        list.add(8);


        list.sort(new Comparator<Integer>() {
                      @Override
                      public int compare(Integer o1, Integer o2) {

                          if (o1 > o2) return 1;
                          if (o1 < o2) return -1;
                       return 0;



                      }
                  }
        );
        System.out.println(list);


    }

    @Test
    public void test0111211(){

        Set<String> stringHashSet= new HashSet<>();

        String aa= "a";
        String bb= "b";
        String cc= "a";
        String dd= "b";

        System.out.println(stringHashSet);
        stringHashSet.forEach(s -> System.out.println(s));
        stringHashSet.add(aa);
        stringHashSet.add(bb);
        System.out.println("---------------------------");
        System.out.println(stringHashSet);
        stringHashSet.forEach(s -> System.out.println(s));
        stringHashSet.add(cc);
        stringHashSet.add(dd);
        System.out.println("--------1111-------------------");
        System.out.println(stringHashSet);
        stringHashSet.forEach(s -> System.out.println(s));
    }


    @Test
    public void TESTsET(){
        Set<Student> stringHashSet= new HashSet<>();
        Student aa= new Student();
        aa.setName("aa");

        Student bb= new Student();
        bb.setName("bb");

        Student cc= new Student();
        cc.setName("aa");

        Student dd= new Student();
        dd.setName("bb");

        System.out.println(stringHashSet);
        stringHashSet.forEach(s -> System.out.println(s));
        stringHashSet.add(aa);
        stringHashSet.add(bb);
        System.out.println("---------------------------");
        System.out.println(stringHashSet);
        stringHashSet.forEach(s -> System.out.println(s));
        stringHashSet.add(cc);
        stringHashSet.add(dd);
        System.out.println("--------1111-------------------");
        System.out.println(stringHashSet);
        stringHashSet.forEach(s -> System.out.println(s));
    }


    @Test
    public void testCF(){

        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(1);
        arrayList.add(1);
        arrayList.add(1);
        arrayList.add(1);

        System.out.println(arrayList);
        boolean result = arrayList.stream().allMatch(element -> element.equals(1));// true
        System.out.println(result);



    }
    @Test
    public void testCF132111(){

        LocalDateTime localDateTime = LocalDateTime.ofInstant(Instant.now(), ZoneId.systemDefault());
        System.out.println(localDateTime);
        Instant instant = LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant();
        System.out.println(instant);

    }

    @Test
    public void testCF1321ww11(){

       String aa = "11";
       String bb = "21";

        System.out.println(aa.compareTo(bb));

    }

    @Test
    public void test(){
        System.out.println(getStudent());

    }


    private Object getStudent(){
        Student student = new Student();
        student.setName("11");
        student.setAge(12);
        return student;
    }

    public  static  String turnInstantNoDay(Instant time) {
        String formatStr = "";
        if (null == time) {
            return formatStr;
        }
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM");
        ZoneId zone = ZoneId.systemDefault();
        formatStr = dateTimeFormatter.format(LocalDateTime.ofInstant(time, zone));
        return formatStr;
    }

    @Test
    public void test11(){
        Instant now = Instant.now();

        System.out.println(now);
        String s = turnInstantNoDay(now);
        System.out.println(s);
    }

    @Test
    public void test121111(){
        List<String> stringList = new ArrayList<>();
        stringList.add(null);
        System.out.println(stringList);
        ArrayList<Student> aa = new ArrayList<Student>() {
            {
                add(new Student());
            }
        };
        System.out.println(aa);
    }
    @Test
    public void test12121111(){

        Object aa;
        aa= "201212";
        try {
            Instant aA1 = (Instant)aa;
            System.out.println(aA1);
        }catch (Exception e){
            System.out.println(111);

        }

    }

    class AA{
        Integer aa = new Integer(1);
        Integer bb =22;

        private void setaa(Integer a){
            this.aa = a;
        }
        private void setbb(Integer b){
            this.bb = b;
        }

        @Override
        public String toString() {
            return "AA{" +
                    "aa=" + aa +
                    ", bb=" + bb +
                    '}';
        }
    }

    @Test
    public void test11211(){
        AA aa =new AA();
        System.out.println("111111111111"+aa);

        aa.setaa(1221);
        aa.setbb(222);
        System.out.println(aa);
        getA(aa);
        System.out.println(aa);

    }

    @Test
    public void test1121(){
        StringJoiner joiner = new StringJoiner("；");
//        joiner.add("212");
        String aa= "";
        joiner.add(aa);
        System.out.println(joiner.toString());

    }

    @Test
    public void testS1121(){
      StringBuffer stringBuffer = new StringBuffer();
//      stringBuffer.append("11");
        System.out.println(stringBuffer);
        System.out.println(StringUtils.isEmpty(stringBuffer.toString()));
    }



    private String getA(AA aa){
        aa.setbb(455);

        getV(aa);

        return "";
    }

    private String getV(AA aa){
        aa.setaa(91111);
        return "";
    }





    @Test
    public void test111(){

        String aa= "11";

        switch (aa){

            case "11" :


                System.out.println(111111);
                return;

            case "22":

                System.out.println(222222);
                break;

            default:
                System.out.println(2121212);
            }
    }







    @Test
    public void testCF11321(){

        String aa = "Lss11";
        System.out.println(aa);

        String substring1 = aa.substring(0, 1);
        System.out.println(substring1);
        String substring = aa.substring(1);
        System.out.println(substring);
        System.out.println(aa);


    }

    @Test
    public void testCF11(){

        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(1);
        arrayList.add(1);
        arrayList.add(1);
        arrayList.add(2);
        System.out.println(arrayList);
        boolean result = arrayList.stream().anyMatch(element -> element == 2); // true
        boolean s = arrayList.stream().anyMatch(element -> element == 3); // false
        System.out.println(result);
    }

    @Test
    public void test001(){
        Instant now = Instant.now();
        System.out.println(now);
        String turnInstant = turnInstant(now);
        System.out.println(turnInstant);
    }

    @Test
    public void test0011(){
        Instant now = Instant.now();
        System.out.println(now);
        System.out.println(turnInstant(now));
    }




    public String turnInstant(Instant time) {
        String formatStr = "";
        if (null == time) {
            return formatStr;
        }
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH:mm:ss");
        ZoneId zone = ZoneId.systemDefault();
        LocalDateTime localDateTime = LocalDateTime.ofInstant(time, zone);
        System.out.println(localDateTime);


        int year = localDateTime.getYear();
        int monthValue = localDateTime.getMonthValue();
        int day = localDateTime.getDayOfMonth();

        int hour = localDateTime.getHour();
        int minute = localDateTime.getMinute();
        int second = localDateTime.getSecond();
        System.out.println("-------------------------");
        System.out.println(year);
        System.out.println(monthValue);
        System.out.println(day);
        System.out.println(hour);
        System.out.println(minute);
        System.out.println(second);
        String aaa = second +" " +minute+ " " +hour + " "+day+" "+monthValue +" ? " +year;

        System.out.println(aaa);
        System.out.println("----------------------------------------------------------");

        int dayOfYear = localDateTime.getDayOfYear();
        int dayOfMonth = localDateTime.getDayOfMonth();
        DayOfWeek dayOfWeek = localDateTime.getDayOfWeek();
        System.out.println(dayOfMonth);
        System.out.println(dayOfYear);
        System.out.println(dayOfWeek);
        formatStr = dateTimeFormatter.format(LocalDateTime.ofInstant(time, zone));
        return formatStr;
    }


    @Test
    public void tesyt(){
        Student student1 =new Student();
        student1.setName("11");
        student1.setAge(11);
        student1.setBig("22");

        Student student2 =new Student();
        student2.setName("22");
        student2.setAge(22);
        student2.setBig("22");

        Student student3 =new Student();
        student3.setName("33");
        student3.setAge(33);
        student3.setBig("22");


        Student student4 =new Student();
        student4.setName("44");
        student4.setAge(44);
        student4.setBig("44");


        ArrayList<Student> qq = new ArrayList<>();
        qq.add(student2);
        qq.add(student4);
        qq.add(student1);
        qq.add(student3);

        System.out.println(qq);

        qq.sort(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getAge()-o2.getAge();
            }
        });

        System.out.println(qq);
        qq.sort(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getBig().compareTo(o2.getBig());
            }
        });
        String  bb="11";
        String cc="22";
        System.out.println(bb.compareTo(cc));

        System.out.println(qq);
    }

    @Test
    public void te11syt() {
        Student student1 = new Student();
        student1.setName("11");
        student1.setAge(11);
        student1.setBig("22");

        Student student2 = new Student();
        student2.setName("22");
        student2.setAge(22);
        student2.setBig("22");

        Student student3 = new Student();
        student3.setName("33");
        student3.setAge(33);
        student3.setBig("22");


        Student student4 = new Student();
        student4.setName("44");
        student4.setAge(44);
        student4.setBig("44");


        ArrayList<Student> qq = new ArrayList<>();
        qq.add(student2);
        qq.add(student4);
        qq.add(student1);
        qq.add(student3);


        System.out.println(qq);


        List<com.test.test.Student> collect = qq.stream().map(item -> {
            com.test.test.Student student = new com.test.test.Student();
            student.setName(item.getName());
            return student;
        }).collect(Collectors.toList());
    }





    @Test
    public void test02101(){

        Integer a = 1;
        System.out.println(a);
        switch (a){
            case 1:
                System.out.println(11);
                break;
        }
    }

    @Test
    public void test021101(){

        List<String> list = new ArrayList<>();
        list.add("11");
        list.add("22");
        list.add("33");
        list.add("11");
        list.add("22");

        System.out.println(list);

        List<String> stringList = list.stream().distinct().collect(Collectors.toList());
        System.out.println(stringList);

    }

    @Test
    public void t1est0211101(){
        System.out.println("08".compareTo("035"));

        System.out.println("01".compareTo("02"));

        List<String> lis= new ArrayList<>();
        lis.add("001");
        lis.add("002");
        lis.add("003");
        lis.add("004");




        System.out.println(lis.contains("001"));


    }

    @Test
    public void test0211101(){
      List<String> list = new ArrayList<String>(){
          {
              add("2");
              add("2121aa");
          }
      };
        System.out.println(list);
        String s = list.get(0);
        System.out.println(s);
        System.out.println(new ArrayList<String>(){
            {this.add("2");
            this.add("212");}
        });

    }

    @Test
    public void test0211111101(){


        String name = "10002111";
        System.out.println(name.startsWith("10002"));

    }


    @Test
    public void test021111111(){

        com.test.test.Student student = new com.test.test.Student();
        student.setAge(11);



        com.test.test.Student student1 = new com.test.test.Student();
        student1.setAge(11);



        com.test.test.Student student2 = new com.test.test.Student();
        student2.setAge(11);



        com.test.test.Student student3 = new com.test.test.Student();
        student3.setAge(11);
        List<com.test.test.Student> studentList = new ArrayList<>();
        studentList.add(student);
        studentList.add(student2);
        studentList.add(student1);

        System.out.println(studentList);

        List<Integer> collect = studentList.stream().map(studen -> studen.getAge()).collect(Collectors.toList());
        System.out.println(collect);
        List<Integer> collect1 = collect.stream().distinct().collect(Collectors.toList());
        System.out.println(collect1);


    }


    @Test
    public void tes11101(){

        com.test.test.Student student = new com.test.test.Student();
        student.setName("01");



        com.test.test.Student student1 = new com.test.test.Student();
        student1.setName("01");



        com.test.test.Student student2 = new com.test.test.Student();
        student2.setName("02");



        com.test.test.Student student3 = new com.test.test.Student();
        student3.setName("01");
        List<com.test.test.Student> studentList = new ArrayList<>();
        studentList.add(student);
        studentList.add(student2);
        studentList.add(student1);

        System.out.println(studentList.stream().map(com.test.test.Student::getName).collect(Collectors.toList()));
        System.out.println(studentList.stream().map(com.test.test.Student::getName).collect(Collectors.toList()).stream().distinct().collect(Collectors.toList()));




    }












        @Test
    public void tes1101(){


        String aa= "111";
        String bb= "00021111";
//        String cc= "";
        String dd= null;
        System.out.println(Integer.valueOf(aa));
        System.out.println(Integer.valueOf(bb));
//        System.out.println(Integer.valueOf(cc));
        System.out.println(Integer.valueOf(dd));

     int i =1;
     for (int a= 1;a< 10;a++){
         System.out.println("sda"+a);
         System.out.println("sa"+i++);
     }

    }

    @Test
    public void tes110211(){

        StringBuffer sb = new StringBuffer();
        sb.append("1121");
        sb.append("ew2e;");
        System.out.println(sb);
        System.out.println(sb.toString());

    }

    @Test
    public void test01101(){
        com.test.test.Student student = new com.test.test.Student();
        student.setName("11");
        student.setAge(22);
        one:
        if ("11".equals(student.getName())){
            System.out.println(1111);

            if (22== student.getAge()){
                System.out.println(2222);
                break one;
            }

            System.out.println(22222333);
        }


    }


    @Test
    public void test0212101(){
        PersonOne personOne = new PersonOne();

        personOne.setName("测试哦 ");
        Student student = new Student();
        student.setAge(11);
        student.setName("呀呀呀");
        student.setBig("哦哟哟");
        personOne.setStudent(student);
        System.out.println(personOne);

        People people = new People();
        BeanUtils.copyProperties(personOne, people);
        System.out.println(people);
        System.out.println("-----------------");
        System.out.println(personOne);


    }

    class  PersonOne{
        private String name;
        private Student student;


        public Student getStudent() {
            return student;
        }

        public void setStudent(Student student) {
            this.student = student;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "name"+ this.name+ ";Student"+this.student;
        }
    }




}
