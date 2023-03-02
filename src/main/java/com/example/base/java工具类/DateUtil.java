package com.example.base.java工具类;

import org.assertj.core.util.Lists;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class DateUtil {

    public static final String FORMAT_DEFAULT = "yyyy-MM-dd";

    public static final String FORMAT_ALL = "yyyy-MM-dd HH:mm:ss";

    public static final String FORMAT_ALL_L = "yyyy-MM-dd HH:mm";

    public static final String FORMAT_CHINESE = "yyyy年MM月dd日";

    public static final String FORMAT_ALL_M = "yyyy-MM-dd HH:mm:ss.SSS";

    public static final String FORMAT_SMALL = "yyyyMMddHHmmss";

    public static final String FORMAT_DEFAULT_SMALL = "yyyyMMdd";

    public static final String FORMAT_TIME = "HH:mm:ss";

    public static final String FORMAT_TIME_HOUR = "HH";

    public static final String FORMAT_TIME_MINUTE = "mm";

    public static final String FORMAT_TIME_SECOND = "ss";

    public static final String FORMAT_CHINESE_REMOVE_YEAR = "MM月dd日";

    public static final String FORMAT_CHINESE_REMOVE_YEAR_SHORT = "M月d日";

    public static final String FORMAT_ONLY_DAY = "dd日";

    public static final String FORMAT_SMALL_NOT_SECOND = "yyyyMMddHHmm";

    public static final String FORMAT_TIME_HOUR_MINUTE = "HH:mm";

    public static final String FORMAT_DATE_MONTH_DAY = "MM-dd";

    public static final String FORMAT_TWENTY_FOUR_TIME_HOUR_MINUTE = "kk:mm";

    public static final String FORMAT_ALL_HOUR = "yyyy-MM-dd HH";

    private static final DateTimeFormatter defaultDateFormatter = DateTimeFormatter.ofPattern("yyyyMMdd");

    private static final DateTimeFormatter defaultTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public DateUtil() {

    }

    public static long getUnixTime() {
        return System.currentTimeMillis() / 1000L;
    }

    public static long todayStart() {
        return LocalDateTime.now().withHour(0).truncatedTo(ChronoUnit.HOURS).atZone(ZoneId.systemDefault()).toInstant().getEpochSecond();
    }

    public static String getSomeDayString(String dayString, int days) {
        return LocalDate.parse(dayString, defaultDateFormatter).plusDays(days).format(defaultDateFormatter);
    }

    public static String getDateString(long unixtime) {
        return Instant.ofEpochSecond(unixtime).atZone(ZoneId.systemDefault()).format(defaultDateFormatter);
    }

    public static List<Date> getDays(String startTime, String endTime) {

        // 返回的日期集合
        List<Date> days = Lists.newArrayList();

        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date start = dateFormat.parse(startTime);
            Date end = dateFormat.parse(endTime);

            Calendar tempStart = Calendar.getInstance();
            tempStart.setTime(start);

            Calendar tempEnd = Calendar.getInstance();
            tempEnd.setTime(end);
            tempEnd.add(Calendar.DATE, +1);// 日期加1(包含结束)
            while (tempStart.before(tempEnd)) {
                days.add(tempStart.getTime());
                tempStart.add(Calendar.DAY_OF_YEAR, 1);
            }

        } catch (ParseException e) {
            e.printStackTrace();
        }

        return days;
    }

    public static String getDateString(long unixtime, String format) {
        return Instant.ofEpochSecond(unixtime).atZone(ZoneId.systemDefault()).format(DateTimeFormatter.ofPattern(format));
    }

    public static void main(String[] args) {
        // long todayStart = todayStart();
        // System.out.println(todayStart);
        // System.out.println(getSomeDayString(getDateString(System.currentTimeMillis() / 1000), -2));

        // List<Date> days = getDays("2018-06-28", "2018-07-3");
        // SimpleDateFormat format = new SimpleDateFormat("M月d日");
        // SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        // for (Date date : days) {
        //     System.out.println(format.format(date));
        //     System.out.println(dateFormat.format(date));
        // }
        // System.out.println(days);
        // Long ss = 1630491921000L;
        // System.out.println(getDateString(ss / 1000, DateUtil.FORMAT_CHINESE));
        // String currentDay = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyyMMdd"));
        // System.out.println(currentDay);
        //
        //
        //
        // String awakenDate = DateUtil.getDateString(System.currentTimeMillis() / 1000, DateUtil.FORMAT_CHINESE_REMOVE_YEAR_SHORT);
        // System.out.println(awakenDate);

        // DecimalFormat decimalFormat= new DecimalFormat( "" );
        // String format1 = decimalFormat.format(10000000 / 10000 + "万");
        // int i = 110000001 / 10000;
        //
        // System.out.println(i);

        // System.out.println(subStr("我是一个好人人人人人人人", 0, 8, "…"));
        // String godPowerValueStr = "20.12345";
        // long godPowerValue = Long.parseLong(godPowerValueStr.split("\\.")[0]);
        // System.out.println(godPowerValue);

        // String dateString = DateUtil.getDateString(System.currentTimeMillis() / 1000, "MM月dd日HH时mm分");
        // System.out.println(dateString);

        // double parseDouble = Double.parseDouble("10000000.12345");
        // System.out.println(parseDouble);

        LocalDate yesterday = LocalDate.now().plusDays(-1);
        String date = yesterday.format(DateTimeFormatter.ofPattern("yyyyMMdd"));
        System.out.println(date);

        long longValue = BigDecimal.valueOf(8.0E+10).longValue();
        System.out.println(longValue);

        double doubleValue = BigDecimal.valueOf(8.0E+10).doubleValue();
        System.out.println(doubleValue);

        long l = BigDecimal.valueOf(8.0E+10).longValueExact();
        System.out.println(l);

    }

    public static String subStr(String source, int start, int end, String more) {
        if (source == null) {
            return "";
        }
        if(source.codePoints().count() <= end){
            return source;
        }
        String result;
        try {
            result = source.substring(source.offsetByCodePoints(0, start),
                    source.offsetByCodePoints(0, end));
        } catch (Exception e) {
            result = "";
        }
        return result + more;
    }


}
