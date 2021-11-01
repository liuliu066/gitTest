package com.test.collection;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lwh
 * @date 2021/10/13 10:31
 */
public class mapTest {


    public static void main(String[] args) {
        Map m1 = new HashMap();
        m1.put("Zara", "8");
        m1.put("Mahnaz", "31");
        m1.put("Ayan", "12");
        m1.put("Daisy", "14");
        System.out.println();
        System.out.println(" Map Elements");
        System.out.println( m1);
        System.out.println(m1.get("Zara"));
    }
}
