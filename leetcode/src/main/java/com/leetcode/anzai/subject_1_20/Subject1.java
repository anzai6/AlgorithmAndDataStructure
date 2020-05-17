package com.leetcode.anzai.subject_1_20;

import java.util.HashMap;

/**
 * 两数之和
 * https://leetcode-cn.com/problems/two-sum/
 */
public class Subject1 {

    /**
     *
     给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。

     你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。

     示例:

     给定 nums = [2, 7, 11, 15], target = 9

     因为 nums[0] + nums[1] = 2 + 7 = 9
     所以返回 [0, 1]
     *
     */


    /**
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        if (nums == null)
            return result;
        HashMap<Integer, Integer> hashMap = new HashMap();
        for (int i = 0; i < nums.length; i++) {
            int value = nums[i];
            if (hashMap.containsKey(value)) {
                result[0] = hashMap.get(value);
                result[1] = i;
                return result;
            } else {
                hashMap.put(target - value, i);
            }
        }
        return result;
    }


    public static void main(String[] args) {
        int[] nums = new int[]{-3, 4, 3, 90};
        Subject1 subject = new Subject1();
        int[] result = subject.twoSum(nums, 0);
        if (result == null)
            return;
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }
}
