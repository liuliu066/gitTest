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



        // ��򵥵�HTTP���󣬿����Զ�ͨ��header����Ϣ�жϱ��룬������HTTP��HTTPS
        String result1= HttpUtil.get("https://www.baidu.com");

        System.out.println(result1);

// ���޷�ʶ��ҳ������ʱ�򣬿����Զ�������ҳ��ı���
//        String result2= HttpUtil.get("https://www.baidu.com", "UTF-8");
//
//        System.out.println(result2);
//���Ե�������http�����������������Զ���URL���룬ƴ����URL��
        HashMap<String, Object> paramMap = new HashMap<>();
        paramMap.put("city", "����");
        String result3= HttpUtil.get("https://www.baidu.com", paramMap);
        System.out.println(result3);
    }


    @Test
    public void test002(){
        HashMap<String, Object> paramMap = new HashMap<>();
        paramMap.put("query", "����");
        String result= HttpUtil.post("https://www.baidu.com", paramMap);
        System.out.println(result);

//�ļ��ϴ�ֻ�轫�����еļ�ָ����Ĭ��file����ֵ��Ϊ�ļ����󼴿ɣ�����ʹ������˵���ļ��ϴ�����ͨ���ύ��������
//        paramMap.put("file", FileUtil.file("D:\\face.jpg"));
        String result11= HttpUtil.post("https://www.baidu.com", paramMap);

    }


    @Test
    public void testHttps1() throws Exception {

        JSONObject json = new JSONObject();
        json.put("username", "1332788xxxxxx");
        json.put("password", "123456.");

        String result = HttpRequest.post("https://api2.bmob.cn/1/users")
                .header("Content-Type", "application/json")//ͷ��Ϣ�����ͷ��Ϣ��ε��ô˷�������
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
