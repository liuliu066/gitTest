package com.example.demo.test;

import org.junit.Test;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STSourceType;
import org.springframework.util.StringUtils;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.*;

/**
 * @author lwh
 * @date 2022/5/26 15:30
 */
public class TestMethod {



    @Test
    public void  test(){

        String aa= "sas";
        aa.length();
        System.out.println(aa);
    }


    @Test
    public void  test11(){

        System.out.println(getContent(""));
        System.out.println(getContent(null));
        System.out.println(getContent("21"));

    }

    private String getContent(String code){
        return StringUtils.isEmpty(code) ?"无" :code;
    }

    @Test
    public void test002(){
        Long fileId = 111l;
        String photo = "";
        photo += "stdp:+/hrapi/hr.file/stdp/file/billFilesReview?fileUploadInfoId="+fileId;
        System.out.println(photo);


    }

    @Test
    public void test012(){

        Map map = new HashMap();
        map.put("11",11);
        map.put("11",22);
        map.put("33",33);
        map.put("11",11);
        Set set = map.entrySet();
        System.out.println(set);

    }

    @Test
    public void test01212(){

        System.out.println(new Integer(1));

        String code = "12132312";
        String dsa = "121323-12";


        System.out.println(dsa.contains("-"));
        System.out.println(code.contains("-"));
    }

    @Test
    public void test0112(){
        String placeFormCode = getPlaceFormCode("111", "222", "333", "4444");
        System.out.println(placeFormCode);

    }

    @Test
    public void test0121212(){

        StringBuffer stringBuffer = new StringBuffer();
        System.out.println(stringBuffer);
        System.out.println(null+"21231");

        if (StringUtils.isEmpty(stringBuffer.toString())){
            System.out.println(1111);
        }



    }


    public String getPlaceFormCode(String province,String city,String county,String address ){
        StringBuffer sb = new StringBuffer();
        if (!StringUtils.isEmpty(province)){
            sb.append(province+"-");
        }
        if (!StringUtils.isEmpty(city)){
            sb.append(city+"-");
        }
        if (!StringUtils.isEmpty(county)){
            sb.append(county+"-");
        }
        return sb.toString()+address;
    }





    @Test
    public void test021212(){

        Map map1 = new HashMap(){
            {
                put("1-1-1",1-2);
            }
        };

        Map map2 = new HashMap(){
            {
                put("1-1-1",1-2);
            }
        };




        List<Map> mapList = new ArrayList<>();
        System.out.println(mapList);
        mapList.add(map1);
        mapList.add(map2);
        System.out.println("12312"+mapList);
        Object oo = mapList;
        System.out.println("231"+oo);

        Map<Map,Map> map = new HashMap();

        System.out.println(map.get("11"));


    }


    /**
     * 获取本地电脑ip地址
     * @return
     */
    public static String getLocalIpAddress(){
        InetAddress ip;      //用于获取IP(因为是静态的所以不需要使用new来实例化
        String IP = null;    //用于返回IP
        try {
            ip = Inet4Address.getLocalHost();    //获取IP
            IP = ip.getHostAddress();        	//以字符串形式存储IP
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        return IP;
    }

    @Test
    public void  testGetIp(){
        System.out.println(getLocalIpAddress());
    }

    @Test
    public void  testGetIp1(){
        System.out.println(turnInstantToDate(Instant.now()));
    }


    public static  String turnInstantToDate(Instant time) {
        String formatStr = "";
        if (null == time) {
            return formatStr;
        }
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH:mm:ss");
        ZoneId zone = ZoneId.systemDefault();
        formatStr = dateTimeFormatter.format(LocalDateTime.ofInstant(time, zone));
        return formatStr;
    }





}
