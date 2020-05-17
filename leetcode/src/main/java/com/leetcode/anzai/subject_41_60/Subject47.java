package com.leetcode.anzai.subject_41_60;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 全排列 II
 * https://leetcode-cn.com/problems/permutations-ii/
 */
public class Subject47 {

    /**
     *
     给定一个可包含重复数字的序列，返回所有不重复的全排列。

     示例:

     输入: [1,1,2]
     输出:
     [
     [1,1,2],
     [1,2,1],
     [2,1,1]
     ]
     *
     */

    /**
     * 回溯算法
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return list;
        }
        Arrays.sort(nums);
        boolean[] sortFlag = new boolean[nums.length];
        permuteInternal(nums, 0, list, sortFlag, new LinkedList<Integer>());
        return list;
    }

    /**
     * 内部递归
     *
     * @param nums
     * @param n    当前排列到第一个
     * @param list
     */
    private void permuteInternal(int[] nums, int n, List<List<Integer>> list, boolean[] sortFlag, LinkedList<Integer> sublist) {
        if (n == nums.length) {
            list.add(new LinkedList<Integer>(sublist));
            return;
        }
        for (int i = 0; i < nums.length; i++) {

            if (sortFlag[i]) { // 已经放入排序的
                continue;
            }

            // 跳过相同的值，注意加上 !sortFlag[i-1] 是必须的，!sortFlag[i-1] 证明上一个值刚放进去过，所以就不重复放相同的值
            if (i != 0 && nums[i] == nums[i - 1] && !sortFlag[i - 1]) {
                continue;
            }

            sortFlag[i] = true;
            sublist.push(nums[i]); // 加入排序
            permuteInternal(nums, n + 1, list, sortFlag, sublist);
            sublist.pop(); // 回溯值
            sortFlag[i] = false;
        }
    }

    public static void main(String[] args) {
//        int[] nums = new int[]{1, 1, 2, 2};
        int[] nums = new int[]{1, 1, 2};
//        int[] nums = new int[]{-1, 2, -1, 2, 1, -1, 2, 1};
//        int[] nums = new int[]{2, 0, 0, 1, 1, 3, 3};
        Subject47 subject = new Subject47();
        List<List<Integer>> list = subject.permuteUnique(nums);
        for (int i = 0; i < list.size(); i++) {
            List<Integer> subList = list.get(i);
            for (int j = 0; j < subList.size(); j++) {
                System.out.print(subList.get(j) + " ");
            }
            System.out.println();
        }
    }

}
