package com.leetcode.anzai.subject_81_100;

import java.util.Arrays;

/**
 * 合并两个有序数组
 * https://leetcode-cn.com/problems/merge-sorted-array/
 */
public class Subject88 {

    /**
     *
     给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。

     说明:

     初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
     你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
     示例:

     输入:
     nums1 = [1,2,3,0,0,0], m = 3
     nums2 = [2,5,6],       n = 3

     输出: [1,2,2,3,5,6]
     *
     */

    /**
     * 官方解法：很酷，原地且时间复杂度是O(m+n),跟我的方法2类似，只是改为从尾部开始排序，
     * 通常惯性思维是从小到大，如果逆向思维从大到小来排序就可以省略O(m)的空间了，机智.....
     *
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (nums1 == null || nums2 == null || nums1.length < m + n || nums2.length < n || n == 0) {
            return;
        }

        // 复制 nums1

        int index1 = m - 1; // nums1 需要排序的下标
        int index2 = n - 1; // nums2 需要排序的下标
        int index3 = m + n - 1; // nums1 排序好的下标
        while (index1 >= 0 && index2 >= 0) {
            int value1 = nums1[index1];
            int value2 = nums2[index2];
            if (value1 >= value2) {
                nums1[index3] = value1;
                index1--;
            } else {
                nums1[index3] = value2;
                index2--;
            }
            index3--;
        }

        while (index1 >= 0) {
            nums1[index3--] = nums1[index1--];
        }

        while (index2 >= 0) {
            nums1[index3--] = nums2[index2--];
        }
    }

    /**
     * 1.原地算法的话，将nums2加入到nums1尾部，利用插入排序原理从m+1开始插入排序nums1
     * 2.借助一个新数组，将nums1的元素复制出来，算法空间是O(m)
     * <p>
     * 这里用的是方法2
     *
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge1(int[] nums1, int m, int[] nums2, int n) {
        if (nums1 == null || nums2 == null || nums1.length < m + n || nums2.length < n || n == 0) {
            return;
        }

        // 复制 nums1
        int[] nums3 = new int[m];
        for (int i = 0; i < m; i++) {
            nums3[i] = nums1[i];
        }

        int index1 = 0; // nums1 下标
        int index2 = 0; // nums2 下标
        int index3 = 0; // nums3 下标
        while (index3 < m && index2 < n) {
            int value3 = nums3[index3];
            int value2 = nums2[index2];
            if (value3 <= value2) {
                nums1[index1] = value3;
                index3++;
            } else {
                nums1[index1] = value2;
                index2++;
            }
            index1++;
        }

        while (index3 < m) {
            nums1[index1++] = nums3[index3++];
        }

        while (index2 < n) {
            nums1[index1++] = nums2[index2++];
        }

    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 2, 3, 0, 0, 0};
        int[] nums2 = new int[]{2, 5, 6};
        Subject88 subject = new Subject88();
        subject.merge(nums1, 3, nums2, nums2.length);
        System.out.println(Arrays.toString(nums1));
    }

}
