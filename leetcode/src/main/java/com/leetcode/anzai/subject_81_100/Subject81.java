package com.leetcode.anzai.subject_81_100;

/**
 * 搜索旋转排序数组 II
 * https://leetcode-cn.com/problems/search-in-rotated-sorted-array-ii/
 */
public class Subject81 {

    /**
     *
     假设按照升序排序的数组在预先未知的某个点上进行了旋转。

     ( 例如，数组   [0,0,1,2,2,5,6]   可能变为   [2,5,6,0,0,1,2]   )。

     编写一个函数来判断给定的目标值是否存在于数组中。若存在返回   true，否则返回   false。

     示例   1:

     输入: nums = [2,5,6,0,0,1,2], target = 0
     输出: true
     示例   2:

     输入: nums = [2,5,6,0,0,1,2], target = 3
     输出: false
     进阶:

     这是 搜索旋转排序数组 的延伸题目，本题中的 nums 可能包含重复元素。
     这会影响到程序的时间复杂度吗？会有怎样的影响，为什么？
     *
     */

    /**
     * 初始思路：利用二分搜索找到最大值，将数组分成两个区间，然后再用二分搜索找target
     * <p>
     * 将三十三题的代码搬过来修改的，本题中的 nums 可能包含重复元素会导致寻找最大值分区的时候可能会遍历整个数组，
     * 复杂度从O(logn)提到了O(n)
     *
     * @param nums
     * @param target
     * @return
     */
    public boolean search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return false;
        }
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
            return true;
        }

        int center;
        while (low <= high) {
            center = (low - high) / 2 + high;
            if (nums[center] > target) {
                high = center - 1;
            } else if (nums[center] < target) {
                low = center + 1;
            } else {
                return true;
            }
        }
        return false;
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

        // 下面两个 while 是关键，先去掉前面和后面部分跟第一个重复的值，否则二分搜索很麻烦，当遇到相等的值不懂判断移动那个下标
        while (low < nums.length && nums[low] == maxValue) {
            low++;
        }
        while (high >= 0 && nums[high] == maxValue) {
            high--;
        }

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
        int[] nums = new int[]{2, 5, 6, 0, 0, 1, 2};
        Subject81 subject = new Subject81();
        System.out.println(subject.search(nums, 3));
    }

}
