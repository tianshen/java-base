package com.example.base;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class Base64Test {

    public static void main(String[] args) throws UnsupportedEncodingException {

        String name = "I̶'̶m̶ ̶…";
        String encodeName = Base64.getEncoder().encodeToString(name.getBytes(StandardCharsets.UTF_8));
        System.out.println(encodeName);

        byte[] decode = Base64.getDecoder().decode("8J+NkuWwj+iJuvCflYo=");
        String decodeName = new String(decode, StandardCharsets.UTF_8);
        System.out.println(decodeName);

    }
}
