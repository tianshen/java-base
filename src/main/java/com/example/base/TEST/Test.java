package com.example.base.TEST;

import com.google.common.collect.Lists;
import org.joda.time.DateTime;

import java.util.*;

public class Test {

    public static void main(String[] args) {

//        List<Person> personList = Lists.newArrayList();
//        personList.add(new Man());
//        personList.add(new Woman());
//
//        for (Person person : personList) {
//            if (person instanceof Person) {
//                System.out.println("yes");
//            }
//        }


        // Man man = new Man();
        // System.out.println(man instanceof Person);


        Man man1 = new Man();
        man1.setName("maomao");
        Man man2 = new Man();
        man2.setName("name");

        System.out.println(man1);
        System.out.println(man2);

        man2 = man1;
        System.out.println(man2);

        int rand = rand(2, 5);
        System.out.println(rand);
        System.out.println(getDayEndSec());
        System.out.println(getActivityRedPacketTime());
        System.out.println(getLastDayStr());
        System.out.println(makeRedPacket(400, 5));
    }


    private static int rand(int min, int max) {
        Random random = new Random();
        return random.nextInt(max) % (max - min + 1) + min;
    }

    public static int getDayEndSec() {
        Calendar todayEnd = Calendar.getInstance();
        todayEnd.set(Calendar.HOUR_OF_DAY, 23);
        todayEnd.set(Calendar.MINUTE, 59);
        todayEnd.set(Calendar.SECOND, 59);
        todayEnd.set(Calendar.MILLISECOND, 0);
        return (int) (todayEnd.getTime().getTime() / 1000);
    }

    public static int getActivityRedPacketTime() {
        Calendar c = Calendar.getInstance();
        int hour = 15, minute = 0, second = 0;
//        if (EnvUtils.isStageEnv()) {
//            hour = 23;
//        }
        c.set(Calendar.HOUR_OF_DAY, hour);
        c.set(Calendar.MINUTE, minute);
        c.set(Calendar.SECOND, second);
        c.set(Calendar.MILLISECOND, 0);
        return (int) (c.getTime().getTime() / 1000);
    }

    public static String getLastDayStr() {
        return (new DateTime()).minusDays(1).toString("yyyyMMdd");
    }

    public static List<Integer> makeRedPacket(int total, int num) {
        // 最小值
        int min = 1;
        // 最大值
        int max = total - 1;
        // 随机数
        Random random = new Random();

        // TreeSet底层实现是TreeMap  TreeMap底层实现
        Set<Integer> randomSet = new TreeSet<>();
        //随机生成num + 1个元素
        randomSet.add(0);
        while (randomSet.size() < num) {
            int s = random.nextInt(max) % (max - min + 1) + min;
            randomSet.add(s);
        }
        randomSet.add(total);

        List<Integer> redPackList = new ArrayList<>(num);
        List<Integer> randomList = new ArrayList<>(num);
        randomList.addAll(randomSet);

        for (int i = 1; i <= num; i++) {
            int val = randomList.get(i) - randomList.get(i - 1);
            redPackList.add(val);
        }

        return redPackList;
    }
}
