package com.example.base;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.joda.time.DateTime;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.time.DayOfWeek;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class Test11 {
    public static void main(String[] args) throws InterruptedException {
        // LocalDate today = LocalDate.now();
        // System.out.println(today);
        // String toString = today.toString();
        // System.out.println(toString);
        // LocalDate parse = LocalDate.parse("2021-05-10");
        // System.out.println(parse);
        // System.out.println(today.isAfter(parse));
        //
        // LocalDate friday = LocalDate.now();
        // DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        // System.out.println(friday.format(formatter));
        //
        // String aa = "2021-05-10";
        // String replace = aa.replace("-", "");
        // System.out.println(replace);

        // double j = 0.1 / 2;
        // System.out.println(j);

        // LocalDate parse = LocalDate.parse("06/21");
        // System.out.println(parse);
        // Object aa = null;
        // String toString = (String) aa;
        // System.out.println(toString);
        // long toSeconds = TimeUnit.DAYS.toSeconds(2);
        // System.out.println(toSeconds);
        // List<String> list = Lists.newArrayList();
        // list.add("123");
        // list.add("789");
        // System.out.println(list);
        // List<String> list1 = Lists.newArrayList();
        // list1.add("123");
        // list1.add("234");
        // list1.add("345");
        // list.removeAll(list1);
        // System.out.println(list);

        // int i = 100 / 1000;
        // System.out.println(i);
        //
        // HashMap<Object, Object> objectObjectHashMap = Maps.newHashMap();
        // Object o = objectObjectHashMap.get(1);
        // System.out.println(o);

        // int i = 11 / 2 + 1;
        // System.out.println(i);
        //
        // String s = "你哈\r\n你好";
        // System.out.println(s);
        // Object[] objects = new Object[]{1, 2};
        // test(objects);
        // test();
        // String str = "abcdefg";
        // System.out.println("截取最后一个字符串生成的新字符串为: " + str.substring(str.length()-1));
        //
        // String yyyyMMdd = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyyMMdd"));
        // System.out.println(yyyyMMdd);
        //
        // int i = 3020 % 1000;
        // System.out.println(i);

        // TreeMap<Long, String> treeMap = new TreeMap<>();
        //
        // treeMap.put(0L, "0");
        // treeMap.put(100L, "100");
        // treeMap.put(200L, "200");
        //
        // treeMap.forEach((key, value) -> {
        //     System.out.println(key);
        // });
        //
        // System.out.println(treeMap.lowerKey(50L));
        // System.out.println(treeMap.higherKey(200L));
        //
        // System.out.println(treeMap.floorKey(30L));
        // System.out.println(treeMap.ceilingKey(50L));


        // String s = "1_2_3_4_5_6_7";
        // String[] split = s.split("_");
        // List<String> strings = Arrays.asList(split);
        // String s1 = strings.get(0);
        // System.out.println(s1);
        // List<String> strings1 = strings.subList(4, strings.size());
        // System.out.println(strings1);


        // long curValue = 200L;


        // BigDecimal bigDecimal = BigDecimal.valueOf(360);
        // BigDecimal bigDecimal1 = BigDecimal.valueOf(0.183);
        // BigDecimal multiply = bigDecimal.multiply(bigDecimal1);
        // long l1 = multiply.setScale(0, RoundingMode.DOWN).longValue();
        // System.out.println(l1);
        // System.out.println(multiply);
        //
        // double v = 360 * 0.35;
        // System.out.println(v);
        //
        // long l = (long) (360 * 0.35);
        // System.out.println(l);
        //
        // long l2 = System.currentTimeMillis() / 1000;
        // System.out.println(l2);
        //
        //
        // List<String> cityIds = Lists.newArrayList();
        // cityIds.add("1");
        // cityIds.add("1");
        // cityIds.add("2");
        // cityIds.add("3");
        // List<String> strings = cityIds.subList(0, 4);
        // System.out.println(strings);


        // String time = "10";
        // String substring = time.substring(3);
        // System.out.println(substring);

        // double d = 1.081640150525E12;
        // long d1 = (long) d;
        // System.out.println(d1);

        // List<String> list = Lists.newArrayList();
        // list.add("3");
        // list.add("1");
        // list.add("2");
        // list.add("4");


        // list = list.stream().distinct().filter(id -> !id.isEmpty()).collect(Collectors.toList());
        // System.out.println(list);
        //
        // Map<String, Object> map = Maps.newHashMap();
        // map.put("state", 1);
        // map.put("time", 1636966129);
        //
        // int state = (int) map.get("state");
        // int time = (int) map.get("time");
        // long time1 = Long.parseLong(map.get("time").toString());
        // System.out.println(state);
        // System.out.println(time);
        // System.out.println(time1);
        //
        // String S = "123";
        // String substring = "";
        // if (S.length() > 4) {
        //     substring = S.substring(0, 4);
        // }
        // System.out.println(substring);


        // Long floorKey = treeMap.floorKey(curValue);
        // Long ceilingKey = treeMap.ceilingKey(curValue);
        //
        // Long lowerKey = treeMap.lowerKey(curValue);
        // Long higherKey = treeMap.higherKey(curValue);
        // System.out.println(floorKey);
        // System.out.println(ceilingKey);
        // System.out.println(lowerKey);
        // System.out.println(higherKey);

        // int i = 3 % 2;
        // System.out.println(i);
        //
        // int i1 = 205 / 5000;
        // System.out.println(i1);

        // DecimalFormat decimalFormat = new DecimalFormat("0.00");
        // String progressRate = decimalFormat.format((double) 1000 / 5000);
        // System.out.println(progressRate);

        // DecimalFormat decimalFormat = new DecimalFormat("0.00");
        // decimalFormat.setRoundingMode(RoundingMode.DOWN);
        // String curSeasonWinRate = decimalFormat.format(((double) 3.141567) * 100) + "%";
        // System.out.println(curSeasonWinRate);

        // Object[] objects = {"", "", 1};
        // for (Object o : objects) {
        //     System.out.println(o);
        // }




        // String s = "123456789";
        // String substring = s.substring(s.length() - 1);
        // System.out.println(substring);

        // DecimalFormat decimalFormat = new DecimalFormat("0.00");
        // String format = decimalFormat.format((double) 39 / 100);
        // System.out.println(format);

        // DecimalFormat decimalFormat = new DecimalFormat("0.00");
        // String progressRate = decimalFormat.format((double) 90  / 200);
        // System.out.println(progressRate);

        // int parseInt = Integer.parseInt(null);
        // System.out.println(parseInt);

        // List<String> list = Lists.newArrayList();
        // list.add("1");
        // System.out.println(list.get(1));

        // int i = 3 / 5;
        // int i1 = 3 % 5;
        // System.out.println(i);
        // System.out.println(i1);

        // if ( 1 == 1) {
        //     System.out.println(1);
        // } else if ( 2 == 2) {
        //     System.out.println(2);
        // }


        // int i = 0;
        // int j = 1;
        // double rate = i / j;

        // String ss = "148377877_254308389_1345_1638959885263";
        // String[] s = ss.split("_");
        // System.out.println(s[0]);
        // double startTime = 0.0;
        // long longValue = BigDecimal.valueOf(startTime).longValue();
        // System.out.println(longValue);

        // List<String> list = Lists.newArrayList();
        // list.add("1");
        // list.add("2");
        // list.add("3");
        // String remove = list.remove(0);
        // System.out.println(remove);
        // System.out.println(list);

        // int weekOfYear = getWeekOfYear();
        // System.out.println(weekOfYear);
        // String yyyy1 = new DateTime(1641019205000L).toString("yyyy");
        // System.out.println(yyyy1);
        // String  yyyy = new DateTime(1641019205000L).withDayOfWeek(1).toString("yyyy");
        // System.out.println(yyyy);

        // int size = 56;
        // int index = 21;
        // int remain = 56 - 21;
        //
        // int j = 40 / 20;
        // System.out.println(j);
        //
        //
        // int i = 30 % 20;
        // System.out.println(i);


        // List<String> list = Lists.newArrayList();
        // list.add("3");
        // list.add("2");
        // list.add("3");
        // list.add("4");
        // list.add("5");
        // list.add("6");
        // list.add("7");
        // list.add("8");


        // List<String> list1 = Lists.newArrayList();
        // list1.add("3");
        // list1.add("4");
        // list1.add("5");
        // list1.add("6");
        // list1.add("7");
        // list1.add("8");
        //
        // list.removeAll(list1);
        // System.out.println(list);

        // double parseDouble = Double.parseDouble("-1");
        // System.out.println(parseDouble);

        // String s = "1234";
        // String substring = s.substring(0, 4);
        // System.out.println(substring);


        // String interval = "";
        // long fire = 13000;
        // if (fire > 0 && fire <= 10000) {
        //     interval = "1";
        // } else if (fire > 10000 && fire <= 20000) {
        //     interval = "2";
        // } else if (fire > 20000 && fire <= 30000) {
        //     interval = "3";
        // }
        // System.out.println(interval);



        // Map<String, Object> map = Maps.newHashMap();
        // map.put("quitGameTypeEnum", QuitGameTypeEnum.KICK_QUIT_GAME);
        //
        // QuitGameTypeEnum gameTypeEnum = (QuitGameTypeEnum) map.get("quitGameTypeEnum");
        // String gameTypeEnumStr = gameTypeEnum.toString();
        // System.out.println(gameTypeEnumStr);
        // if (QuitGameTypeEnum.KICK_QUIT_GAME == gameTypeEnum) {
        //     System.out.println(gameTypeEnum);
        //     System.out.println("success");
        // }

        // LocalDate now = LocalDate.now();
        // String currentDay = now.format(DateTimeFormatter.ofPattern("yyyyMMdd"));
        // System.out.println(currentDay);
        // LocalDate localDate = now.plusDays(1L);
        // System.out.println(localDate);


        // List<String> dateList = Lists.newArrayList();
        // dateList.add("20220502");
        // dateList.add("20220429");
        // dateList.add("20220428");
        // dateList.add("20220501");
        // dateList.add("20220427");
        // dateList.add("20220503");
        // // List<Integer> sortDateList = dateList.stream().map(Integer::parseInt).sorted(Integer::compareTo).collect(Collectors.toList());
        // List<String> sortDateList = dateList.stream().sorted(Comparator.comparingInt(Integer::parseInt)).collect(Collectors.toList());
        // System.out.println(sortDateList);
        // DateTimeFormatter yyyyMMdd = DateTimeFormatter.ofPattern("yyyyMMdd");
        // // LocalDate now = LocalDate.now();
        // LocalDate date
        //         = LocalDate.parse("2022-05-09");
        //
        // LocalDate localDate = date.minusDays(7);
        // String format = localDate.format(yyyyMMdd);
        // System.out.println(format);
        // String momoid = "419347188";
        // String substring = momoid.substring(momoid.length() - 1);
        // System.out.println(substring);
        // Double value = 100.0;
        // long longValue = value.longValue();
        // System.out.println(longValue);

        // long currentTime = System.currentTimeMillis();
        // LocalDate localDate = Instant.ofEpochMilli(currentTime).atZone(ZoneOffset.ofHours(8)).toLocalDate();
        // LocalDateTime localDateTime = Instant.ofEpochMilli(currentTime).atZone(ZoneOffset.ofHours(8)).toLocalDateTime();
        // System.out.println(localDate);
        // System.out.println(localDateTime);

        // int i = 500 / 5000;
        // System.out.println(i);
        //
        //
        // int i1 = 5 / 10;

        // int rank = 1;
        // for (int i = 0; i < 10; i++) {
        //     System.out.println(++rank);
        // }

        // List<String> list = Lists.newArrayList();
        // list.add("1");
        // list.add("2");
        // list.add("3");
        // list.add("4");
        // int index = list.indexOf("5");
        // System.out.println(index);
        //
        // String yyyy = new DateTime().withDayOfWeek(1).toString("yyyy");
        // System.out.println(yyyy);
        // int i = new DateTime().getWeekOfWeekyear() - 1;
        // System.out.println(i);


        // List<String> list1 = Lists.newArrayList();
        // list1.add("3");
        // // List<String> list2 = Lists.newArrayList();
        // list1.add("1");
        // list1.add("2");
        // Collections.shuffle(list1);
        // String s = list1.stream().findAny().orElse("");
        // System.out.println(s);
        //
        // int i = 0 / 1000;
        // System.out.println(i);
        //
        //
        // // list1.removeAll(list2);
        // // System.out.println(list1);
        //
        // TreeMap<String, String> treeMap = Maps.newTreeMap();
        // treeMap.put("a", "1");
        // treeMap.put("c", "3");
        // treeMap.put("b", "2");
        // System.out.println(treeMap);

        // double doubleValue = BigDecimal.valueOf(Math.pow(99, 1.05)).setScale(0, RoundingMode.HALF_DOWN).doubleValue();
        // // double pow = Math.pow(99, 1.05);
        // System.out.println(doubleValue);
        //
        // Map<String, String> testMap = Maps.newHashMap();
        // String test = null;
        // testMap.put("1", test);
        // System.out.println(testMap);

        // int hourOfDay = new DateTime().getHourOfDay();
        // System.out.println(hourOfDay);
        // BigDecimal activityNum = new BigDecimal(10000);
        // int compareTo = activityNum.compareTo(new BigDecimal(10000));
        // System.out.println(compareTo);
        String bannerImg = "https://img.momocdn.com/banner/A3/D6/A3D6F525-49BB-C8B7-1073-6F5C6E3E6EC820221115_L.jpg";
        int feedimage = bannerImg.indexOf("feedimage");
        System.out.println(feedimage);
        String guid = "A3D6F525-49BB-C8B7-1073-6F5C6E3E6EC820221115";
        // String substring1 = guid.substring(0, 2);
        // System.out.println(substring1);
        // String substring = guid.substring(2, 2);
        // System.out.println(substring);
        String format = String.format("%s/feedimage/%s/%s/%s_L.jpg", "http://img.momocdn.com", guid.substring(0, 2), guid.substring(2, 2), guid);
        System.out.println(format);

        // String url = "https://img.momocdn.com/banner/A3/D6/A3D6F525-49BB-C8B7-1073-6F5C6E3E6EC820221115_L.jpg";
        // String guidByUrl = getGUIDByUrl(url);
        // System.out.println(guidByUrl);
        String urlNew = "http://img.momocdn.com/feedimage/46//4683D154-E30C-999A-BDFD-61AEC624217220221115_L.jpg";
        String replaceAll = urlNew.replaceAll("_[S\\.|L\\.]\\.[jpg|webp]*$", "_L.webp");
        System.out.println(replaceAll);

        String url1 = "https://img.momocdn.com/banner/63/93/6393CF0A-C597-F413-A165-9AA96423733320221115_L.jpg";
        String replace = url1.replace("_S", "_L");
        System.out.println("====" + replace);

        String ss = " A3D6F525-49BB-C8B7-1073-6F5C6E3E6EC820221115  ";
        System.out.println(ss);
        String trim = ss.trim();
        System.out.println(trim);


        // String test = "111";
        // setString(test);
        // System.out.println(test);
        //
        // int week = new DateTime().getWeekOfWeekyear();
        // System.out.println(week);
        //
        // int weekOfYear = getWeekOfYear();
        // System.out.println(weekOfYear);
        //
        //
        // // System.out.println(new DateTime().getYear());
        // // System.out.println(new DateTime().getWeekOfWeekyear());
        // // System.out.println(new DateTime().getDayOfWeek());
        // // System.out.println(new DateTime().getWeekyear());
        // // System.out.println(new DateTime().get);


        // System.out.println("---------------------");
        // int weekYear = new DateTime(1672588800000L).getWeekyear();
        // System.out.println(weekYear);
        // int curWeek = new DateTime(1672588800000L).getWeekOfWeekyear();
        // System.out.println(curWeek);
        // int preWeek = curWeek - 1;
        // System.out.println(preWeek);
        // if (curWeek == 1) {
        //     weekYear = weekYear - 1;
        //     preWeek = new DateTime(1672588800000L).minusWeeks(1).getWeekOfWeekyear();
        // }
        // System.out.println(weekYear);
        // System.out.println(preWeek);


        // System.out.println("=======");
        // List<String> result = Lists.newArrayList("45");
        // List<String> carEffectList = Lists.newArrayList("41", "42", "43", "44", "45");
        // List<Integer> myEffectIdList = result.stream().filter(effectId -> !carEffectList.contains(effectId)).map(Integer::parseInt).collect(Collectors.toList());
        // System.out.println(myEffectIdList);


        System.out.println("======");
        Integer currentEffetId = 45;
        List<Integer> carEffectIdList = Lists.newArrayList(41, 42, 43, 44, 45);
        if (carEffectIdList.contains(currentEffetId)) {
            currentEffetId = 0;
        }
        System.out.println(currentEffetId);


        int weekOfWeekyear = new DateTime().getWeekOfWeekyear();
        System.out.println(weekOfWeekyear);


        String yyyy = new DateTime().withDayOfWeek(1).toString("yyyy");
        System.out.println(yyyy);

        // UserTest userTest = new UserTest();
        // userTest.setName("11");
        // userTest.setValue(11);
        //
        // UserTest userTest2 = new UserTest();
        // userTest2 = userTest;
        // System.out.println(userTest2);
        //
        //
        // System.out.println("=============================================");
        // int weekYear = new DateTime(1672588800000L).getWeekyear();
        // System.out.println(weekYear);
        // int curWeek = new DateTime().getWeekOfWeekyear();
        // System.out.println(curWeek);
        // int preWeek = curWeek - 1;
        // System.out.println(preWeek);
        // if (curWeek == 1) {
        //     weekYear = weekYear - 1;
        //     System.out.println(weekYear);
        //     preWeek = new DateTime(1672588800000L).minusWeeks(1).getWeekOfWeekyear();
        //     System.out.println(preWeek);
        // }
        //
        //
        //
        // List<String> list = Lists.newArrayList();
        //  // list.add("1");
        // int open = 0;
        //
        // System.out.println((open == 0 && !list.contains("1")));

        String yyyyMM = DateTime.now().toString("yyyyMM");
        System.out.println(yyyyMM);


        System.out.println("++++++++++++++++++++");
        System.out.println(formatCount(1));
        System.out.println(formatCount(999));
        System.out.println(formatCount(1000));
        System.out.println(formatCount(1001));
        System.out.println(formatCount(1000786));

        double d = 12722.43345d;
        System.out.println(formatCount((long) d));


        String yyyy1 = new DateTime(1672715030000L).withDayOfWeek(1).toString("yyyy");
        System.out.println(yyyy1);

        String yyyy2 = new DateTime(1672715030000L).toString("yyyy");
        System.out.println(yyyy2);

        int weekOfYear1 = getWeekOfYear1();
        System.out.println(weekOfYear1);

        int dayOfWeek = new DateTime(1672715030000L).getDayOfWeek();
        System.out.println(dayOfWeek);

        int weekOfWeekyear1 = new DateTime(1672715030000L).minusDays(7).getWeekOfWeekyear();
        System.out.println(weekOfWeekyear1);

        int weekOfWeekyear2 = new DateTime(1672715030000L).getWeekOfWeekyear();
        System.out.println(weekOfWeekyear2);


        int i = new DateTime(1672715030000L).getWeekOfWeekyear() - 1;
        System.out.println(i);







        String yyyy44444 = new DateTime(1672628630000L).withDayOfWeek(1).toString("yyyy");
        System.out.println(yyyy44444);


        int weekOfYear11 = getWeekOfYear1();
        System.out.println(weekOfYear11);

    }

    public static int getWeekOfYear1() {

        DateTime current = new DateTime(1672714970000L);

        if (current.getDayOfWeek() == 1) {
            return current.minusDays(7).getWeekOfWeekyear();
        }

        return current.getWeekOfWeekyear();
    }

    public static String formatCount(long count) {
        if (count < 1000) {
            return count + "m";
        } else {
            // float fc = count / 1000;
            return String.format("%d", count / 1000) + "km";
        }
    }


    public static void setString(String str) {
        str = "sss";
        if (str.equals("sss")) {
            return;
        }
        System.out.println(str);
    }

    public static String getGUIDByUrl(String url) {
        String[] segment = url.split("/")[6].split("_");
        if (!segment[0].contains(".")) {
            return segment[0];
        }
        String[] newSegment = segment[0].split(".");
        return newSegment[0];
    }

    public static int getWeekOfYear() {

        DateTime current = new DateTime(1672588800000L);
        // System.out.println(current.getDayOfWeek());
        // System.out.println(current.minusDays(1));
        // System.out.println(current.minusDays(2));
        // System.out.println(current.minusDays(3));
        // System.out.println(current.minusDays(4));
        // System.out.println(current.minusDays(5));
        // System.out.println(current.minusDays(6));
        // System.out.println(current.minusDays(7));
        // System.out.println(current.minusDays(7).getWeekOfWeekyear());
        System.out.println(current.getWeekOfWeekyear());
        if (current.getWeekOfWeekyear() == 1) {
            return current.minusWeeks(1).getWeekOfWeekyear();
        }

        return current.getWeekOfWeekyear();
    }

    public static void test() throws InterruptedException {
        // ArrayList<Object> list = Lists.newArrayList(args);
        // System.out.println(list.get(0));
        // System.out.println(list.get(1));
        // List<String> list1 = Lists.newArrayList();
        // list1.add("1");
        // list1.add("2");
        // List<String> list2 = Lists.newArrayList();
        // list2.add("2");
        // list1.removeAll(list2);
        // System.out.println(list1);
        // int i = list1.indexOf("1");
        // System.out.println(i);

        // double charmValue = 100008.0;
        // double v = charmValue / 10000;
        // DecimalFormat decimalFormat= new DecimalFormat( ".0" );
        // System.out.println(decimalFormat.format(v));
        //
        // long time = 1628764247;
        // boolean b = time > System.currentTimeMillis() / 1000;
        // System.out.println(b);

        // long points = 9199999;
        // long updateTime = System.currentTimeMillis() / 1000;
        // System.out.println(updateTime);
        // System.out.println((long) Math.log10(updateTime));
        // System.out.println(Math.pow(10, (int) Math.log10(updateTime) + 1));
        // System.out.println(new BigDecimal(Math.pow(10, (int) Math.log10(updateTime) + 1)).toPlainString());
        // System.out.println(updateTime / Math.pow(10, (int) Math.log10(updateTime) + 1));
        // double timeRank = points + 1 - updateTime / Math.pow(10, (int) Math.log10(updateTime) + 1);
        // System.out.println(timeRank);
        //
        //
        // Thread.sleep(1000);
        // updateTime = System.currentTimeMillis() / 1000;
        // System.out.println(updateTime);
        // timeRank = points + 1 - updateTime / Math.pow(10, (long) Math.log10(updateTime) + 1);
        // System.out.println(timeRank);
        // Thread.sleep(1000);
        // points = 88888;
        // updateTime = System.currentTimeMillis() / 1000;
        // timeRank = points + 1 - updateTime / Math.pow(10, (long) Math.log10(updateTime) + 1);
        // System.out.println(timeRank);




        // long time = 86319;
        // System.out.println((int) Math.log10(time));
        // System.out.println((int) Math.log10(time) + 1);
        // System.out.println(Math.pow(10, (int) Math.log10(time) + 1));
        // System.out.println(time / Math.pow(10, (int) Math.log10(time) + 1));
        // System.out.println(time);
        // long points = 919999999999L;
        // String s = String.valueOf(points) + String.valueOf(time);
        // System.out.println(s);
        // long v = Long.parseLong(s);
        // System.out.println(v);
        // // double timeRank = points + 1 - time / Math.pow(10, (int) Math.log10(time) + 1);
        // // System.out.println(timeRank);


        // String intervalTimeStr = String.format("%0" + 5 + "d", 319);
        // System.out.println(intervalTimeStr);
        // String score = 999999999 + "." + intervalTimeStr;
        // System.out.println(score);
        // long incValue = 100;
        //
        // double godPowerValue = Long.parseLong(incValue + "." + intervalTimeStr);
        // System.out.println(godPowerValue);
        //
        // String[] split = score.split("\\.");
        // String s0 = split[0];
        // String s1 = split[1];
        // System.out.println(s0);
        // System.out.println(s1);

        // String substring = score.substring(score.length() - 5);
        // System.out.println(substring);
        // String substring1 = score.substring(0, score.length() - 5);
        // System.out.println(substring1);
        //
        // Double d = 3333335284.23246;
        //
        // Double dd = 4.4010894146E10;\\\

        // Object o = false;
        // o =  (Boolean) o;
        // System.out.println(o);

    }
}

