package com.leetcode.anzai.subject_41_60;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * ȫ���� II
 * https://leetcode-cn.com/problems/permutations-ii/
 */
public class Subject47 {

    /**
     *
     ����һ���ɰ����ظ����ֵ����У��������в��ظ���ȫ���С�

     ʾ��:

     ����: [1,1,2]
     ���:
     [
     [1,1,2],
     [1,2,1],
     [2,1,1]
     ]
     *
     */

    /**
     * �����㷨
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
     * �ڲ��ݹ�
     *
     * @param nums
     * @param n    ��ǰ���е���һ��
     * @param list
     */
    private void permuteInternal(int[] nums, int n, List<List<Integer>> list, boolean[] sortFlag, LinkedList<Integer> sublist) {
        if (n == nums.length) {
            list.add(new LinkedList<Integer>(sublist));
            return;
        }
        for (int i = 0; i < nums.length; i++) {

            if (sortFlag[i]) { // �Ѿ����������
                continue;
            }

            // ������ͬ��ֵ��ע����� !sortFlag[i-1] �Ǳ���ģ�!sortFlag[i-1] ֤����һ��ֵ�շŽ�ȥ�������ԾͲ��ظ�����ͬ��ֵ
            if (i != 0 && nums[i] == nums[i - 1] && !sortFlag[i - 1]) {
                continue;
            }

            sortFlag[i] = true;
            sublist.push(nums[i]); // ��������
            permuteInternal(nums, n + 1, list, sortFlag, sublist);
            sublist.pop(); // ����ֵ
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
