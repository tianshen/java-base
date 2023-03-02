package com.example.base;

import org.joda.time.DateTime;

public class DateTest {

    public static void main(String[] args) {
        // DateTime current = new DateTime(1735574401000L);
        DateTime current = new DateTime();
        int weekOfYear = getWeekOfYear(current);
        System.out.println("week == " + weekOfYear);
        String superRoomWeeklyDevotedList = getSuperRoomWeeklyDevotedList("1111", weekOfYear, current);
        System.out.println("key == " + superRoomWeeklyDevotedList);
    }

    /**
     * 获取周  如果是周一获取上周
     * @param current
     * @return
     */
    public static int getWeekOfYear(DateTime current) {
        if (current.getDayOfWeek() == 1) {
            return current.minusDays(7).getWeekOfWeekyear();
        }
        return current.getWeekOfWeekyear();
    }

    /**
     * 通过周获取key
     * @param vid
     * @param weekOfYear
     * @param current
     * @return
     */
    public static String getSuperRoomWeeklyDevotedList(String vid, int weekOfYear, DateTime current) {
        String year = new DateTime(current).toString("yyyy");
        System.out.println("year1 == " + year);
        int dayOfYear = new DateTime(current).getDayOfYear();
        System.out.println("day == " + dayOfYear);
        // 31 代表第几天   10 代表第几周   这两个值自定义的一个范围的值
        if (dayOfYear < 31 && weekOfYear > 10) {
            year = String.valueOf(Integer.parseInt(year) - 1);
            System.out.println("year2 == " + year);
        }
        return String.format("super:room:devote:%s:week:%s:vid:%s", year, weekOfYear, vid);
    }

}
