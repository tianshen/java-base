package com.example.base;

import cn.hutool.core.date.DateUtil;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.temporal.ChronoUnit;
import java.util.Date;

public class Testssssssss {

    public static void main(String[] args) {

//        Date utc = DateUtil.convertTimeZone(new Date(), ZoneId.of("UTC"));
//        System.out.println(utc);
//        LocalDateTime localDateTime = LocalDateTime.ofInstant(utc.toInstant(), ZoneId.systemDefault());
//        System.out.println(localDateTime);


        LocalDateTime localDateTime = LocalDateTime.now(ZoneOffset.UTC);
        System.out.println(localDateTime);

        Date date = Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
        System.out.println(date);

        localDateTime = localDateTime.truncatedTo(ChronoUnit.HOURS);
        System.out.println(localDateTime);

        long currentTime = System.currentTimeMillis();
        System.out.println(currentTime);

        long epochMilli = localDateTime.atZone(ZoneOffset.UTC).toInstant().toEpochMilli();
        System.out.println(epochMilli);


//        long l = System.currentTimeMillis();
//        System.out.println(l);
        // 将时间戳转换为localDateTime


    }


}
