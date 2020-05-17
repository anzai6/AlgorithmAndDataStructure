package com.example.lib.course57_exercise.solution.array;

import java.util.HashMap;

/**
 * 求缺失的第一个正数
 * https://leetcode-cn.com/problems/first-missing-positive/
 */
public class SolutionFirstMissingPositive {

//    给定一个未排序的整数数组，找出其中没有出现的最小的正整数。
//    你的算法的时间复杂度应为O(n)，并且只能使用常数级别的空间。
//    输入: [7,8,9,11,12]
//    输出: 1

    /**
     * 官方解法：不简单啊
     *
     * @param nums
     * @return
     */
    public int firstMissingPositive(int[] nums) {
        if (nums == null)
            throw new NullPointerException("nums can not be empty");
        if (nums.length == 0)
            return 1;

        int len = nums.length;
        boolean hasOne = false;
        int high = Integer.MIN_VALUE;

        // 第一次遍历：数据预处理，把所有大于等于0或者大于列表长度len的值改为1，因为缺失的第一个正数肯定在1~len+1之间
        for (int i = 0; i < len; i++) {

            int num = nums[i];

            if (!hasOne && num == 1) // 判断列表是否存在1
                hasOne = true;

            if (num > len || num <= 0) { // 把所有大于等于0或者大于列表长度len的值改为1
                nums[i] = 1;
            }
        }

        if (!hasOne) // 因为上述预处理会把其他值改为1，所以对1要特殊处理
            return 1;

        // 用自身制作hash表
        for (int i = 0; i < len; i++) {
            int num = Math.abs(nums[i]); // 这里要取绝对值，因为有可能是负数
            // 由于前面的预处理，这里的num在1~len之间，所以对所有存在的值num，把对应列表下标num的值nums[i]置为负数
            // 这个做法相当于用自身来制作hash表，这个思想非常机智啊，佩服
            if (num == len) {// ，这里只要特殊处理num == len 就行
                if (nums[0] > 0)
                    nums[0] = -nums[0];
            } else {
                if (nums[num] > 0)
                    nums[num] = -nums[num];
            }
        }

        // 通过制作的hash表求值,这里0最后会特殊处理
        for (int i = 1; i < len; i++) {
            if (nums[i] > 0) // 第一个正数的小标i就是缺失的第一个正数
                return i;
        }

        if (nums[0] > 0)
            return len;
        else
            return len + 1;
    }


    /**
     * 常规解法
     *
     * @param nums
     * @return
     */
    public int firstMissingPositive1(int[] nums) {
        if (nums == null)
            throw new NullPointerException("nums can not be empty");
        if (nums.length == 0)
            return 1;

        int len = nums.length;
        HashMap<Integer, Character> hashMap = new HashMap<>();
        int low = Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;

        for (int i = 0; i < len; i++) {
            int num = nums[i];
            hashMap.put(num, '0');
            if (num > 0) {
                if (num > high)
                    high = num;
                if (num < low)
                    low = num;
            }
        }

        if (low > 1) // 最小值正整数不为1就直接返回1
            return 1;
        if (high <= Integer.MAX_VALUE - 2) // 这里一开始忽略了正数溢出的情况，惭愧
            high = high + 2;
        for (int i = 1; i < high; i++) {
            if (!hashMap.containsKey(i)) // 没有包含就代表i是没有出现的最小的正整数
                return i;
        }

        return 0;
    }


    public static void main(String[] args) {
        SolutionFirstMissingPositive solution = new SolutionFirstMissingPositive();
        int[] nums = new int[]{1, 2, 3, 10, 2147483647, 9};
        int result = solution.firstMissingPositive(nums);
        System.out.println("" + result);
    }
}
