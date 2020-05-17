package com.example.lib.course57_exercise.solution.array;

import java.util.HashMap;

/**
 * 求众数
 * https://leetcode-cn.com/problems/majority-element/
 */
public class SolutionMajorityElement {

//    求众数：给定一个大小为 n 的数组，找到其中的众数。众数是指在数组中出现次数大于 ? n/2 ? 的元素。
//            * 你可以假设数组是非空的，并且给定的数组总是存在众数。

    /**
     * 技巧解法：从第一个数开始count=1，遇到相同的就加1，遇到不同的就减1，减到0就重新换个数开始计数，总能找到最多的那个
     *
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {
        if (nums == null || nums.length == 0)
            throw new NullPointerException("nums can not be empty");

        int count = 1;
        int num = nums[0];

        for (int i = 1; i < nums.length; i++) {

            if (num == nums[i]) {
                ++count;
            } else {
                if (count == 0) {
                    num = nums[i];
                    count = 1;
                } else {
                    --count;
                }
            }

        }

        return num;
    }

    /**
     * 常规解法
     *
     * @param nums
     * @return
     */
    public int majorityElement1(int[] nums) {
        if (nums == null || nums.length == 0)
            throw new NullPointerException("nums can not be empty");

        int len = nums.length;
        int halfLen = len / 2;
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < len; i++) {
            int count = 0;
            int num = nums[i];
            if (hashMap.containsKey(num))
                count = hashMap.get(num);
            ++count;
            if (count > halfLen)
                return num;
            else
                hashMap.put(num, count);
        }

        return Integer.MIN_VALUE;
    }


    public static void main(String[] args) {
        SolutionMajorityElement solution = new SolutionMajorityElement();
        int[] nums = new int[]{2, 2, 1, 1, 1, 2, 2};
        int result = solution.majorityElement(nums);
        System.out.println("" + result);
    }
}
