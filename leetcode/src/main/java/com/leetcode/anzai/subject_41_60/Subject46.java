package com.leetcode.anzai.subject_41_60;

import java.util.ArrayList;
import java.util.List;

/**
 * ȫ����
 * https://leetcode-cn.com/problems/permutations/
 */
public class Subject46 {

    /**
     *
     ����һ��û���ظ����ֵ����У����������п��ܵ�ȫ���С�

     ʾ��:

     ����: [1,2,3]
     ���:
     [
     [1,2,3],
     [1,3,2],
     [2,1,3],
     [2,3,1],
     [3,1,2],
     [3,2,1]
     ]
     *
     */

    /**
     * �����㷨
     * @param nums
     * @return
     */
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        if (nums == null || nums.length == 0)
            return list;
        permuteInternal(nums, nums.length - 1, list);
        return list;
    }

    private void permuteInternal(int[] nums, int n, List<List<Integer>> list) {
        if (n == 0) {
            List<Integer> subList = new ArrayList<>(nums.length);
            for (int i = 0; i < nums.length; i++) {
                subList.add(nums[i]);
            }
            list.add(subList);
        }
        for (int i = 0; i <= n; i++) {
            swap(nums, i, n); // ����ֵ
            permuteInternal(nums, n - 1, list);
            swap(nums, i, n); // ����ֵ
        }
    }

    private void swap(int[] nums, int i, int j) {
        int value = nums[i];
        nums[i] = nums[j];
        nums[j] = value;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4};
        Subject46 subject = new Subject46();
        List<List<Integer>> list = subject.permute(nums);
        for (int i = 0; i < list.size(); i++) {
            List<Integer> subList = list.get(i);
            for (int j = 0; j < subList.size(); j++) {
                System.out.print(subList.get(j) + " ");
            }
            System.out.println();
        }
    }

}
