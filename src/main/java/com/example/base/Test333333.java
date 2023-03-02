package com.example.base;

import com.google.common.collect.Lists;
import org.joda.time.DateTime;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

public class Test333333 {


    public static void main(String[] args) {



        // int weekYear = new DateTime().getWeekyear();
        // System.out.println();
        // int curWeek = new DateTime().getWeekOfWeekyear();
        // int preWeek = curWeek - 1;
        // if (curWeek == 1) {
        //     weekYear = weekYear - 1;
        //     preWeek = new DateTime().minusWeeks(1).getWeekOfWeekyear();
        // }
        //
        // System.out.println(weekYear);
        // System.out.println(preWeek);
        //
        // int dayOfYear = new DateTime(1672714850000L).getDayOfYear();
        // System.out.println(dayOfYear);
        //
        //
        // System.out.println(getYear());
        //
        //
        // System.out.println(getWeekOfYear1());
        //
        //
        // int i = new DateTime(1672628450000L).getWeekOfWeekyear() - 1;
        // System.out.println(i);
        //
        //
        // int dayOfYear1 = new DateTime().getDayOfYear();
        // System.out.println(dayOfYear1);


        // DateTime dateTime = new DateTime().plusDays(-1);
        // System.out.println(dateTime.toString("yyyyMMdd"));
        //
        //
        // // long currentTime = System.currentTimeMillis();
        // long currentTime = 1673193601000L;
        // long updateTime = 1672588801001L;
        // long diff = currentTime - updateTime;
        //
        // long day = diff / (24 * 60 * 60 * 1000);
        // System.out.println(day);
        //
        //
        // System.out.println(" ----------- ");
        // List<String> blackList = Lists.newArrayList("1", "2", "3");
        // List<String> hostList = Lists.newArrayList("1", "4", "5");
        // hostList.removeAll(blackList);
        // System.out.println(hostList);
        //
        //
        // double ceil = Math.ceil(346.34);
        // System.out.println(ceil);


        int weekOfYear1 = getWeekOfYear1();
        System.out.println(weekOfYear1);

        // double d = 123.86D;
        // long l = (long) d;
        // System.out.println(l);
        //
        //
        // List<String> list = Lists.newArrayList("");
        // System.out.println(CollectionUtils.isEmpty(list));

        int weekOfWeekyear = new DateTime().getWeekOfWeekyear();
        System.out.println(weekOfWeekyear);

    }



    public static String getYear () {
        String year = new DateTime().toString("yyyy");
        int dayOfYear = new DateTime().getDayOfYear();
        if (dayOfYear == 1 || dayOfYear == 2) {
            year = String.valueOf(Integer.parseInt(year) - 1);
        }
        return year;
    }



    public static int getWeekOfYear1() {

        DateTime current = new DateTime(1672621200000L);
        int dayOfWeek = current.getDayOfWeek();
        System.out.println(dayOfWeek);
        if (current.getDayOfWeek() == 1) {
            return current.minusDays(7).getWeekOfWeekyear();
        }

        return current.getWeekOfWeekyear();
    }
}
