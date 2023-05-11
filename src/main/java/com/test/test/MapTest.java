package com.test.test;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.text.replacer.StrReplacer;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.Lists;
import com.study.Utils.InstantToStringUtils;
import com.study.Utils.StringToInstantUtils;
import com.test.test.bo.IamOrganizationBo;
import io.swagger.models.auth.In;
import kotlin.jvm.internal.CollectionToArray;
import org.apache.ibatis.logging.stdout.StdOutImpl;
import org.junit.Test;
import org.springframework.beans.BeanUtils;
import org.springframework.util.StringUtils;

import java.io.FileOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static com.study.Utils.InstantToStringUtils.turnInstant;
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
    public void test12212112() {
//         Integer isFullTime =null;
//        System.out.println(isFullTime == 1);
//
        Integer aa= null;
        int bb= aa.intValue();

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
    public void test12121112() {
        Integer integer = dealSplitSize(11);
        Integer integer1 = dealSplitSize(22);
        Integer integer2 = dealSplitSize(33);
        System.out.println(integer);
        System.out.println(integer1);
        System.out.println(integer2);

    }

    /**
     * 处理下载切片
     * @param size
     * @return
     */
    private Integer dealSplitSize(int size){
        int splitSize = size / 20;
        return size%20 > 0 ? splitSize +1: splitSize;
    }







    @Test
    public void test112112() {
        Object aaa="[\n" +
                "        {\n" +
                "            \"userId\":null,\n" +
                "            \"empNo\":\"0000222\",\n" +
                "            \"fullName\":\"张三\",\n" +
                "            \"directSuperiorUserId\":null,\n" +
                "            \"directSuperiorEmpNo\":\"5555000\",\n" +
                "            \"directSuperiorFullName\":\"王五\",\n" +
                "            \"rowNum\":1,\n" +
                "            \"errorMsg\":\"人员信息库中不存在需修改直接上级的员工信息；人员信息库中不存在员工新直接上级信息\",\n" +
                "            \"isRepeat\":1,\n" +
                "            \"leaderFlag\":null\n" +
                "        }\n" +
                "    ]";
        String jsonArryStr = (String) aaa;
        System.out.println(jsonArryStr);
    }

    @Test
    public void test11112() {
        Long ori=1587354091594268674L;
        Long des=1587354091594268674L;
        System.out.println(ori == des);
    }

    @Test
    public void test1221112() throws IOException {
        //&#x521B;&#x5EFA;&#x5B57;&#x8282;&#x8F93;&#x51FA;&#x6D41;&#x5BF9;&#x8C61;
        FileOutputStream fos = new FileOutputStream("fos3.txt");
        //写入数据
        for(int i=0; i<10; i++) {
            fos.write(("Love"+i+"\r\n").getBytes());
        }
        //释放资源
        fos.close();
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
        System.out.println("--------------------");

        List<String> q = new ArrayList<>();
        q.add("111");
        q.add("112");
        long count = studentList.stream().filter(item -> q.contains(item.getName())).count();
        int aaa= (int) (111-count);
        System.out.println(aaa);
        System.out.println(count);

    }

    @Test
    public void tes121t11(){

           List<String> directorLevelAboveList = new ArrayList<String>(){
            {
                add("EmpInfoConstants.CHAIRMAN");
                add("EmpInfoConstants11.CHAIRMAN");
                add("EmpInfoConst232ants.CHAIRMAN");
                add("EmpInfoCons332tants.CHAIRMAN");

            }
        };
        System.out.println(directorLevelAboveList);



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
    public void  test1111322411(){
        System.out.println( DateUtil.format(new Date(),"yyyy-MM-dd HH:mm:ss"));

        List<String> degreeList = new ArrayList<>();

        degreeList.add("01");
        degreeList.add("03");
        degreeList.add("04");
        degreeList.add("99");
        for(String a:degreeList){
            System.out.println(a);
            if (a.equals("04")){
                System.out.println(11111);
                break;
            }
        }
    }

    @Test
    public void  test122411(){
//        2022-11-28T07:11:03.875Z
        Instant now = Instant.now();
        System.out.println(now);
        String s = turnInstant(now);
        System.out.println(s);

        System.out.println("2222222222222");
        Instant instant = StringToInstantUtils.stringToInstant("2022-11-11");


        System.out.println(instant);


    }

    @Test
    public void test011111111101(){
        System.out.println(UUID.randomUUID().toString().replace("-", "").toLowerCase());
        System.out.println(DateUtil.format(new Date(), "yyyy年MM月dd日"));
    }


    @Test
    public void  test122121411(){
//        2022-11-28T07:11:03.875Z
       List<String> list = new ArrayList<>();
       list.add("11");
       list.add("22");
       list.add("33");
        System.out.println(list.contains(""));
        System.out.println(list.contains(null));
        System.out.println(list.contains(11));
        System.out.println(list.contains("11"));
        System.out.println("----------------------");
        System.out.println(isCheck());

    }

    @Test
    public void  test122121222411(){
//        2022-11-28T07:11:03.875Z
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("aa");
        stringBuffer.append("22");
        stringBuffer.append("33");
        stringBuffer.append("--");
        System.out.println(stringBuffer.toString());


    }
    @Test
    public void  test2122121222411(){
//        2022-11-28T07:11:03.875Z


        Integer aa=null;
        switch (aa){
            case 1:
                System.out.println(111);
                break;
            default:
                System.out.println(212);
        }
    }



    @Test
    public void test0021(){
        Student student = new Student();
        student.setAge(11);
        student.setName("22");
        student.setLeader(true);
        Student student1 = new Student();
        student1.setAge(22);
        student1.setName("2222");
        student1.setLeader(false);
        List<Student> aaa= new ArrayList<>();
        aaa.add(student);
        aaa.add(student1);
        System.out.println(aaa);

        student.setName("211111111111111112");
        student.setLeader(false);
        System.out.println(aaa);
    }

    private boolean isCheck(){
        List<String> list = new ArrayList<>();
        list.add("11");
        list.add("22");
        list.add("33");

        List<String> list1 = new ArrayList<>();
        list1.add("22");
        list1.add("33");
        list1.add("11");
        for (String s:list1){
            if (!list.contains(s)){
                return true;
            }
        }
        return false;
    }



    @Test
    public void test001111(){
//        String orgPath = "1999937272838";
        String orgPath = "19999001272838";
        if (null != orgPath && orgPath.length() >= 5) {

            Long orgId = Long.valueOf(orgPath.substring(5, 9));
            System.out.println(orgId);
        }


        Map<Long, Instant> orgIdMap = new HashMap<>();
        orgIdMap.put(11L,Instant.now());
        orgIdMap.put(22L,Instant.now());
        orgIdMap.put(33L,Instant.now());
        System.out.println(orgIdMap);

        Instant instant = orgIdMap.get(11l);
        if (instant == null){
            System.out.println("111111");
        }
        Instant instant1 = orgIdMap.get(111l);
        if (instant1 == null){
            System.out.println("112221111");
        }
        System.out.println(instant1);

    }


    @Test
    public void test002221(){
        String isLeader = "1";
        System.out.println(isLeader == "1");

        Map<String,String> map = new HashMap<>();
        map.put("11","12");
        map.put("2","132");
        map.put("44","121");
        map.put("5","122");
        System.out.println(map);



    }


    @Test
    public void test1112(){
        String endTime = getEndTime(null, null);
        System.out.println("s写上x");

        System.out.println(null +"");


    }

    private String getEndTime(Long orgId,Map<Long, Instant> orgIdMap){
        Instant endTime = Instant.now();
        if (orgIdMap != null && !orgIdMap.isEmpty() && orgId !=null &&  orgIdMap.get(orgId) != null){
            endTime = orgIdMap.get(orgId);
        }
        return  InstantToStringUtils.turnInstantWithDay(endTime);
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
    @Test
    public void  test1121211(){
        StringBuffer msg = new StringBuffer();
        System.out.println(msg.toString());
        msg.append("sss");
        getMessage(msg);
        System.out.println(msg);

    }



    private Boolean getMessage(StringBuffer aaa){

        aaa.append("sdadsa");
        return true;
    }

    @Test
    public void  test121111(){

        String aa="121";

        switch (aa){
            case "11":
                System.out.println(111);
                break;
            case "22":
                System.out.println(222);
                break;
            default:
                System.out.println(2121);
                return;
        }
        System.out.println(231);

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

    @Test
    public void testString(){

        List<String> ll  = new ArrayList<>();
        addZbIdList( ll,",453809c749a544f9adf3da8a420b1a40,2a0bb7d836814129a9e9054d450290cc");
        addZbIdList(ll ,",453809c749a544f9adf3da8a420b1a40,2a0bb7d836814129a9e9054d450290cc");

        System.out.println(ll.stream().distinct().collect(Collectors.toList()));


    }

    @Test
    public void testString111(){

        List<String> ll  = new ArrayList<>();
        ll.add("121");
        List<String> ll1  = new ArrayList<>();
        ll1.add("3212");
        List<String> ll11  = new ArrayList<>();
        List<String> ll111  = new ArrayList<>();
        ll11.addAll(ll);
        ll11.addAll(ll1);
        ll11.addAll(ll111);
        System.out.println(ll11);


        System.out.println(ll.stream().distinct().collect(Collectors.toList()));


    }


    /**
     * ,453809c749a544f9adf3da8a420b1a40,2a0bb7d836814129a9e9054d450290cc 对此格式进行操作
     * @param list
     * @param rcrwids
     */
    private void addZbIdList(List<String> list,String rcrwids){

        if (StringUtils.isEmpty(rcrwids)){
            return;
        }
        ArrayList<String> strings = StringToArrayList(rcrwids, ",");
        System.out.println(strings);
//        list.addAll(strings);

    }

    /**
     * 根据字符串进行分割为list
     * @param str
     * @param separator
     * @return
     */
    public static ArrayList<String> StringToArrayList(String str, String separator) {
        ArrayList<String> arr = new ArrayList<String>();
        if ((str == null) || (separator == null)) {
            return arr;
        }
        StringTokenizer st = new StringTokenizer(str, separator);
        while (st.hasMoreTokens()) {
            arr.add(st.nextToken());
        }
        return arr;
    }
    
    
    
    
    
    
    public void mapHashMap(){
        Map m = new HashMap();

        m.put("11","22");

        System.out.println(m.get("11"));




    }

    public static void main(String[] args) {


        // 时间戳
        long timestamp = 1476255956336769L;
        // 获取Instant对象，这里需要注意时间戳的单位是毫秒，需要乘以1000
        Instant instant = Instant.ofEpochMilli(timestamp);
        // 转换为LocalDateTime对象
        LocalDateTime date = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
        // 定义日期时间格式
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        // 格式化日期
        String formattedDate = date.format(formatter);
        // 输出格式化后的日期
        System.out.println(formattedDate);
    }


}
