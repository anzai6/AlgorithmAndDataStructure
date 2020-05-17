package com.leetcode.anzai.subject_61_80;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * �Ӽ�
 * https://leetcode-cn.com/problems/subsets/
 */
public class Subject78 {

    /**
     *
     ����һ�鲻���ظ�Ԫ�ص��������� nums�����ظ��������п��ܵ��Ӽ����ݼ�����

     ˵�����⼯���ܰ����ظ����Ӽ���

     ʾ��:

     ����: nums = [1,2,3]
     ���:
     [
     [3],
     [1],
     [2],
     [1,2,3],
     [1,3],
     [2,3],
     [1,2],
     []
     ]
     *
     */

    /**
     * �ο����Ѵ���Ķ����ƽⷨ��
     * ���ϵ�ÿ��Ԫ�أ����п���ѡ��ѡ���ö����ƺ�λ���㣬���Ժܺõı�ʾ��
     *
     * @param nums
     * @return
     */
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        // 1 << nums.length �൱�� 2 �� nums.length �η�������ö�����������
        for (int i = 0; i < (1 << nums.length); i++) {
            List<Integer> sub = new ArrayList<>();
            // ���� nums.length ���� 4������� 4 ��������λ��ÿ������λΪ 1 ����ѡ��0 ����ѡ
            for (int j = 0; j < nums.length; j++) {
                // ((i >> j) & 1) == 1 �����˼�� �����ǰ i �Ķ����Ʊ�ʾ�У����� 1 �����н���λ��Ȼ����Ϊ�±�ѡ��������Ӧ�±��ֵ
                // ���� i = 3 ����Ϊ 0011 ��>> j ��λ������λ����0,1,2,3������λ�Ƶ� 0 λ�͵� 1 λʱ���ʽΪtrue
                // ��Ӧ�Ļ�ѡ��������±�Ϊ 0 �� 1 ��ֵ�������Դ�����
                if (((i >> j) & 1) == 1) {
                    sub.add(nums[j]);
                }
            }
            res.add(sub);
        }
        return res;
    }

    /**
     * �����㷨
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> subsets1(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        list.add(new ArrayList<Integer>()); // �յ����
        if (nums == null || nums.length == 0) {
            return list;
        }

        boolean[] used = new boolean[nums.length];
        for (int i = 1; i <= nums.length; i++) {
            subsetsIntervalBt(nums, i, 0, list, used);
        }

        return list;
    }

    /**
     * �����㷨:����ʵ��
     *
     * @param nums
     * @param k          ��ǰ��Ҫ���뼯�ϵ�λ��
     * @param startIndex ��ʼ���������꣬����Ϊ�˷��ظ������������ nums[1] ���� nums[2] ��Ͳ��û�ͷ���� nums[1] ��
     * @param list
     * @param used       ��¼�Ѿ������λ��������ǵûָ�
     */
    public void subsetsIntervalBt(int[] nums, int k, int startIndex, List<List<Integer>> list, boolean[] used) {
        if (k == 0) {
            List<Integer> subList = new ArrayList<>();
            for (int i = 0; i < used.length; i++) {
                if (used[i]) {
                    subList.add(nums[i]);
                }
            }
            list.add(subList);
            return;
        }

        for (int i = startIndex; i < nums.length; i++) {
            used[i] = true;
            subsetsIntervalBt(nums, k - 1, i + 1, list, used);
            used[i] = false; // ����
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4};
        Subject78 subject = new Subject78();
        List<List<Integer>> list = subject.subsets(nums);
        if (list == null) {
            return;
        }
        for (int i = 0; i < list.size(); i++) {
            List<Integer> subList = list.get(i);
            if (subList == null) {
                return;
            }
            System.out.print(Arrays.toString(subList.toArray(new Integer[0])));
            System.out.println();
        }
    }

}
