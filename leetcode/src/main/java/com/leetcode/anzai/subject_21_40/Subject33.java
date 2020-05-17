package com.leetcode.anzai.subject_21_40;

/**
 * ������ת��������
 * https://leetcode-cn.com/problems/search-in-rotated-sorted-array/
 */
public class Subject33 {

    /**
     *
     ���谴�����������������Ԥ��δ֪��ĳ�����Ͻ�������ת��

     ( ���磬���� [0,1,2,4,5,6,7] ���ܱ�Ϊ [4,5,6,7,0,1,2] )��

     ����һ��������Ŀ��ֵ����������д������Ŀ��ֵ���򷵻��������������򷵻� -1 ��

     ����Լ��������в������ظ���Ԫ�ء�

     ����㷨ʱ�临�Ӷȱ����� O(log n) ����

     ʾ�� 1:

     ����: nums = [4,5,6,7,0,1,2], target = 0
     ���: 4
     ʾ�� 2:

     ����: nums = [4,5,6,7,0,1,2], target = 3
     ���: -1
     *
     */

    /**
     * ��ʼ˼·�����ö��������ҵ����ֵ��������ֳ��������䣬Ȼ�����ö���������target
     *
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0)
            return -1;
        int maxIndex = getMaxIndex(nums); // �ҳ������е����ֵ�±�
        int low;
        int high;
        if (target > nums[0]) { // target �ڴ�����
            low = 1;
            high = maxIndex;
        } else if (target < nums[0]) { // target ��С����
            low = maxIndex + 1;
            high = nums.length - 1;
        } else {
            return 0;
        }

        int center;
        while (low <= high) {
            center = (low - high) / 2 + high;
            if (nums[center] > target) {
                high = center - 1;
            } else if (nums[center] < target) {
                low = center + 1;
            } else {
                return center;
            }
        }
        return -1;
    }


    /**
     * �������������ֵ�±�
     *
     * @param nums
     * @return
     */
    private int getMaxIndex(int[] nums) {
        int low = 1;
        int high = nums.length - 1;
        int maxValue = nums[0];
        int maxIndex = 0;
        int center;
        while (low <= high) {
            center = (high - low) / 2 + low;
            if (nums[center] >= maxValue) {
                maxValue = nums[center];
                maxIndex = center;
                low = center + 1;
            } else {
                high = center - 1;
            }
        }
        return maxIndex;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{4, 5, 6, 7, 0, 1, 2};
        Subject33 subject = new Subject33();
        System.out.print(subject.search(nums, 3));
    }

}
