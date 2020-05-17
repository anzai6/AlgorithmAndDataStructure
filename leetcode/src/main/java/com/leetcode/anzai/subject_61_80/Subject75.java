package com.leetcode.anzai.subject_61_80;

import java.util.Arrays;

/**
 * 颜色分类
 * https://leetcode-cn.com/problems/sort-colors/
 */
public class Subject75 {

    /**
     *
     给定一个包含红色、白色和蓝色，一共  n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。

     此题中，我们使用整数 0、  1 和 2 分别表示红色、白色和蓝色。

     注意:
     不能使用代码库中的排序函数来解决这道题。

     示例:

     输入: [2,0,2,1,1,0]
     输出: [0,0,1,1,2,2]
     进阶：

     一个直观的解决方案是使用计数排序的两趟扫描算法。
     首先，迭代计算出0、1 和 2 元素的个数，然后按照0、1、2的排序，重写当前数组。
     你能想出一个仅使用常数空间的一趟扫描算法吗？
     *
     */

    /**
     * 桶排序，计数排序，快速排序
     * 初步想法：头尾双指针
     *
     * @param nums
     */
    public void sortColors(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int zeroIndex = 0;
        int twoIndex = nums.length - 1;
        for (int i = 0; i <= twoIndex; ) {
            int value = nums[i];
            if (value == 0) {
                swap(nums, zeroIndex, i);
                ++zeroIndex;
                i++;
            } else if (value == 2) {
                // 先过滤尾部指针等于2的
                while (twoIndex >= 0 && nums[twoIndex] == 2) {
                    --twoIndex;
                }
                if (twoIndex <= i) {
                    break;
                }
                swap(nums, twoIndex, i);
                --twoIndex;
            } else {
                i++;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int item = nums[i];
        nums[i] = nums[j];
        nums[j] = item;
    }

    public static void main(String[] args) {
//        int[] nums = new int[]{1, 0, 2, 1, 1, 0, 0, 2, 1, 1, 1, 1, 2, 2, 0, 1};
//        int[] nums = new int[]{1, 2, 1,0};
//        int[] nums = new int[]{0, 2, 1, 2};
//        int[] nums = new int[]{1, 2, 0};
        int[] nums = new int[]{2};
        Subject75 subject = new Subject75();
        subject.sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }

}
