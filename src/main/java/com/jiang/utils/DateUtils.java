package com.jiang.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.SimpleFormatter;

public class DateUtils {

    /**
     * SimpleDateFormat 是一个具体的类，用于以区域设置敏感的方式格式化和解析日期。
     * 它允许格式化(日期文本)，解析(文本日期)和归一化
     *
     *
     *
     *
     * @param date
     * @param p   "yyyyMMddhhmmss"
     * @return
     */
    //日期转换为字符串
    public static String dateToString(Date date, String p){
        SimpleDateFormat formatter = new SimpleDateFormat(p);

        String format = formatter.format(date);

        return format;
    }

    public static Date StringToDate(String date,String p) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat(p);

        Date parseDate = dateFormat.parse(date);

        return parseDate;
    }



}
