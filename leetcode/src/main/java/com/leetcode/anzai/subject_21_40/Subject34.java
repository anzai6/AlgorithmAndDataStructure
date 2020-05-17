package com.leetcode.anzai.subject_21_40;

/**
 * �����������в���Ԫ�صĵ�һ�������һ��λ��
 * https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 */
public class Subject34 {

    /**
     *
     ����һ�������������е��������� nums����һ��Ŀ��ֵ target���ҳ�����Ŀ��ֵ�������еĿ�ʼλ�úͽ���λ�á�

     ����㷨ʱ�临�Ӷȱ�����?O(log n) ����

     ��������в�����Ŀ��ֵ������?[-1, -1]��

     ʾ�� 1:

     ����: nums = [5,7,7,8,8,10], target = 8
     ���: [3,4]
     ʾ��?2:

     ����: nums = [5,7,7,8,8,10], target = 6
     ���: [-1,-1]
     *
     */

    /**
     * ��ʼ˼·�����ö��������ֱ��ҵ���һ�������һ����ȵ�ֵ�±�
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[]{-1, -1};
        if (nums == null || nums.length == 0)
            return result;
        result[0] = findFirstSame(nums, target);
        if (result[0] < 0)
            return result;
        result[1] = findLastSame(nums, target, result[0]);
        return result;
    }


    /**
     * ���ҵ�һ����ȵ�ֵ
     *
     * @return
     */
    private int findFirstSame(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        int firstIndex = -1;
        int center;
        while (low <= high) {
            center = (high - low) / 2 + low;
            if (nums[center] < target) {
                low = center + 1;
            } else if (nums[center] > target) {
                high = center - 1;
            } else {
                firstIndex = center;
                high = center - 1;
            }
        }
        return firstIndex;
    }

    /**
     * �������һ����ȵ�ֵ
     *
     * @return
     */
    private int findLastSame(int[] nums, int target, int low) {
        int high = nums.length - 1;
        int lastIndex = -1;
        int center;
        while (low <= high) {
            center = (high - low) / 2 + low;
            if (nums[center] < target) {
                low = center + 1;
            } else if (nums[center] > target) {
                high = center - 1;
            } else {
                lastIndex = center;
                low = center + 1;
            }
        }
        return lastIndex;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{5, 7, 7, 8, 8, 10};
        Subject34 subject = new Subject34();
        int[] result = subject.searchRange(nums, 10);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
    }

}
