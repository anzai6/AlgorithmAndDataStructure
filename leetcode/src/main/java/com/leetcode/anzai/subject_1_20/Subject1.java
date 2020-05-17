package com.leetcode.anzai.subject_1_20;

import java.util.HashMap;

/**
 * ����֮��
 * https://leetcode-cn.com/problems/two-sum/
 */
public class Subject1 {

    /**
     *
     ����һ���������� nums ��һ��Ŀ��ֵ target�������ڸ��������ҳ���ΪĿ��ֵ���� ���� ���������������ǵ������±ꡣ

     ����Լ���ÿ������ֻ���Ӧһ���𰸡����ǣ��㲻���ظ��������������ͬ����Ԫ�ء�

     ʾ��:

     ���� nums = [2, 7, 11, 15], target = 9

     ��Ϊ nums[0] + nums[1] = 2 + 7 = 9
     ���Է��� [0, 1]
     *
     */


    /**
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        if (nums == null)
            return result;
        HashMap<Integer, Integer> hashMap = new HashMap();
        for (int i = 0; i < nums.length; i++) {
            int value = nums[i];
            if (hashMap.containsKey(value)) {
                result[0] = hashMap.get(value);
                result[1] = i;
                return result;
            } else {
                hashMap.put(target - value, i);
            }
        }
        return result;
    }


    public static void main(String[] args) {
        int[] nums = new int[]{-3, 4, 3, 90};
        Subject1 subject = new Subject1();
        int[] result = subject.twoSum(nums, 0);
        if (result == null)
            return;
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }
}
