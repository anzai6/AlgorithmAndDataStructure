package com.leetcode.anzai.subject_61_80;

import java.util.Arrays;

/**
 * ��ɫ����
 * https://leetcode-cn.com/problems/sort-colors/
 */
public class Subject75 {

    /**
     *
     ����һ��������ɫ����ɫ����ɫ��һ��  n ��Ԫ�ص����飬ԭ�ض����ǽ�������ʹ����ͬ��ɫ��Ԫ�����ڣ������պ�ɫ����ɫ����ɫ˳�����С�

     �����У�����ʹ������ 0��  1 �� 2 �ֱ��ʾ��ɫ����ɫ����ɫ��

     ע��:
     ����ʹ�ô�����е����������������⡣

     ʾ��:

     ����: [2,0,2,1,1,0]
     ���: [0,0,1,1,2,2]
     ���ף�

     һ��ֱ�۵Ľ��������ʹ�ü������������ɨ���㷨��
     ���ȣ����������0��1 �� 2 Ԫ�صĸ�����Ȼ����0��1��2��������д��ǰ���顣
     �������һ����ʹ�ó����ռ��һ��ɨ���㷨��
     *
     */

    /**
     * Ͱ���򣬼������򣬿�������
     * �����뷨��ͷβ˫ָ��
     *
     * @param nums
     */
    public void sortColors(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int zeroIndex = 0;
        int twoIndex = nums.length - 1;
        for (int i = 0; i <= twoIndex; ) {
            int value = nums[i];
            if (value == 0) {
                swap(nums, zeroIndex, i);
                ++zeroIndex;
                i++;
            } else if (value == 2) {
                // �ȹ���β��ָ�����2��
                while (twoIndex >= 0 && nums[twoIndex] == 2) {
                    --twoIndex;
                }
                if (twoIndex <= i) {
                    break;
                }
                swap(nums, twoIndex, i);
                --twoIndex;
            } else {
                i++;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int item = nums[i];
        nums[i] = nums[j];
        nums[j] = item;
    }

    public static void main(String[] args) {
//        int[] nums = new int[]{1, 0, 2, 1, 1, 0, 0, 2, 1, 1, 1, 1, 2, 2, 0, 1};
//        int[] nums = new int[]{1, 2, 1,0};
//        int[] nums = new int[]{0, 2, 1, 2};
//        int[] nums = new int[]{1, 2, 0};
        int[] nums = new int[]{2};
        Subject75 subject = new Subject75();
        subject.sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }

}
