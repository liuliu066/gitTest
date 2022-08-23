package com.test.test;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.test.test.bo.IamOrganizationBo;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author lwh
 * @description:
 * @date 2022/8/22 15:20
 */
public class JsonTest {


    @Test
    public void test001(){
        String json = "{\n" +
                "  \"success\": true,\n" +
                "  \"data\": [\n" +
                "    {\n" +
                "      \"treeId\": \"EXECUTIVE\",\n" +
                "      \"name\": \"中国重汽\",\n" +
                "      \"type\": \"001\",\n" +
                "      \"parentId\": null,\n" +
                "      \"code\": \"0\",\n" +
                "      \"description\": null,\n" +
                "      \"sequence\": 0,\n" +
                "      \"isDisabled\": false,\n" +
                "      \"createAt\": \"2020-11-03 20:24:58.566\",\n" +
                "      \"updateAt\": \"2022-08-20 00:04:41.796\",\n" +
                "      \"managerId\": null,\n" +
                "      \"fullname\": \"中国重汽\",\n" +
                "      \"orgclassification\": \"1\",\n" +
                "      \"company\": null,\n" +
                "      \"pcode\": \"0\",\n" +
                "      \"headOfDepartment\": null,\n" +
                "      \"leadersInCharge\": null,\n" +
                "      \"exCode\": null,\n" +
                "      \"isRevocation\": false,\n" +
                "      \"isExecute\": true,\n" +
                "      \"hrOrgId\": \"1\",\n" +
                "      \"deputyLeader\": [],\n" +
                "      \"_AID\": \"1\",\n" +
                "      \"_BID\": \"20201103202458566-E72E-8EFB011AB\",\n" +
                "      \"_ID\": \"0\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"treeId\": \"EXECUTIVE\",\n" +
                "      \"name\": \"中国重型汽车集团有限公司\",\n" +
                "      \"type\": \"001\",\n" +
                "      \"parentId\": \"0\",\n" +
                "      \"code\": \"1000000000\",\n" +
                "      \"description\": null,\n" +
                "      \"sequence\": 0,\n" +
                "      \"isDisabled\": false,\n" +
                "      \"createAt\": \"2020-11-03 20:24:58.648\",\n" +
                "      \"updateAt\": \"2022-08-20 00:05:22.218\",\n" +
                "      \"managerId\": null,\n" +
                "      \"fullname\": \"中国重型汽车集团有限公司\",\n" +
                "      \"orgclassification\": \"1\",\n" +
                "      \"company\": \"0\",\n" +
                "      \"pcode\": \"1\",\n" +
                "      \"headOfDepartment\": null,\n" +
                "      \"leadersInCharge\": \"077771\",\n" +
                "      \"exCode\": null,\n" +
                "      \"isRevocation\": false,\n" +
                "      \"isExecute\": true,\n" +
                "      \"hrOrgId\": \"2\",\n" +
                "      \"deputyLeader\": [],\n" +
                "      \"_AID\": \"2\",\n" +
                "      \"_BID\": \"20201103202458648-6A51-F063B8172\",\n" +
                "      \"_ID\": \"1000000000\"\n" +
                "    }\n" +
                "\t],\n" +
                "  \"errorCode\": null,\n" +
                "  \"errorName\": null,\n" +
                "  \"errorMessage\": null,\n" +
                "  \"errorException\": {\n" +
                "    \"name\": null,\n" +
                "    \"message\": null,\n" +
                "    \"trace\": null\n" +
                "  }\n" +
                "}";

        Map resMap = JSONObject.parseObject(json,Map.class);
        System.out.println(resMap);
        Boolean success = (Boolean) resMap.get("success");
        if(success) {
            Object data = resMap.get("data");
            System.out.println(data);

            JSONArray s = (JSONArray) data;
            System.out.println(s);

            System.out.println("2222222222222222222222222222222");
            List aa = s;
            System.out.println(aa);

            System.out.println("-------------------------------------");



            String s111 = JSONArray.toJSONString(data);
            System.out.println(s111);
            JSONArray jsonArray = JSONObject.parseArray(s111);
            System.out.println("+++++++++++++++++++++++++++++++++++++++++");
            System.out.println(jsonArray);
            List<IamOrganizationBo> list = jsonArray.toJavaList(IamOrganizationBo.class);
            System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
            System.out.println(list);


        }


    }

    @Test
    public void test(){
        List<IamOrganizationBo> list = new ArrayList<>();
        System.out.println(list);
    }
}
