package com.example.base;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.assertj.core.util.Sets;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test33333 {

    public static void main(String[] args) {

        // UserTest test1 = new UserTest();
        // test1.setAge(1);
        // test1.setName("1");
        //
        // UserTest test2 = new UserTest();
        // test2.setAge(2);
        // test2.setName("2");
        //
        // List<UserTest> list = Lists.newArrayList();
        // list.add(test1);
        // list.add(test2);
        // Map<String, UserTest> collect = list.stream().collect(Collectors.toMap(UserTest::getName, Function.identity()));
        // System.out.println(collect);

        // UserTestTest userTestTest = new UserTestTest();
        // userTestTest.setUserTest(test1);
        // System.out.println(userTestTest);

        // Map<String, UserTest> userTestMap = Maps.newHashMap();
        // UserTest test1 = new UserTest();
        // test1.setAge(1);
        // userTestMap.put("1", test1);
        //
        // for (Map.Entry<String, UserTest> entry : userTestMap.entrySet()) {
        //     String key = entry.getKey();
        //     UserTest userTest = entry.getValue();
        //     userTest.setName("1");
        // }
        // System.out.println(userTestMap);

        List<UserTest> userTestList = Lists.newArrayList();
        UserTest test = new UserTest();
        test.setAge(10);
        test.setValue(20);
        userTestList.add(test);
        UserTest test2 = new UserTest();
        test2.setAge(10);
        test2.setValue(30);
        userTestList.add(test2);

        List<UserTest> collect = userTestList.stream().sorted(Comparator.comparing(UserTest::getAge,Comparator.reverseOrder()).thenComparing(UserTest::getValue,Comparator.reverseOrder())).collect(Collectors.toList());//先以属性一降序,再进行属性二降序
        // List<UserTest> collect = userTestList.stream().sorted(Comparator.comparing(UserTest::getAge).reversed()).collect(Collectors.toList());
        System.out.println(collect);

        // Map<String, UserTest> map1 = Maps.newHashMap();
        // UserTest userTest = new UserTest();
        // userTest.setName("11");
        // userTest.setAge(11);
        // map1.put("seat1", userTest);
        //
        // UserTest userTest2 = new UserTest();
        // userTest2.setName("22");
        // userTest2.setAge(22);
        // map1.put("seat2", userTest2);
        //
        // Map<String, UserTest> map2 = Maps.newHashMap();
        // UserTest userTest3 = new UserTest();
        // userTest3.setValue(33);
        // map2.put("seat1", userTest3);
        //
        // UserTest userTest4 = new UserTest();
        // userTest4.setValue(44);
        // map2.put("seat2", userTest4);
        //
        // List<UserTest> userTestList = Lists.newArrayList();
        // for (Map.Entry<String, UserTest> entry : map1.entrySet()) {
        //
        //     UserTest user = entry.getValue();
        //     UserTest user2 = map2.get(entry.getKey());
        //     user.setValue(user2.getValue());
        //     userTestList.add(user);
        //
        // }
        // System.out.println(userTestList);

        // List<String> arrayList = Lists.newArrayList();
        // arrayList.add("1");
        // arrayList.add("2");
        // arrayList.add("3");
        // arrayList.add("4");
        //
        // List<String> newList = new ArrayList<>();
        // newList = arrayList;
        // newList.remove(0);
        // System.out.println(arrayList);
        // System.out.println(newList);
        //
        //
        // UserTest userTest = new UserTest();
        // userTest.setName("毛毛");
        // System.out.println(userTest.getName());
        //
        // long expireTime = System.currentTimeMillis() + (3 * 60 * 1000);
        // System.out.println(expireTime);
        Set<Long> set = Sets.newHashSet();
        set.add(0L);
        set.add(50000L);
        set.add(100000L);
        set.add(200000L);
        long loveValue = 100000L;
        Long aLong = set.stream().filter(score -> score <= loveValue).min((i1, i2) -> (int) (i2 - i1)).orElse(0L);
        System.out.println(aLong);


    }
}
