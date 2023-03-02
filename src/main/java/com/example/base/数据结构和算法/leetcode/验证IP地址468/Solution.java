package com.example.base.数据结构和算法.leetcode.验证IP地址468;

import java.net.Inet6Address;
import java.net.InetAddress;

public class Solution {

    public static void main(String[] args) {

        System.out.println(validIPAddress("2001:0db8:85a3:0000:0000:8a2e:0370:7334"));
    }

    public static String validIPAddress (String IP) {

        try {
            InetAddress ip = InetAddress.getByName(IP);
            if (ip instanceof Inet6Address) {
                return "IPv6";
            } else {
                return "IPv4";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Neither";
    }
}
