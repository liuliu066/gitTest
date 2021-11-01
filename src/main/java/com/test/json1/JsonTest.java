package com.test.json1;

import com.alibaba.fastjson.JSONArray;
import org.springframework.core.io.ClassPathResource;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;



/**
 * @author lwh
 * @date 2021/10/13 15:29
 */
public class JsonTest {

    //获取语言信息json
    public  String getJson() {
        String jsonStr = "";
        try {

//            File file = new File("D:\\Program Files\\IdeaProjects\\src\\main\\resources\\json\\language.json");
//            String fileName = this.getClass().getClassLoader().getResource("/json/language.json").getPath();
//
            ClassPathResource classPathResource = new ClassPathResource("/json/language.json");

            // 获得File对象，当然也可以获取输入流对象
            File file = classPathResource.getFile();

//            String test = this.getClass().getResource("/json/language.json").getFile();
//            System.out.println(fileName);
//            System.out.println(test);
//            System.out.println(file);
            FileReader fileReader = new FileReader(file);
            Reader reader = new InputStreamReader(new FileInputStream(file), "Utf-8");
            int ch = 0;
            StringBuffer sb = new StringBuffer();
            while ((ch = reader.read()) != -1) {
                sb.append((char) ch);
            }
            fileReader.close();
            reader.close();
            jsonStr = sb.toString();
            return jsonStr;
        } catch (Exception e) {
            return null;
        }
    }

    public static void main(String[] args) {
/**
 *

        List<String> stringList = new ArrayList<>();
        JSONArray jsonArray = JSONArray.parseArray(getJson());
//        System.out.println(jsonArray);
        for (int i = 0; i < jsonArray.size(); i++) {
            Map language = (Map) jsonArray.get(i);
//            System.out.println(language);
            String  itemName = (String) language.get("itemValue");

//            System.out.println(itemName);
            if ("05".equals(itemName)){
                System.out.println("5555");
                String langType = (String) language.get("itemName");
                System.out.println(langType);
                stringList.add(langType);
                List<Map> level = (List) language.get("level");
                System.out.println(level);
                for(Map m :level){
                    String itemValue = (String) m.get("itemValue");
                    if(itemValue.equals("57")){
                        String itemName1 = (String) m.get("itemName");
                        stringList.add((itemName1));
                        System.out.println(stringList);


                    }

                }
            }

 */

        JsonTest jsonTest=new JsonTest();
        String languageInfo = jsonTest.getLanguageInfo("02", "05");
        System.out.println(languageInfo);
//        System.out.println(jsonTest.getJson());
//        String a=jsonTest.getJson();
//        System.out.println(a);


    }


        /**
         * 获取语言类型、语言级别
         */



    public String getLanguageInfo(String languageType,String languageGrade){
//        parseArray将获得的字符串直接转换成对象
        JSONArray jsonArray = JSONArray.parseArray(getJson());
        //循环遍历jsonArray
        if(jsonArray!=null&&jsonArray.size()>0) {
            for (int i = 0; i < jsonArray.size(); i++) {
                Map language = (Map) jsonArray.get(i);
                String lanType = (String) language.get("itemValue");
                if (lanType.equals(languageType)) {
                    List<Map> level = (List) language.get("level");
                    for (Map m : level) {
                        String itemValue = (String) m.get("itemValue");
                        if (itemValue.equals(languageGrade)) {
                            String grade = (String) m.get("itemName");
                            return grade;
                        }

                    }
                }

            }
        }
        return null;
    }
}


