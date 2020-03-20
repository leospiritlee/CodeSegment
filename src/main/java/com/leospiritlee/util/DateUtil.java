package com.leospiritlee.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;

/**
 * @Project: CodeSegment
 * @ClassName DateUtil
 * @description: 时间工具类
 * @author: leospiritlee
 * @create: 2020-03-19 22:23
 **/
public class DateUtil {


    public static void main(String[] args) {

        String epccDateTimeFormat = "yyyy-MM-dd'T'HH:mm:ss";
        String dateString = "2020-02-20T14:36:05";
        DateFormat dateFormat = new SimpleDateFormat(epccDateTimeFormat);
        try {
            System.out.println( dateFormat.parse(dateString));
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        ZoneId zoneId = ZoneId.systemDefault();
        LocalDateTime localDateTime = LocalDateTime.parse(dateString);
        ZonedDateTime zdt = localDateTime.atZone(zoneId);
        Date date = Date.from(zdt.toInstant());
        System.out.println(date);

    }




}
