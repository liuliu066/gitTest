package com.study.Utils;

import org.springframework.util.StringUtils;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

/**
 * @author lwh
 * @date 2022/4/29 17:22
 */
public class InstantToStringUtils {
    public static  String turnInstant(Instant time) {
        String formatStr = "";
        if (null == time) {
            return formatStr;
        }
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        ZoneId zone = ZoneId.systemDefault();
        formatStr = dateTimeFormatter.format(LocalDateTime.ofInstant(time, zone));
        return formatStr;
    }

    public static  String turnInstantWithDay(Instant time) {
        String formatStr = "";
        if (null == time) {
            return formatStr;
        }
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        ZoneId zone = ZoneId.systemDefault();
        formatStr = dateTimeFormatter.format(LocalDateTime.ofInstant(time, zone));
        return formatStr;
    }

    public static  String turnInstantNoDay(Instant time) {
        String formatStr = "";
        if (null == time) {
            return formatStr;
        }
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM");
        ZoneId zone = ZoneId.systemDefault();
        formatStr = dateTimeFormatter.format(LocalDateTime.ofInstant(time, zone));
        return formatStr;
    }

    public static  String turnInstantToDate(Instant time) {
        String formatStr = "";
        if (null == time) {
            return formatStr;
        }
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH:mm:ss");
        ZoneId zone = ZoneId.systemDefault();
        formatStr = dateTimeFormatter.format(LocalDateTime.ofInstant(time, zone));
        return formatStr;
    }

    public static  String turnInstantToString(Instant time) {
        String formatStr = "";
        if (null == time) {
            return formatStr;
        }
        ZoneId zone = ZoneId.systemDefault();
        LocalDateTime localDateTime = LocalDateTime.ofInstant(time, zone);
        int year = localDateTime.getYear();
        int monthValue = localDateTime.getMonthValue();
        int day = localDateTime.getDayOfMonth();

        int hour = localDateTime.getHour();
        int minute = localDateTime.getMinute();
        int second = localDateTime.getSecond();
//        15 27 13 11 3 ? 2020
        formatStr = second +" " +minute+ " " +hour + " "+day+" "+monthValue +" ? " +year;
        return formatStr;
    }


    /**
     * 获取指定日期的前一天
     * @return
     */
    public static Instant getBeforeDayByInstant(Instant time) {
        try {
            Calendar c = Calendar.getInstance();
            String instantWithDay = turnInstantWithDay(time);
            if (StringUtils.isEmpty(instantWithDay)){
                return time;
            }
            Date date = null;
            date = new SimpleDateFormat("yyyy-MM-dd").parse(instantWithDay);
            c.setTime(date);
            int day = c.get(Calendar.DATE);
            c.set(Calendar.DATE, day - 1);

            String dayBefore = new SimpleDateFormat("yyyy-MM-dd").format(c.getTime());
            time = StringToInstantUtils.stringToInstant(dayBefore);
        }catch (Exception e){
            e.printStackTrace();
        }
        return time;
    }






}
