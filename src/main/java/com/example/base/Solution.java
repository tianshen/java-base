package com.example.base;

public class Solution {

    public static void main(String[] args) {

        int[] array = new int[]{1, 1, 2, 2, 3, 3, 3, 5, 5, 5, 6, 8, 8, 9};
        int index = binarySearchDemo(array, 5);
        System.out.println(index);
        int index2 = binarySearchDemo2(array, 5);
        System.out.println(index2);
        int index3 = binarySearchDemo3(array, 5);
        System.out.println(index3);
        int index4 = binarySearch4(array, 5);
        System.out.println(index4);
    }

    /**
     * 查找第一个等于给定值的元素的下标
     *
     * @param array
     * @param value
     * @return
     */
    public static int binarySearchDemo(int[] array, int value) {
        if (array.length == 0) {
            return -1;
        }

        int low = 0;
        int high = array.length - 1;
        int mid;

        while (true) {
            mid = (low + high) / 2;
            if (low > high) {
                return -1;
            } else if (array[mid] == value) {
                if (mid != 0 && array[mid] != array[mid - 1]) {
                    return mid;
                } else {
                    high = mid - 1;
                }
            } else if (array[mid] > value) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
    }

    /**
     * 查找最后一个等于给定值的元素的下标
     *
     * @param array
     * @param value
     * @return
     */
    public static int binarySearchDemo2(int[] array, int value) {
        if (array.length == 0) {
            return -1;
        }

        int low = 0;
        int high = array.length - 1;
        int mid;

        while (true) {
            mid = (low + high) / 2;
            if (low > high) {
                return -1;
            } else if (array[mid] == value) {
                if (mid != 0 && array[mid] != array[mid + 1]) {
                    return mid;
                } else {
                    low = mid + 1;
                }
            } else if (array[mid] > value) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
    }


    /**
     * 查找第一个大于给定值的元素的下标
     *
     * @param array
     * @param value
     * @return
     */
    public static int binarySearchDemo3(int[] array, int value) {
        if (array.length == 0) {
            return -1;
        }

        int low = 0;
        int high = array.length - 1;
        int mid;

        while (true) {
            mid = (low + high) / 2;
            if (low > high) {
                return -1;
            } else if (array[mid] == value) {
                if (mid != 0 && array[mid] != array[mid + 1]) {
                    return mid + 1;
                } else {
                    low = mid + 1;
                }
            } else if (array[mid] > value) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
    }



    public static int binarySearch4(int[] nums, int target) {
        if (nums == null) {
            return -1;
        }
        int start = 0;
        int end = nums.length - 1;

        // 判断第一个是否大于等于 target，如果满足，直接返回
        if (nums[start] >= target) {
            return start;
        }
        if(nums[end] < target){
            return -1;
        }
        while (start <= end) {
            int mid = start + (((end - start)) >> 1);
            if (nums[mid] == target) {
                // 需要判断前一位是否也大于等于 target,不满足 直接返回
                if (nums[mid - 1] != target) {
                    return mid;
                }
                // nums[mid + 1] == target
                end = mid - 1;
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        if (end < start && nums[end] < target && nums[start] > target) {
            return start;
        }
        return -1;
    }

}
