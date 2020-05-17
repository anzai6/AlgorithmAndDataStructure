package com.leetcode.anzai.subject_21_40;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 组合总和 II
 * https://leetcode-cn.com/problems/combination-sum-ii/
 */
public class Subject40 {

    /**
     *
     给定一个数组?candidates?和一个目标数?target?，找出?candidates?中所有可以使数字和为?target?的组合。

     candidates?中的每个数字在每个组合中只能使用一次。

     说明：

     所有数字（包括目标数）都是正整数。
     解集不能包含重复的组合。?
     示例?1:

     输入: candidates =?[10,1,2,7,6,1,5], target =?8,
     所求解集为:
     [
     [1, 7],
     [1, 2, 5],
     [2, 6],
     [1, 1, 6]
     ]
     示例?2:

     输入: candidates =?[2,5,2,1,2], target =?5,
     所求解集为:
     [
     ? [1,2,2],
     ? [5]
     ]
     *
     */

    /**
     * 每次从大往小选,叠加二分查找每次找出小于等于 target 的下标 targetIndex，每次从 targetIndex 开始往下选
     *
     * @param candidates
     * @param target
     * @return
     */
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        list = new ArrayList<>();
        if (candidates == null || candidates.length == 0)
            return list;

        Arrays.sort(candidates);
        List<Integer> subList = new ArrayList<>();
        int targetIndex = findtarget(candidates, target, candidates.length - 1); // target的下标，没有就返回第一个小于target的值的下标
        if (targetIndex < 0)
            return list;
        combinationSumInternal(candidates, targetIndex, target, subList);

        return list;
    }

    List<List<Integer>> list;

    /**
     * @param candidates
     * @param bigIndex   小于等于剩余值的最大坐标
     * @param rest       剩余的值
     * @param subList
     */
    public void combinationSumInternal(int[] candidates, int bigIndex, int rest, List<Integer> subList) {
        int lastRemove = -1;
        for (int i = bigIndex; i >= 0; i--) {
            int value = candidates[i];
            if (value == lastRemove) // 这一步很关键，防止刚移出 subList 的整数再加进去，这样就能避免重复，真实神来之笔，哈哈
                continue;
            Integer integer = Integer.valueOf(value);
            subList.add(integer);
            if (rest == value) { // 找出一组
                list.add(new ArrayList<>(subList));
            } else {
                int newRest = rest - value;
                int newBigIndex = findtarget(candidates, newRest, i); // target的下标，没有就返回第一个小于target的值的下标
                if (newBigIndex >= 0) {
                    if (newBigIndex == i) // 每一位只能使用一次
                        newBigIndex--;
                    combinationSumInternal(candidates, newBigIndex, newRest, subList);
                }
            }
            subList.remove(integer); // 去掉已经加入的值,回溯
            lastRemove = value;
        }
    }


    /**
     * 二分查找相等的值下标，没有就返回第一个小于target的值的下标,没有小于的就返回负一
     *
     * @return
     */
    private int findtarget(int[] nums, int target, int high) {
        int low = 0;
        int center = 0;
        while (low <= high) {
            center = (high - low) / 2 + low;
            if (nums[center] < target) {
                low = center + 1;
            } else if (nums[center] > target) {
                high = center - 1;
            } else {
                return center;
            }
        }
        if (nums[center] > target) // 最后一定取小于 target 的数的下标，没有小于的就返回-1
            center--;
        return center;
    }

    public static void main(String[] args) {
        int[] candidates = new int[]{10, 1, 2, 7, 6, 1, 5};
        Subject40 subject = new Subject40();
        List<List<Integer>> list = subject.combinationSum2(candidates, 9);
        for (int i = 0; i < list.size(); i++) {
            List<Integer> subList = list.get(i);
            for (int j = 0; j < subList.size(); j++) {
                System.out.print(subList.get(j) + " ");
            }
            System.out.println();
        }
    }

}
