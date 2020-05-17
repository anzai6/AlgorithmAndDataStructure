package com.leetcode.anzai.subject_21_40;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 组合总和
 * https://leetcode-cn.com/problems/combination-sum/
 */
public class Subject39 {

    /**
     *
     给定一个无重复元素的数组?candidates?和一个目标数?target?，找出?candidates?中所有可以使数字和为?target?的组合。

     candidates?中的数字可以无限制重复被选取。

     说明：

     所有数字（包括?target）都是正整数。
     解集不能包含重复的组合。?
     示例?1:

     输入: candidates = [2,3,6,7], target = 7,
     所求解集为:
     [
     [7],
     [2,2,3]
     ]
     示例?2:

     输入: candidates = [2,3,5], target = 8,
     所求解集为:
     [
     ? [2,2,2,2],
     ? [2,3,3],
     ? [3,5]
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
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
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
     *
     * @param candidates
     * @param bigIndex 小于等于剩余值的最大坐标
     * @param rest 剩余的值
     * @param subList
     */
    public void combinationSumInternal(int[] candidates, int bigIndex, int rest, List<Integer> subList) {
        for (int i = bigIndex; i >= 0; i--) {
            int value = candidates[i];
            subList.add(value);
            if (rest == value) { // 找出一组
                list.add(new ArrayList<>(subList));
            } else {
                int newRest = rest - value;
                int newBigIndex = findtarget(candidates, newRest, i); // target的下标，没有就返回第一个小于target的值的下标
                if (newBigIndex >= 0)
                    combinationSumInternal(candidates, newBigIndex, newRest, subList);
            }
            subList.remove(Integer.valueOf(value)); // 去掉已经加入的值,回溯
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
        if (nums[center] > target)
            center--;
        return center;
    }

    public static void main(String[] args) {
        int[] candidates = new int[]{2,3,5};
        Subject39 subject = new Subject39();
        List<List<Integer>> list = subject.combinationSum(candidates, 8);
        for (int i = 0; i < list.size(); i++) {
            List<Integer> subList = list.get(i);
            for (int j = 0; j < subList.size(); j++) {
                System.out.print(subList.get(j) + " ");
            }
            System.out.println();
        }
    }

}
