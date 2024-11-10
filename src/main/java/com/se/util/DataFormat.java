package com.se.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author baoweiwei
 * @date 2021/11/12 - 21:54
 */
public class DataFormat {
    /*将时间戳转换为日期格式的字符串
    seconds 表示精确到秒的时间戳字符串
    format 表示要转的日期时间格式 yyyy-MM-dd HH:mm:ss*/
    public static String timeStampDate(String seconds, String format) {
        if (seconds == null || seconds.isEmpty() || seconds.equals("null")) {
            return "";
        }
        if (format == null || format.isEmpty())
            format = "yyyy-MM-dd HH:mm:ss";
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(new Date(Long.valueOf(seconds + "000")));
    }

    /*
     日期格式字符串转换成时间戳
     date_str 字符串日期
     format 如：yyyy-MM-dd HH:mm:ss*/
    public static String dataTimeStamp(String date_str, String format) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            return String.valueOf(sdf.parse(date_str).getTime() / 1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    /*获取当前时间戳*/
    public static String getTimeStamp() {
        long time = System.currentTimeMillis();
        String t = String.valueOf(time / 1000);
        return t;
    }
}
