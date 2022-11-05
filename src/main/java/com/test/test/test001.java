package com.test.test;


import org.apache.commons.codec.digest.DigestUtils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class test001 {

    public static void main(String[] args) throws InterruptedException {


        Date date = new Date();
        String ehrAppkey = "1c429de1156639f26b35648b9c1e5e9c";
        String md5Hex = getMd5Hex(3, ehrAppkey + new SimpleDateFormat("yyyyMMddHHmmss").format(date));
        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date));
        System.out.println(md5Hex);

    }

    /**
     * mD5����
     *
     * @return
     */

    public static String getMd5Hex(Integer signNum, String Str) {
        while (signNum > 0) {
            Str = DigestUtils.md5Hex(Str);
            signNum--;
            return getMd5Hex(signNum, Str);
        }
        return Str;
    }


}

