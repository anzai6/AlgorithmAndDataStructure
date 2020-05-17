package com.leetcode.anzai.subject_21_40;

/**
 * 下一个排列
 * https://leetcode-cn.com/problems/next-permutation/
 */
public class Subject31 {

    /**
     *
     实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。

     如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。

     必须原地修改，只允许使用额外常数空间。

     以下是一些例子，输入位于左侧列，其相应输出位于右侧列。
     1,2,3 → 1,3,2
     3,2,1 → 1,2,3
     1,1,5 → 1,5,1
     *
     */

    /**
     * 普通版本
     *
     * @param nums
     */
    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length <= 1)
            return;
        int len = nums.length;
        int swapIndex = 0;
        for (int i = len - 1; i >= 1; i--) {
            if (nums[i] > nums[i - 1]) { // 找到比前一位大的数，然后交换位置
                // 从i往后遍历找到大于nums[i - 1]中的最小值
                int minValue = nums[i];
                int minIndex = i;
                for (int j = i + 1; j < len; j++) {
                    if (nums[j] < minValue && nums[j] > nums[i - 1]) {
                        minValue = nums[j];
                        minIndex = j;
                    }
                }

                // 将后面大于nums[i - 1]中的最小值与nums[i - 1]交换
                nums[minIndex] = nums[i - 1];
                nums[i - 1] = minValue;
                swapIndex = i;
                break;
            }
        }

        // 对swapIndex下标之后的进行翻转
        reverse(nums, swapIndex);
    }

    private void reverse(int[] nums, int start) {
        int i = start, j = nums.length - 1;
        while (i < j && nums[i] > nums[j]) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
//        int[] nums = new int[]{ 2, 3, 1};
        int[] nums = new int[]{2, 3, 1, 3, 3}; // 557432
//        int[] nums = new int[]{1, 100, 8, 7, 6, 5, 4, 3, 2}; // 1,2,4,3,5 -> 1,2,4,5,3
        // 1,2,5,4,3 -> 1,3,2,4,5
        Subject31 subject = new Subject31();
        subject.nextPermutation(nums);
        for (Integer value : nums) {
            System.out.print(value + " ");
        }
    }

}
