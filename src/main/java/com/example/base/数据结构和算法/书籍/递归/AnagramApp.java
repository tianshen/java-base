package com.example.base.数据结构和算法.书籍.递归;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 没看懂 变位数
 */
public class AnagramApp {

    static int size;
    static int count;
    static char[] arrChar = new char[100];

    public static void doAnagram(int newSize) {
        if (newSize == 1) {
            return;
        }
        for (int i = 0; i < newSize; i++) {
            doAnagram(newSize - 1);
            if (newSize == 2) {
                displayWord();
            }
            rotate(newSize);
        }
    }

    public static void rotate(int newSize) {
        int i;
        int position = size - newSize;
        char temp = arrChar[position];
        for (i = position + 1; i < size; i++) {
            arrChar[i - 1] = arrChar[i];
        }
        arrChar[i - 1] = temp;
    }

    public static void displayWord() {
        if (count < 99) {
            System.out.print(" ");
        } else if (count < 9) {
            System.out.print(" ");
        }
        System.out.print(++count + " ");
        for (int i = 0; i < size; i++) {
            System.out.print(arrChar[i]);
        }
        System.out.print("  ");
        System.out.flush();
        if (count % 6 == 0) {
            System.out.println("");
        }
    }

    private static String getString() throws IOException {
        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        return bufferedReader.readLine();
    }

    public static void main(String[] args) throws IOException {

        System.out.println("Enter a word:");
        String input = getString();
        size = input.length();
        count = 0;
        for (int i = 0; i < size; i++) {
            arrChar[i] = input.charAt(i);
        }
        doAnagram(size);
    }
}