package com.example.base;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Optional;

public class Test222 {

    public static void main(String[] args) {

        // System.out.println(todayStart() * 1000);
        // System.out.println(tomorrowStart() * 1000 - 1);
        // System.out.println(todayStart() * 1000 - (tomorrowStart() * 1000 - 1));
        //
        // String ss = "100000086399999";
        // String s = "-10000000000086399999";
        // BigDecimal bigDecimal = new BigDecimal(ss);
        // double v1 = bigDecimal.doubleValue();
        // double v = Double.parseDouble(ss);
        // long l = -999999999999999999L;
        //
        // System.out.println(v1);

        // try {
        //     Thread.sleep(5000);
        // } catch (InterruptedException e) {
        //     e.printStackTrace();
        // }
        //
        // System.out.println(getUnixTime());
        // System.out.println(todayStart() * 1000 - getUnixTime());
        // long incValue = 1111111111;
        long currentTime = getUnixTime();
        long endTime = tomorrowStart();
        long intervalTime = endTime - currentTime;
        String intervalTimeStr = String.format("%0" + 5 + "d", intervalTime);
        System.out.println(intervalTimeStr);

        // BigDecimal bigDecimal = new BigDecimal(incValue + "." + intervalTimeStr);
        // double doubleValue = bigDecimal.doubleValue();
        // System.out.println(doubleValue);
        //
        // double godPowerValue = Double.parseDouble(incValue + "." + intervalTimeStr);
        // System.out.println(godPowerValue);
        //
        // long longValue = BigDecimal.valueOf(godPowerValue).longValue();
        // System.out.println(longValue);
        //
        // double num = 12300000000.456; // 1.23000000456E8
        // //按照原样
        // String str = new BigDecimal(Double.toString(num)).toPlainString(); // 123000000.456
        // System.out.println(str);

        List<UserTest> userTestList = Lists.newArrayList();
        UserTest userTest = new UserTest();
        userTest.setName("1");
        userTest.setAge(1);
        userTest.setValue(1);
        UserTest userTest2 = new UserTest();
        userTest2.setName("1");
        userTest2.setAge(1);
        userTest2.setValue(1);
        userTestList.add(userTest2);
        System.out.println(userTestList);

        UserTest userTest1 = userTestList.get(0);
        userTest1.setName("3");
        userTest1.setAge(3);
        userTest1.setValue(3);
        // for (UserTest userTest1 : userTestList) {
        //     if (userTest1.getName().equals("1")) {
        //         userTest1.setName(userTest1.getName() + "2");
        //     }
        // }

        System.out.println(userTestList);


        List<String> strings = Arrays.asList("1", "2", "3", "4");
        boolean contains = !strings.contains("");
        System.out.println(contains);
        Map<String, String> originMap = Maps.newHashMap();
        originMap.put("topic", "0");
        int topic = Integer.parseInt(Optional.ofNullable(originMap.get("topic")).orElse("-1"));
        System.out.println(topic);

        int i = Integer.parseInt("01");
        System.out.println(i);


        String topic1 = "topic";
        boolean equals = topic1.equals(null);
        System.out.println("     " + equals);
        String momoid = "41";
        String substring = momoid.substring(momoid.length() - 2);
        System.out.println(substring);


        String totalAssert = "0总资产";
        String substring1 = totalAssert.substring(0, totalAssert.length() - 3);
        System.out.println(substring1);
    }

    public static long todayStart() {
        return LocalDateTime.now().withHour(0).truncatedTo(ChronoUnit.HOURS).atZone(ZoneId.systemDefault()).toInstant().getEpochSecond();
    }

    public static long getUnixTime() {
        return System.currentTimeMillis() / 1000;
    }

    /**
     * 明日0点 unixtime
     *
     * @return
     */
    public static long tomorrowStart() {
        return todayStart() + 86400;
    }
}
