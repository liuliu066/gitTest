package com.study.Utils;

import com.alibaba.fastjson.JSON;
import okhttp3.*;
import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author lwh
 * @description:
 * @date 2022/8/19 17:12
 */
public class OkhttpClientUtils {


    /**
     * 1.1. �첽GET����
     * -new OkHttpClient;
     * -����Request����
     * -ͨ��ǰ�����еĶ��󹹽�Call����
     * -ͨ��Call#enqueue(Callback)�������ύ�첽����
     */
    @Test
    public void test001(){
        String url = "http://wwww.baidu.com";
        OkHttpClient okHttpClient = new OkHttpClient();
        final Request request = new Request.Builder()
                .url(url)
                .get()//Ĭ�Ͼ���GET���󣬿��Բ�д
                .build();
        Call call = okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                System.out.println(  "onFailure: ");
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                System.out.println( "onResponse: " + response.body().string());
            }
        });




    }

    @Test
    public void  test01201(){
        Map<String, Object> Records = new HashMap<>();
        Records.put("loginId", "newehr");
        Records.put("secretKey", "password");
        Map map =new HashMap();
        map.put("aa",false);
        map.put("bb","22");

        System.out.println(Records);
        String params = JSON.toJSONString(Records);
        System.out.println(params);
        Records.put("aaa",map);
        String params1 = JSON.toJSONString(Records);
        System.out.println(params1);



    }



}
