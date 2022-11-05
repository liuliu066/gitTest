package com.test.test;

import cn.hutool.core.text.replacer.StrReplacer;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.Lists;
import com.study.Utils.StringToInstantUtils;
import com.test.test.bo.IamOrganizationBo;
import io.swagger.models.auth.In;
import org.apache.ibatis.logging.stdout.StdOutImpl;
import org.junit.Test;
import org.springframework.beans.BeanUtils;
import org.springframework.util.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static com.study.Utils.InstantToStringUtils.turnInstantWithDay;

/**
 * @author lwh
 * @date 2021/11/8 8:51
 */
public class MapTest {

    @Test
    public void testMap() {
        List<Map> mapList = new ArrayList<>();
        Map map = new HashMap();
        List aa = new ArrayList();
        aa.add("111");
        aa.add("222");
        map.put("aa", aa);


        List bb = new ArrayList();
        bb.add("111");
        bb.add("222");
        map.put("bb", bb);

        List cc = new ArrayList();
        Map map1 = new HashMap();
        map1.put("abc", "ass");
        cc.add(map1);
        map.put("cc", cc);
        boolean contains = map.containsKey("aa"); //判断是否包含指定的键值
        boolean contains1 = map.containsKey("bb"); //判断是否包含指定的键值
        boolean contains2 = map.containsKey("dd"); //判断是否包含指定的键值
        System.out.println(contains);
        System.out.println(contains1);
        System.out.println(contains2);
        System.out.println(map);

    }

    @Test
    public void testMap2() {

        Map result = new HashMap();
        Map fail = new HashMap();
        fail.put("fail",1332);
        fail.put("fail1",1332);
        result.put("fail",fail);
        Object fail1 = result.get("fail");
        Map fail2 = (Map) result.get("fail");


        System.out.println("result"+result);
        System.out.println("fail"+fail);
        System.out.println("fail Test"+result.get("fail"));
        System.out.println("fail object"+fail1);
        System.out.println("fail Map"+fail2);
    }

    @Test
    public void test12112() {

        List<Long> tenantIdList = new ArrayList<>();
        System.out.println(tenantIdList);
        List<Long> collect = tenantIdList.stream().distinct().collect(Collectors.toList());
        System.out.println(collect);

    }


    @Test
    public void test112() {
        List<Long> longList = new ArrayList<>();
        longList.add(111L);
        longList.add(22l);
        longList.add(113331l);
        System.out.println(longList);
        String aa = "111";
        long l = Long.parseLong(aa);
        System.out.println(longList.contains(l));
    }

    @Test
    public void test11112() {
        List<String> longList = new ArrayList<>();

        System.out.println(longList.contains("11"));
    }
    @Test
    public void test111112() {
        List<Integer> list = Arrays.asList(1, 2, 3);

        System.out.println(list);
        list.add(11);// 不能新增
        System.out.println(list);
    }

    @Test
    public void test1111112() {
        System.out.println(AA.aa);
        AA.aa = "222";

        System.out.println(AA.aa);
    }

    static class AA{
        public static String aa="11";

        public static String getAa() {
            return aa;
        }

        public static void setAa(String aa) {
            AA.aa = aa;
        }
    }

    class BB{
        String name ;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public List<String> getList() {
            return list;
        }

        public void setList(List<String> list) {
            this.list = list;
        }

        public int getAnInt() {
            return anInt;
        }

        public void setAnInt(int anInt) {
            this.anInt = anInt;
        }

        List<String> list;
        int anInt;
    }

    @Test
    public void test11() {
        Map<String,Object> map = new HashMap<>();

        map.put("11",2121);
        map.put("11测得21","321");
        System.out.println(map);

        BB te = new BB();
        te.setAnInt(2);
        te.setName("sak");
        ArrayList<String> strings = Lists.newArrayList("ceshi1", "xsa");
        System.out.println(  Lists.newArrayList("ceshi1","xsa"));
        te.setList(strings);
        System.out.println(te);

        Map detailMap = JSON.parseObject(JSON.toJSONString(te), Map.class);
        System.out.println("ces"+detailMap);

        System.out.println("-------------111111111111");
        System.out.println(detailMap.get("anInt"));
        System.out.println();
        String string = JSON.toJSONString(te);
        System.out.println("1231231"+string);
        System.out.println("--------------------");
        JSONObject jsonObject = JSON.parseObject(string);
        System.out.println(jsonObject);
        Object a = Lists.newArrayList("ces11hi1", "xsa");
        System.out.println("100"+a);
        System.out.println((ArrayList<String>)a);

        System.out.println("--------------------");
        /**
         * // 将 Map 转换为 实体类　　User user = JSON.parseObject(JSON.toJSONString(user01), User.class);　
         * 　System.out.println(user);// 将 实体类 转换为 Map　　Map map = JSON.parseObject(JSON.toJSONString(user), Map.class);　　System.out.println(map);
         */


    }

    @Test
    public void terst1(){
//        JSONObject jsonObject = JSONObject.parseObject(body);
//        JSONArray jsonArray = new JSONArray();
//        Object object = jsonObject.get("msg");
//        if(object instanceof JSONObject) {
//            jsonArray.add(object);
//        } else if(object instanceof JSONArray) {
//            jsonArray = jsonObject.getJSONArray("msg");
//        }
//        String type = jsonArray.getJSONObject(0).get("type").toString();
//        String imei = jsonArray.getJSONObject(0).get("imei").toString();
////        List<OneNetMsgVo> msgVos = JSONObject.parseArray(jsonArray.toJSONString(), OneNetMsgVo.class);
//        OneNetEventVo eventVo = JSONObject.parseObject(jsonArray.getString(0), OneNetEventVo.class);

    }

    @Test
    public void terst111(){


//        String aa="{\"data\":\"{\\\"empNoList\\\":[\\\"L000022\\\"],\\\"fullNameList\\\":[\\\"张小一\\\"],\\\"modifyEmpInfoBoList\\\":[{\\\"deptId\\\":42,\\\"deptName\\\":\\\"接待室\\\",\\\"empNo\\\":\\\"L000022\\\",\\\"fullName\\\":\\\"张小一\\\",\\\"orgId\\\":17,\\\"orgName\\\":\\\"办公室\\\"}],\\\"modifyType\\\":3,\\\"orgId\\\":17,\\\"topic\\\":\\\"由于您单位的张小一的岗位信息发生变动，考核类别标签已被清除，请及时维护。\\\"}\"}";

        List<Map> errorList = JSONArray.parseArray("21", Map.class);
        System.out.println(errorList);

    }

    @Test
    public void terst1122111(){

       Map a = new HashMap();
       a.put("su",true);
        System.out.println(a.get("su"));
        Object su = a.get("su");
        System.out.println("true".equals(a.get("su")));
    }

    @Test
    public void te11st11(){
        String s = "{\n" +
                "\t\"appCopyright\": \"Copyright © 2011-2018 Bamboocloud. All Rights Reserved.\",\n" +
                "\t\"appHostGUID\": \"IAM-UAT-APP01:20220820122308073\",\n" +
                "\t\"appVersion\": \"6.20.07.20690\",\n" +
                "\t\"errorName\": \"ILLEGAL_REQUEST\",\n" +
                "\t\"errorException\": {\n" +
                "\t\t\"name\": \"com.bamboocloud.fw.exception.SysException\",\n" +
                "\t\t\"message\": \"[S01034] 非法的请求.\",\n" +
                "\t\t\"trace\": null\n" +
                "\t},\n" +
                "\t\"data\": null,\n" +
                "\t\"appName\": \"BambooCloud Identity Manager\",\n" +
                "\t\"success\": false,\n" +
                "\t\"errorMessage\": \"Illegal request\",\n" +
                "\t\"errorCode\": \"S01034\",\n" +
                "\t\"appDebug\": false\n" +
                "}";

        Map resMap = JSONObject.parseObject(s,Map.class);
        System.out.println(resMap);
        System.out.println(resMap.get("success"));
        Boolean success = (Boolean) resMap.get("success");
        System.out.println(success);
    }


//    @Test
//    public Object checkEmpty(Object obj){
//        if (obj instanceof String){
//            return (obj ==null || obj == "") ? null: obj;
//        }else if(obj instanceof Long){
//            return  obj == null ? null :obj;
//        }
//        return obj;
//    }



    @Test
    public void date121211(){

        Instant instant = Instant.now();
        Date from = Date.from(instant);
        System.out.println(from);

    }

    @Test
    public void date12111211(){
        System.out.println(getUUID32());

        Date date =new Date();
        System.out.println(date);
        System.out.println(getSysdateStr2("yyyyMMdd"));
        System.out.println(getSysdateStr2("HHmmss"));
    }

    public static String getUUID32(){
        return UUID.randomUUID().toString().replace("-", "").toLowerCase();
    }

    public static String getSysdateStr2(String format) {

        Date sysdate = new Date();

        format = "".equals(format) ? "yyyy-MM-dd HH:mm:ss" : format;

        SimpleDateFormat sdf = new SimpleDateFormat(format);

        return sdf.format(sysdate);
    }


    @Test
    public void test111(){

        Map map = new HashMap();
        Map de = new HashMap();
        de.put("aa","ddd");
        de.put("bb","vvv");
        map.put("map",de);
        map.put("map11","222");

        System.out.println(map);
        Object de1 = map.get("map");
        Map de11 = (Map) map.get("m1ap");
        Object o = JSON.toJSON(map);
        System.out.println("-----------------------");
        System.out.println(o);

        boolean de1111 = (Boolean) map.get("m1ap");
        System.out.println("222"+de11);
        System.out.println(de1111+"222232132131");


        System.out.println("-----");

        System.out.println(de1);


        Map a= (Map) de1;
        System.out.println(a);
        System.out.println(a.get("aa"));

    }


    @Test
    public void test11111(){
        List<IamOrganizationBo> iamOrganizationBoList =new ArrayList<>();
        List<IamOrganizationBo> collect = iamOrganizationBoList.stream().filter(iamOrganizationBo -> iamOrganizationBo.getIsExecute().equals(null)).collect(Collectors.toList());
        System.out.println(collect);


    }
    @Test
    public void test1122111(){

        Instant now = Instant.now();
        Date from = Date.from(now);
        System.out.println(from);
    }

    @Test
    public void test112111(){
        int aa=1;
        boolean isFlag =true;
        while (isFlag){
            aa+=1;
            System.out.println(aa);
            if (aa==3){
                isFlag=false;
            }
        }
        System.out.println(aa);
    }

    @Test
    public void test11121(){
        System.out.println(System.getProperty("file.encoding"));
        StringJoiner code = new StringJoiner(" ");
        code.add("软件开发中心");
        code.add("企业管理与信息化部");

        String out = "";
        out = "软件开发中心 "+out;
        out ="企业管理与信息化部 "+out;
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.insert(2,"软件开发212123sdadedwqdxascsxc测的书中心 ");
        stringBuffer.insert(2,"222");
        stringBuffer.append("");

        stringBuffer.append("sss");


        System.out.println(code.toString());
        System.out.println("擦欸简单方便·");
        System.out.println(out);
        System.out.println(stringBuffer.toString());

    }


    @Test
    public void test001(){
        Integer[] arr1 ={1,2,3,4,5};

        System.arraycopy(arr1, 3, arr1, 2, -2);
        System.out.println();
        System.out.println(Arrays.stream(arr1).iterator());
        for (int i = 0; i < arr1.length; i++) {
            System.out.println(arr1[i]);
        }

    }

    @Test
    public void test00121(){
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("sss");
        stringBuffer.append("CCC");
        System.out.println(stringBuffer.toString());

    }

    @Test
    public void test0022121(){
       List<String> list =new ArrayList<>();
//       list.add("ccc");
//       list.add("aaa");
//       list.add("bbb");

       System.out.println(list.contains("aaa"));
       System.out.println(list.contains(""));
       System.out.println(list.contains(null));
       System.out.println();


    }


    @Test
    public void test(){
        System.out.println(buildPath(3727l));
    }

    private String buildPath(Long id) {
        id = 100000000L + id;
        String str = id.toString();
        System.out.println(str);
        return str.substring(str.length() - 4);
    }

    @Test
    public void test222(){
        Map<Object, String> entryWay = new HashMap<>();
        entryWay.put("01","ceshi");
        entryWay.put("02","ssogo");
        entryWay.put("03","de");

        Map<Object, String> entryWay11 = new HashMap<>();
        entryWay11.put("01","ceshi111");
        entryWay11.put("05","dsc");

        entryWay.putAll(entryWay11);
        System.out.println(entryWay);

        System.out.println("----------------");

        Map<Object, String> entryWay111 = new HashMap<>();
        entryWay111.putAll(entryWay);
        System.out.println(entryWay111);
        entryWay111.putAll(entryWay11);
        System.out.println(entryWay111);
    }

    @Test
    public void get001(){


       Student student = new Student();
       student.setLeader(false);
       student.setAge(11);
       student.setName("esfasdfffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffwaefglweuiqybfuiasudhbfoiudsabfvciopasdunvbfioupewdfbvipuadshguidbp" +
               "fijoewbfiouwbipfcnsadpioufnsadopncpoasidnfcopisdancopisdnfpuiocansodfvnasdo[iv mo[adgh0edmiuvgbadsuipvnasdipungfvoiasdnviupadsnvopiasdnvopidanv ipjdabnvpiuedncvodnvipnedfapuiovnsdaoincvoauipsdnvoiednvopsdncvoisadjcdsx");
       List<Long> longList = new ArrayList<>();
       longList.add(111l);
       longList.add(11111l);
       longList.add(12211l);
       student.setLongList(longList);

        String jsonStr = JSON.toJSONString(student);

        System.out.println(jsonStr);
        Student stu = JSONObject.parseObject(jsonStr, Student.class);


        System.out.println(stu);
        System.out.println("------------------------------------------");
        JSON json = (JSON) JSON.toJSON(student);
        System.out.println(json);
        Student student1 = JSON.toJavaObject(json, Student.class);
        System.out.println(student1);


    }



    @Test
    public void  test111111(){
        String aa= "";
        Integer bb = Integer.valueOf(aa);
        System.out.println(bb);

    }

    @Test
    public void  test11cs1(){
        String beforeDay = getBeforeDay("2022-09-01");
        System.out.println(beforeDay);

    }



    /**
     * 获取指定日期的前一天
     * @author wangz
     * @param specifiedDay
     * @return
     */
    public static String getBeforeDay(String specifiedDay)
    {
        Calendar c = Calendar.getInstance();
        Date date = null;
        try
        {
            date = new SimpleDateFormat("yyyy-MM-dd").parse(specifiedDay);
        }
        catch (ParseException e)
        {
            e.printStackTrace();
        }
        c.setTime(date);
        int day = c.get(Calendar.DATE);
        c.set(Calendar.DATE, day - 1);

        String dayBefore = new SimpleDateFormat("yyyy-MM-dd").format(c.getTime());
        return dayBefore;
    }



    @Test
    public void  test11c2s1(){
        Instant now = Instant.now();
        System.out.println(now);
        Instant beforeDayByInstant = getBeforeDayByInstant(now);
        System.out.println(beforeDayByInstant);

    }



    @Test
    public void  test11c21s1(){
        List<String> list = new ArrayList<>();

        List<String> list1 = null;

        List<String> list2 = new ArrayList<>();

        System.out.println(list1.isEmpty());
        System.out.println(list);
        list.addAll(list1);
        list.addAll(list2);
        System.out.println(list);
//
//        list1.add("11");
//        list.addAll(list1);
//        list.addAll(list2);
//        System.out.println("1"+list);


//        list1.add("11");
//        list2.add("1111111");
//        list.addAll(list1);
//        list.addAll(list2);
//        System.out.println("12"+list);
        list2.add("1111111");
        list.addAll(list1);
        list.addAll(list2);
        System.out.println("222"+list);





    }

    public  Instant getBeforeDayByInstant(Instant time) {
        try {
            Calendar c = Calendar.getInstance();
            String instantWithDay = turnInstantWithDay(time);
            if (StringUtils.isEmpty(instantWithDay)){
                return time;
            }
            System.out.println(instantWithDay);
            Date date = null;
            date = new SimpleDateFormat("yyyy-MM-dd").parse(instantWithDay);
            c.setTime(date);
            int day = c.get(Calendar.DATE);
            c.set(Calendar.DATE, day - 1);

            String dayBefore = new SimpleDateFormat("yyyy-MM-dd").format(c.getTime());
            System.out.println(dayBefore);
            time = StringToInstantUtils.stringToInstant(dayBefore);
        }catch (Exception e){
            e.printStackTrace();
        }
        return time;
    }


    @Test
    public void  test1111113411(){
        String aa= "aa";
        if (aa=="aa") return;
        System.out.println(22222);

    }


    @Test
    public void  test111111311411(){
        List<Long> longList = new ArrayList<>();
        longList.add(111L);
        longList.add(111L);
        longList.add(111L);
        longList.add(11112L);
        longList.add(111122L);
        System.out.println(longList);
        List<Long> collect = longList.stream().distinct().collect(Collectors.toList());
        System.out.println(collect);

    }

    @Test
    public void  test1111211(){
        List<Long> longList = new ArrayList<>();
        List<Long> longList1 = new ArrayList<>();
        longList1.add(111L);
        longList1.add(111L);
        longList1.add(111L);
        longList1.add(11112L);

        List<Long> longList11 = new ArrayList<>();

        System.out.println(longList);
        longList.addAll(longList1);
        System.out.println(longList);
        longList.addAll(longList11);
        System.out.println(longList);

    }



    @Test
    public void  test111121211(){
        System.out.println(getPreMonth());

    }
    /**
     *
     * 描述:获取下一个月.
     *
     * @return
     */
    public static String getPreMonth() {
        Calendar cal = Calendar.getInstance();
        cal.add(cal.MONTH, 1);
        SimpleDateFormat dft = new SimpleDateFormat("MM");
        String preMonth = dft.format(cal.getTime());
        return preMonth;
    }
    @Test
    public void  test11113411111(){
       List<String> strings = new ArrayList<>();
       List<String> strings1 = null;
       strings.forEach(s -> System.out.println(s));
       strings1.forEach(s -> System.out.println(s));

    }
    @Test
    public void  test11x1(){
        List<String> list = new ArrayList<String>(){{
            add("1111");
            add("22");
        }};
        System.out.println(list);
        boolean contains = list.contains("22");
        System.out.println(contains);

        boolean contains1 = list.contains("");
        System.out.println(contains1);

    }






    @Test
    public void  test1111x1(){
        List<Student> studentList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Student student = new Student();
            student.setName("11"+i);
            student.setOrgId(11L);
            studentList.add(student);
        }
        System.out.println(studentList);
        List<Long> collect = studentList.stream().map(item -> item.getOrgId()).distinct().collect(Collectors.toList());
        System.out.println(collect);

        List<String> collect1 = studentList.stream().map(item -> item.getName()).distinct().collect(Collectors.toList());
        System.out.println(collect1);

    }


    @Test
    public void  test11113411(){
        String aa= "库房5（工具工装加工部）";
        String bb= "库房一";
        String REGEX = "[^0-9]";
        String ticket = Pattern.compile(REGEX).matcher(bb).replaceAll("").trim();
        System.out.println(ticket);

    }




    @Test
    public void  test1111341111(){


        Student student = new Student();
        student.setAddress("01");
        student.setName("03");
        student.setAge(11);
        String s = student.toString();
        System.out.println(s);


        Student student2 = new Student();
        student2.setAddress("01");
        student2.setName("03");
        student2.setAge(11);
        String s1 = student2.toString();
        System.out.println(s1);
        Set<String> stringSet= new HashSet<>();
        stringSet.add(s);
        stringSet.add(s1);
        System.out.println("1111::::----"+stringSet);

        Set<Student> studentSet = new HashSet<>();
        boolean add = studentSet.add(student);
        System.out.println(add);
        System.out.println(studentSet);

        boolean add1 = studentSet.add(student2);
        System.out.println(add1);
        System.out.println(studentSet);


    }

    @Test
    public void  test1111(){
        testA testA = new testA();
        testA.setAge(11);
        testA.setName("2222");
        testA.setDate(new Date());
        System.out.println(testA);

        testB testB = new testB();
        BeanUtils.copyProperties(testA,testB);
        System.out.println(testB);

    }


    class  testA{
        @Override
        public String toString() {
            return "testA{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    ", date=" + date +
                    ", vv='" + vv + '\'' +
                    '}';
        }

        String name;
        Integer age;
        Date date;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }

        public Date getDate() {
            return date;
        }

        public void setDate(Date date) {
            this.date = date;
        }

        public String getVv() {
            return vv;
        }

        public void setVv(String vv) {
            this.vv = vv;
        }

        String vv;
    }


    class  testB{
        String name;

        public String getSs() {
            return ss;
        }

        public void setSs(String ss) {
            this.ss = ss;
        }

        String ss;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }

        public Instant getDate() {
            return date;
        }

        public void setDate(Instant date) {
            this.date = date;
        }

        Integer age;
        Instant date;

        @Override
        public String toString() {
            return "testB{" +
                    "name='" + name + '\'' +
                    ", ss='" + ss + '\'' +
                    ", age=" + age +
                    ", date=" + date +
                    '}';
        }
    }


}
