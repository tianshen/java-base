package com.example.base.数据结构和算法.书籍.排序.简单排序;

/**
 * @author jiwei.xue
 * @date 2020/12/22 11:14
 * 插入排序的思想: 对数组进行局部排序
 *      从坐标为1的元素开始循环，和数组前面的元素进行比较一一进行比较，直到找到第一个比当前元素小的元素结束。
 * 插入排序的时间复杂夫为O()
 */
public class InsertSort {

    public static void main(String[] args) {

        long[] arr = new long[]{2, 4, 6, 1, 300, 97, 81};
        insertSort(arr);
        for (int j = 0; j < arr.length; j++) {
            System.out.println(arr[j] + " ");
        }
        System.out.println("");
    }

    /**
     * 插入排序
     * @param arr
     */
    public static void insertSort(long[] arr) {
        int out, in;
        for (out = 1; out < arr.length; out++) {
            long temp = arr[out];
            in = out;
            while (in > 0 && arr[in - 1] >= temp) {
                // 小的值要往前移动 所以把比他大的都往后移动一位
                arr[in] = arr[in - 1];
                --in;
            }
            // 最后给空出来的位置赋值这个小的坐标
            arr[in] = temp;
        }
    }

    public static void insertSort001(long[] arr) {
        int out, in;
        for (out = 1; out < arr.length; out++) {
            long temp = arr[out];
            in = out;
            while (in > 0 && arr[in - 1] >= temp) {
                arr[in] = arr[in - 1];
                in--;
            }
            arr[in] = temp;
        }
    }

    /**
     * 插入排序
     * @param arr
     */
    public static void insertSortRe(long[] arr) {
        int out, in;
        for (out = 1; out < arr.length; out++) {
            long temp = arr[out];
            in = out;
            while (in > 0 && arr[in - 1] >= temp) {
                arr[in] = arr[in - 1];
                --in;
            }
            arr[in] = temp;
        }
    }


    public static void insertSortRe01(long[] arr) {
        int out, in;
        for (out = 1; out < arr.length; out++) {
            long temp = arr[out];
            in = out;
            while (in > 0 && arr[in - 1] >= temp) {
                arr[in] = arr[in - 1];
            }
        }
    }

    /**
     * 这是错误的插入排序  本质上这种是冒泡排序
     * @param arr
     */
    public static void insertSortTest(long[] arr){
        //表示假设第一个有序，从第二个，下表为1的开始
        for (int i = 1; i < arr.length ; i++) {
            for (int j = i; j >0 ; j--) {
                if(arr[j]<arr[j-1]){
                    swap(arr, j, j - 1);

//                    long temp = arr[j];
//                    arr[j] = arr[j-1];
//                    arr[j-1] = temp;
                }
            }
        }

    }

    private static void swap(long[] arr, int one, int two) {
        long temp = arr[one];
        arr[one] = arr[two];
        arr[two] = temp;
    }

}
