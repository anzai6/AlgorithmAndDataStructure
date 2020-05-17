package com.leetcode.anzai.subject_21_40;

/**
 * 搜索旋转排序数组
 * https://leetcode-cn.com/problems/search-in-rotated-sorted-array/
 */
public class Subject33 {

    /**
     *
     假设按照升序排序的数组在预先未知的某个点上进行了旋转。

     ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。

     搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。

     你可以假设数组中不存在重复的元素。

     你的算法时间复杂度必须是 O(log n) 级别。

     示例 1:

     输入: nums = [4,5,6,7,0,1,2], target = 0
     输出: 4
     示例 2:

     输入: nums = [4,5,6,7,0,1,2], target = 3
     输出: -1
     *
     */

    /**
     * 初始思路：利用二分搜索找到最大值，将数组分成两个区间，然后再用二分搜索找target
     *
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0)
            return -1;
        int maxIndex = getMaxIndex(nums); // 找出数组中的最大值下标
        int low;
        int high;
        if (target > nums[0]) { // target 在大区间
            low = 1;
            high = maxIndex;
        } else if (target < nums[0]) { // target 在小区间
            low = maxIndex + 1;
            high = nums.length - 1;
        } else {
            return 0;
        }

        int center;
        while (low <= high) {
            center = (low - high) / 2 + high;
            if (nums[center] > target) {
                high = center - 1;
            } else if (nums[center] < target) {
                low = center + 1;
            } else {
                return center;
            }
        }
        return -1;
    }


    /**
     * 返回数组中最大值下标
     *
     * @param nums
     * @return
     */
    private int getMaxIndex(int[] nums) {
        int low = 1;
        int high = nums.length - 1;
        int maxValue = nums[0];
        int maxIndex = 0;
        int center;
        while (low <= high) {
            center = (high - low) / 2 + low;
            if (nums[center] >= maxValue) {
                maxValue = nums[center];
                maxIndex = center;
                low = center + 1;
            } else {
                high = center - 1;
            }
        }
        return maxIndex;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{4, 5, 6, 7, 0, 1, 2};
        Subject33 subject = new Subject33();
        System.out.print(subject.search(nums, 3));
    }

}
