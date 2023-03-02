package com.example.base.数据结构和算法.书籍.排序.高级排序;

public class BitMapSortApp02 {

    public static void main(String[] args) {
        int[] array = {6, 2, 8, 4, 33, 23, 99, 9};
        bitMapSort(array);
        for (int j = 0; j < array.length; j++) {
            System.out.println(array[j] + " ");
        }
        System.out.println("");
    }

    /**
     * 利用BitMap进行排序;
     *
     * @param array
     */
    public static void bitMapSort(int[] array) {

        //开辟16个Byte;
        byte[] bs = new byte[16];
        for (int i = 0; i < array.length; i++) {
            //设置array[i]位为1;
            //得到Byte表中的位置;
            int pos = array[i] / 8;
            //设置位;
            int index = array[i] % 8;
            bs[pos] = (byte) (bs[pos] + (byte) (0x01 << (index)));
        }
        int count = 0;
        int num = 0;
        //遍历Byte表;
        //考虑设置数组对应位的值;
        for (int i = 0; i < bs.length; i++) {
            byte b = bs[i];
            for (int j = 0; j < 8; j++) {
                byte bi = (byte) (b & (0x01 << j));
                System.out.println(Integer.toBinaryString(b));
                System.out.println(Integer.toBinaryString(0x01 << j));
                System.out.println(Integer.toBinaryString(b & (0x01 << j)));
                if (bi != 0) {
                    num = i * 8 + j;
                    array[count] = num;
                    count++;
                }
            }
        }

    }
}
