package com.example.demo.test;

import org.junit.Test;
import org.springframework.util.StringUtils;

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
        return StringUtils.isEmpty(code) ?"нч" :code;
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
        map.put("22",22);
        map.put("33",33);
        map.put("44",44);

        Set set = map.entrySet();
        


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
        mapList.add(map1);
        mapList.add(map2);
        System.out.println(mapList);

        Map<Map,Map> map = new HashMap();

        System.out.println(map.get("11"));


    }








}
