package com.example.base.异常体系.TRY_CATCH_FINALLY;

import java.util.ArrayList;
import java.util.List;

/**
 * https://www.jianshu.com/p/49d2c3975c56
 * 总结：
 * 1、finally中的代码总会被执行。
 * 2、当try、catch中有return时，也会执行finally。return的时候，要注意返回值的类型，是否受到finally中代码的影响
 * 3、finally中有return时，会直接在finally中退出，导致try、catch中的return失效。
 * 4、try和catch中的return不可能同时执行。
 * 5、try或catch中的return会优先于函数最后的return执行
 */
public class Test {

    public static void main(String[] args) {
//        int result1 = testReturn1();
//        System.out.println("return:" + result1);
//        List<Integer> resultList = testReturn2();
//        System.out.println(resultList);
//        int result3 = testReturn3();
//        System.out.println("return:" + result3);
//        int result4 = testReturn4();
//        System.out.println("return:" + result4);
        int result5 = testReturn5();
        System.out.println("return:" + result5);
    }

    /**
     * try:2
     * finally:3
     * return:2
     *
     * @return
     */
    private static int testReturn1() {
        int i = 1;
        try {
            i++;
            System.out.println("try:" + i);
            return i;
        } catch (Exception e) {
            i++;
            System.out.println("catch:" + i);
        } finally {
            i++;
            System.out.println("finally:" + i);
        }
        return i;
    }

    /**
     * try:[1]
     * finally:[1, 3]
     * [1, 3]
     *
     * @return
     */
    private static List<Integer> testReturn2() {
        List<Integer> list = new ArrayList<>();
        try {
            list.add(1);
            System.out.println("try:" + list);
            return list;
        } catch (Exception e) {
            list.add(2);
            System.out.println("catch:" + list);
        } finally {
            list.add(3);
            System.out.println("finally:" + list);
        }
        return list;
    }


    /**
     * try:2
     * catch:3
     * finally:4
     * return:3
     *
     * @return
     */
    private static int testReturn3() {
        int i = 1;
        try {
            i++;
            System.out.println("try:" + i);
            int x = i / 0;
        } catch (Exception e) {
            i++;
            System.out.println("catch:" + i);
            return i;
        } finally {
            i++;
            System.out.println("finally:" + i);
        }
        return i;
    }

    /**
     * try:2
     * finally:3
     * return:3
     *
     * @return
     */
    private static int testReturn4() {
        int i = 1;
        try {
            i++;
            System.out.println("try:" + i);
            return i;
        } catch (Exception e) {
            i++;
            System.out.println("catch:" + i);
            return i;
        } finally {
            i++;
            System.out.println("finally:" + i);
            return i;
        }
    }


    /**
     * try: 2
     * catch:3
     * finally: 4
     * return: 5
     * @return
     */
    private static int testReturn5() {
        int i = 1;
        try {
            i++;
            System.out.println("try:" + i);
            int x = i / 0;
            System.out.println("reach");
            return i;
        } catch (Exception e) {
            i++;
            System.out.println("catch:" + i);
            return i;
        } finally {
            i++;
            System.out.println("finally:" + i);
            // return i;
        }
        // return 5;
    }


}
