package com.study.Utils;

import cn.hutool.core.io.FileUtil;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONObject;
import org.junit.Test;

import java.util.HashMap;

/**
 * @author lwh
 * @description:
 * @date 2022/8/19 14:20
 */
public class HttpUtils {


    @Test
    public void test001(){



        // 最简单的HTTP请求，可以自动通过header等信息判断编码，不区分HTTP和HTTPS
        String result1= HttpUtil.get("https://www.baidu.com");

        System.out.println(result1);

// 当无法识别页面编码的时候，可以自定义请求页面的编码
//        String result2= HttpUtil.get("https://www.baidu.com", "UTF-8");
//
//        System.out.println(result2);
//可以单独传入http参数，这样参数会自动做URL编码，拼接在URL中
        HashMap<String, Object> paramMap = new HashMap<>();
        paramMap.put("city", "北京");
        String result3= HttpUtil.get("https://www.baidu.com", paramMap);
        System.out.println(result3);
    }


    @Test
    public void test002(){
        HashMap<String, Object> paramMap = new HashMap<>();
        paramMap.put("query", "北京");
        String result= HttpUtil.post("https://www.baidu.com", paramMap);
        System.out.println(result);

//文件上传只需将参数中的键指定（默认file），值设为文件对象即可，对于使用者来说，文件上传与普通表单提交并无区别
//        paramMap.put("file", FileUtil.file("D:\\face.jpg"));
        String result11= HttpUtil.post("https://www.baidu.com", paramMap);

    }


    @Test
    public void testHttps1() throws Exception {

        JSONObject json = new JSONObject();
        json.put("username", "1332788xxxxxx");
        json.put("password", "123456.");

        String result = HttpRequest.post("https://api2.bmob.cn/1/users")
                .header("Content-Type", "application/json")//头信息，多个头信息多次调用此方法即可
                .header("X-Bmob-Application-Id","2f0419a31f9casdfdsf431f6cd297fdd3e28fds4af")
                .header("X-Bmob-REST-API-Key","1e03efdas82178723afdsafsda4be0f305def6708cc6")
                .body(json)
                .execute().body();
        System.out.println(result);
    }



    @Test
    public void testHttps() throws Exception {

        JSONObject json = new JSONObject();
        json.put("username", "1332788xxxxxx");
        json.put("password", "123456.");

        String result = HttpRequest.post("https://api2.bmob.cn/1/users")
                .header("Content-Type", "application/json")
                .header("X-Bmob-Application-Id", "2f0419a31f9casdfdsf431f6cd297fdd3e28fds4af")
                .header("X-Bmob-REST-API-Key", "1e03efdas82178723afdsafsda4be0f305def6708cc6")
                .body(json)
                .execute().body();


        System.out.println(result);

    }


    }
