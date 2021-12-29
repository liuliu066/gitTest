package com.test.test;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
}
