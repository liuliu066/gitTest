package com.example.demo.test;

import org.apache.commons.codec.digest.DigestUtils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author lwh
 * @date 2022/1/28 11:00
 */
public class MD5 {
    public static void main(String[] args) {
        String ehrAppkey = "1c429de1156639f26b35648b9c1e5e9c";
        Date date = new Date();
        String time="20220128150126";
        String yyyyMMddHHmmss = getMd5Hex(3, ehrAppkey + time);
        System.out.println(yyyyMMddHHmmss);
    }

    public static String getMd5Hex(Integer signNum,String Str){
        while (signNum>0){
            Str = DigestUtils.md5Hex(Str);
            signNum--;
            return getMd5Hex(signNum,Str);
        }
        return Str;
    }
}
