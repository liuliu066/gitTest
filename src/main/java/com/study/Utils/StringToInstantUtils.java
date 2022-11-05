package com.study.Utils;


import org.apache.commons.lang3.StringUtils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;

/**
 * @author lwh
 * @date 2022/6/17 14:06
 */
public class StringToInstantUtils {

    public static Date stringToDate(String time) {
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");//日期格式
        Date date = null;
        if (StringUtils.isEmpty(time)){
            return null;
        }
        try {
            date = format.parse(time);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    public static Instant stringToInstant(String time) {
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");//日期格式
        Date date = null;
        if (StringUtils.isEmpty(time)){
            return null;
        }
        try {
            date = format.parse(time);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        if (date != null){
            return date.toInstant();
        }else {
            return null;
        }
    }
}
