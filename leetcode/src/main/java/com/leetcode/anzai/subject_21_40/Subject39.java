package com.leetcode.anzai.subject_21_40;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * ����ܺ�
 * https://leetcode-cn.com/problems/combination-sum/
 */
public class Subject39 {

    /**
     *
     ����һ�����ظ�Ԫ�ص�����?candidates?��һ��Ŀ����?target?���ҳ�?candidates?�����п���ʹ���ֺ�Ϊ?target?����ϡ�

     candidates?�е����ֿ����������ظ���ѡȡ��

     ˵����

     �������֣�����?target��������������
     �⼯���ܰ����ظ�����ϡ�?
     ʾ��?1:

     ����: candidates = [2,3,6,7], target = 7,
     ����⼯Ϊ:
     [
     [7],
     [2,2,3]
     ]
     ʾ��?2:

     ����: candidates = [2,3,5], target = 8,
     ����⼯Ϊ:
     [
     ? [2,2,2,2],
     ? [2,3,3],
     ? [3,5]
     ]
     *
     */

    /**
     * ÿ�δӴ���Сѡ,���Ӷ��ֲ���ÿ���ҳ�С�ڵ��� target ���±� targetIndex��ÿ�δ� targetIndex ��ʼ����ѡ
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
        int targetIndex = findtarget(candidates, target, candidates.length - 1); // target���±꣬û�оͷ��ص�һ��С��target��ֵ���±�
        if (targetIndex < 0)
            return list;
        combinationSumInternal(candidates, targetIndex, target, subList);

        return list;
    }

    List<List<Integer>> list;

    /**
     *
     * @param candidates
     * @param bigIndex С�ڵ���ʣ��ֵ���������
     * @param rest ʣ���ֵ
     * @param subList
     */
    public void combinationSumInternal(int[] candidates, int bigIndex, int rest, List<Integer> subList) {
        for (int i = bigIndex; i >= 0; i--) {
            int value = candidates[i];
            subList.add(value);
            if (rest == value) { // �ҳ�һ��
                list.add(new ArrayList<>(subList));
            } else {
                int newRest = rest - value;
                int newBigIndex = findtarget(candidates, newRest, i); // target���±꣬û�оͷ��ص�һ��С��target��ֵ���±�
                if (newBigIndex >= 0)
                    combinationSumInternal(candidates, newBigIndex, newRest, subList);
            }
            subList.remove(Integer.valueOf(value)); // ȥ���Ѿ������ֵ,����
        }
    }


    /**
     * ���ֲ�����ȵ�ֵ�±꣬û�оͷ��ص�һ��С��target��ֵ���±�,û��С�ڵľͷ��ظ�һ
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
