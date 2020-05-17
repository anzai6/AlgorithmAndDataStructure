package com.leetcode.anzai.subject_41_60;

/**
 * ��������
 * https://leetcode-cn.com/problems/maximum-subarray/
 */
public class Subject53 {

    /**
     *
     ����һ���������� nums?���ҵ�һ���������͵����������飨���������ٰ���һ��Ԫ�أ������������͡�

     ʾ��:

     ����: [-2,1,-3,4,-1,2,1,-5,4],
     ���: 6
     ����:?����������?[4,-1,2,1] �ĺ����Ϊ?6��
     ����:

     ������Ѿ�ʵ�ָ��Ӷ�Ϊ O(n) �Ľⷨ������ʹ�ø�Ϊ����ķ��η���⡣
     *
     */

    /**
     * ���Ӷ�Ϊ O(n) �Ľⷨ
     *
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int maxResult = Integer.MIN_VALUE;
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            int value = nums[i];
            result += value;
            if (result > maxResult) {
                maxResult = result;
            }
            if (result < 0) {
                result = 0;
            }
        }

        return maxResult;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        Subject53 subject = new Subject53();
        System.out.println(subject.maxSubArray(nums));
    }

}
