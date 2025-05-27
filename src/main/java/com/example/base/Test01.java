package com.example.base;

public class Test01 {

    public int[] jiaoJI(int[] nums1, int[] nums2) {
        int i = 0;
        int j = 0;
        int length1 = nums1.length;
        int length2 = nums2.length;
        int resNum = 0;
        int[] res = new int[length1 + length2];
        while (i < length1 - 1 || j < length2 - 1) {
            if (nums1[i] > nums2[j]) {
                i++;
            } else if (nums1[i] < nums2[j]) {
                j++;
            } else {
                res[++resNum] = nums1[i];
                i++;
                j++;
            }
        }
        return res;
    }


}
