package com.leetcode.anzai.subject_21_40;

/**
 * 在排序数组中查找元素的第一个和最后一个位置
 * https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 */
public class Subject34 {

    /**
     *
     给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。

     你的算法时间复杂度必须是?O(log n) 级别。

     如果数组中不存在目标值，返回?[-1, -1]。

     示例 1:

     输入: nums = [5,7,7,8,8,10], target = 8
     输出: [3,4]
     示例?2:

     输入: nums = [5,7,7,8,8,10], target = 6
     输出: [-1,-1]
     *
     */

    /**
     * 初始思路：利用二分搜索分别找到第一个和最后一个相等的值下标
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[]{-1, -1};
        if (nums == null || nums.length == 0)
            return result;
        result[0] = findFirstSame(nums, target);
        if (result[0] < 0)
            return result;
        result[1] = findLastSame(nums, target, result[0]);
        return result;
    }


    /**
     * 查找第一个相等的值
     *
     * @return
     */
    private int findFirstSame(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        int firstIndex = -1;
        int center;
        while (low <= high) {
            center = (high - low) / 2 + low;
            if (nums[center] < target) {
                low = center + 1;
            } else if (nums[center] > target) {
                high = center - 1;
            } else {
                firstIndex = center;
                high = center - 1;
            }
        }
        return firstIndex;
    }

    /**
     * 查找最后一个相等的值
     *
     * @return
     */
    private int findLastSame(int[] nums, int target, int low) {
        int high = nums.length - 1;
        int lastIndex = -1;
        int center;
        while (low <= high) {
            center = (high - low) / 2 + low;
            if (nums[center] < target) {
                low = center + 1;
            } else if (nums[center] > target) {
                high = center - 1;
            } else {
                lastIndex = center;
                low = center + 1;
            }
        }
        return lastIndex;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{5, 7, 7, 8, 8, 10};
        Subject34 subject = new Subject34();
        int[] result = subject.searchRange(nums, 10);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
    }

}
