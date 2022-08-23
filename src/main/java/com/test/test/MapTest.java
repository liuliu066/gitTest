package com.test.test;

import cn.hutool.core.text.replacer.StrReplacer;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

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




}
