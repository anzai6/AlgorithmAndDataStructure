package com.example.lib.course57_exercise.solution.array;

import java.util.HashMap;

/**
 * ��ȱʧ�ĵ�һ������
 * https://leetcode-cn.com/problems/first-missing-positive/
 */
public class SolutionFirstMissingPositive {

//    ����һ��δ������������飬�ҳ�����û�г��ֵ���С����������
//    ����㷨��ʱ�临�Ӷ�ӦΪO(n)������ֻ��ʹ�ó�������Ŀռ䡣
//    ����: [7,8,9,11,12]
//    ���: 1

    /**
     * �ٷ��ⷨ�����򵥰�
     *
     * @param nums
     * @return
     */
    public int firstMissingPositive(int[] nums) {
        if (nums == null)
            throw new NullPointerException("nums can not be empty");
        if (nums.length == 0)
            return 1;

        int len = nums.length;
        boolean hasOne = false;
        int high = Integer.MIN_VALUE;

        // ��һ�α���������Ԥ���������д��ڵ���0���ߴ����б���len��ֵ��Ϊ1����Ϊȱʧ�ĵ�һ�������϶���1~len+1֮��
        for (int i = 0; i < len; i++) {

            int num = nums[i];

            if (!hasOne && num == 1) // �ж��б��Ƿ����1
                hasOne = true;

            if (num > len || num <= 0) { // �����д��ڵ���0���ߴ����б���len��ֵ��Ϊ1
                nums[i] = 1;
            }
        }

        if (!hasOne) // ��Ϊ����Ԥ����������ֵ��Ϊ1�����Զ�1Ҫ���⴦��
            return 1;

        // ����������hash��
        for (int i = 0; i < len; i++) {
            int num = Math.abs(nums[i]); // ����Ҫȡ����ֵ����Ϊ�п����Ǹ���
            // ����ǰ���Ԥ���������num��1~len֮�䣬���Զ����д��ڵ�ֵnum���Ѷ�Ӧ�б��±�num��ֵnums[i]��Ϊ����
            // ��������൱��������������hash�����˼��ǳ����ǰ������
            if (num == len) {// ������ֻҪ���⴦��num == len ����
                if (nums[0] > 0)
                    nums[0] = -nums[0];
            } else {
                if (nums[num] > 0)
                    nums[num] = -nums[num];
            }
        }

        // ͨ��������hash����ֵ,����0�������⴦��
        for (int i = 1; i < len; i++) {
            if (nums[i] > 0) // ��һ��������С��i����ȱʧ�ĵ�һ������
                return i;
        }

        if (nums[0] > 0)
            return len;
        else
            return len + 1;
    }


    /**
     * ����ⷨ
     *
     * @param nums
     * @return
     */
    public int firstMissingPositive1(int[] nums) {
        if (nums == null)
            throw new NullPointerException("nums can not be empty");
        if (nums.length == 0)
            return 1;

        int len = nums.length;
        HashMap<Integer, Character> hashMap = new HashMap<>();
        int low = Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;

        for (int i = 0; i < len; i++) {
            int num = nums[i];
            hashMap.put(num, '0');
            if (num > 0) {
                if (num > high)
                    high = num;
                if (num < low)
                    low = num;
            }
        }

        if (low > 1) // ��Сֵ��������Ϊ1��ֱ�ӷ���1
            return 1;
        if (high <= Integer.MAX_VALUE - 2) // ����һ��ʼ������������������������
            high = high + 2;
        for (int i = 1; i < high; i++) {
            if (!hashMap.containsKey(i)) // û�а����ʹ���i��û�г��ֵ���С��������
                return i;
        }

        return 0;
    }


    public static void main(String[] args) {
        SolutionFirstMissingPositive solution = new SolutionFirstMissingPositive();
        int[] nums = new int[]{1, 2, 3, 10, 2147483647, 9};
        int result = solution.firstMissingPositive(nums);
        System.out.println("" + result);
    }
}
