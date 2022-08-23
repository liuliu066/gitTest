package com.test.test;

/**
 * @author lwh
 * @description:
 * @date 2022/8/22 10:24
 */

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import okhttp3.*;
import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.NotNull;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @author lwh
 * @description:
 * @date 2022/8/22 8:53
 */
@Slf4j
@Service
public class EhrIamLoginService {



    @Test
    public void test() throws IOException {
        this.loginIam();
//        System.out.println( this.loginIam());
    }

    @Test
    public void tes22t() throws IOException {
        this.iamLogout("AF28AD6F-0AF0-49B4-950E-753572203F05");
//        System.out.println( this.loginIam());
    }

    /**
     * 登录请求
     * @return
     */
    public String loginIam() throws IOException {
        final StringBuffer token = new StringBuffer("");

        Map<String, Object> Records = new HashMap<>();
        Records.put("loginId", "newehr");
        Records.put("secretKey", "password");
        String params = JSON.toJSONString(Records);
        log.info("IAN请求参数:{}",params);


        // 发送请求
        sendReq(params, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                String resp = e.getMessage();
                System.out.println("IAM接口登录调用异常");
            }
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String resp = response.body().string();
                log.info("IAM返回数据:{}",resp);
                if(StringUtils.isNotEmpty(resp)){
                    try {
                        Map resMap = JSONObject.parseObject(resp,Map.class);
                        Boolean success = (Boolean) resMap.get("success");
                        if(success){
                            token.append(resMap.get("data"));
                            log.info("调用IAM登录接口成功", token.toString());
                        }else{
                            log.info("调用IAM登录接口失败！");
                        }
                    }catch (Exception e){
                        log.error("IAM登录返回解析异常",e);
                    }
                }else {
                    log.error("IAM登录接口返回数据为空");
                }
            }
        },"login");
        return token.toString();
    }




    public void iamLogout(String param) throws IOException {

        if (StringUtils.isEmpty(param)) {
            log.info("iam获取token为空，登出失败！");
            return;
        }
        final StringBuffer token = new StringBuffer("");

        Map<String, Object> Records = new HashMap<>();
        Records.put("token", param);
        String params = JSON.toJSONString(Records);
        log.info("IAN登出请求参数:{}",params);
        // 发送请求
        sendReq(params, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                String resp = e.getMessage();
                log.error("IAM登出接口调用异常",e);
            }
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String resp = response.body().string();
                log.info("IAM登出返回数据:{}",resp);
                if(StringUtils.isNotEmpty(resp)){
                    try {
                        Map resMap = JSONObject.parseObject(resp,Map.class);
                        Boolean success = (Boolean) resMap.get("success");
                        if(success){
                            log.info("调用IAM登出接口成功", token.toString());
                        }else{
                            log.info("调用IAM登出接口失败！");
                        }
                    }catch (Exception e){
                        log.error("IAM登出返回解析异常",e);
                    }
                }else {
                    log.error("IAM登出接口返回数据为空");
                }
            }
        },"logout");

    }




    /**
     * 发送请求
     * @param json
     * @param callback
     * @param type
     * @throws IOException
     */
    private void sendReq(String json, Callback callback,String type) throws IOException {
//        String mdgUrl = NacosGlobalConfiguration.getByKey("mdgUrl");
//        String userName =NacosGlobalConfiguration.getByKey("mdgUserName");
//        String password = NacosGlobalConfiguration.getByKey("mdgPassword");

        String iamUal ="";
        switch (type){
            case "login":
                iamUal ="https://iam-uat.sinotruk.com:7011/bim-server/api/rest/management/ExtApiMgmtAuthService/login";
                break;
            case "logout":
                iamUal ="http://192.168.6.127:8081/bim-server/api/rest/management/ExtApiMgmtAuthService/logout";
                break;
        }
        RequestBody body = RequestBody.create(MediaType.parse("application/json; charset=utf-8"),json);
        OkHttpClient client = new OkHttpClient();
        final Request request = new Request.Builder()
                .url(iamUal)
                .post(body)
                .build();
        Response execute = client.newCall(request).execute();
//        client.newCall(request).enqueue(new Callback() {
//            @Override
//            public void onFailure(@NotNull Call call, @NotNull IOException e) {
//                System.out.println(1111);
//            }
//
//            @Override
//            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
//                System.out.println(22222);
//
//            }
//        });
//        System.out.println(execute.body().string());
    }




    @Test
    public void postDataWithParame() throws IOException {
        OkHttpClient client = new OkHttpClient();

        FormBody.Builder formBody = new FormBody.Builder();//创建表单请求体
        formBody.add("username","zhangsan");//传递键值对参数
        Request request = new Request.Builder()//创建Request 对象。
                .url("http://www.baidu.com")
                .post(formBody.build())//传递请求体
                .build();
        Call call = client.newCall(request);
        System.out.println(call);
        Response execute = call.execute();
        call.enqueue(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                System.out.println(111);
            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {

                System.out.println(222);
            }
        });//此处省略回调方法。

        System.out.println(1111222);
    }





}
