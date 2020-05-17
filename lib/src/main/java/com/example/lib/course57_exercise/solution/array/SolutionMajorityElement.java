package com.example.lib.course57_exercise.solution.array;

import java.util.HashMap;

/**
 * ������
 * https://leetcode-cn.com/problems/majority-element/
 */
public class SolutionMajorityElement {

//    ������������һ����СΪ n �����飬�ҵ����е�������������ָ�������г��ִ������� ? n/2 ? ��Ԫ�ء�
//            * ����Լ��������Ƿǿյģ����Ҹ������������Ǵ���������

    /**
     * ���ɽⷨ���ӵ�һ������ʼcount=1��������ͬ�ľͼ�1��������ͬ�ľͼ�1������0�����»�������ʼ�����������ҵ������Ǹ�
     *
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {
        if (nums == null || nums.length == 0)
            throw new NullPointerException("nums can not be empty");

        int count = 1;
        int num = nums[0];

        for (int i = 1; i < nums.length; i++) {

            if (num == nums[i]) {
                ++count;
            } else {
                if (count == 0) {
                    num = nums[i];
                    count = 1;
                } else {
                    --count;
                }
            }

        }

        return num;
    }

    /**
     * ����ⷨ
     *
     * @param nums
     * @return
     */
    public int majorityElement1(int[] nums) {
        if (nums == null || nums.length == 0)
            throw new NullPointerException("nums can not be empty");

        int len = nums.length;
        int halfLen = len / 2;
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < len; i++) {
            int count = 0;
            int num = nums[i];
            if (hashMap.containsKey(num))
                count = hashMap.get(num);
            ++count;
            if (count > halfLen)
                return num;
            else
                hashMap.put(num, count);
        }

        return Integer.MIN_VALUE;
    }


    public static void main(String[] args) {
        SolutionMajorityElement solution = new SolutionMajorityElement();
        int[] nums = new int[]{2, 2, 1, 1, 1, 2, 2};
        int result = solution.majorityElement(nums);
        System.out.println("" + result);
    }
}
