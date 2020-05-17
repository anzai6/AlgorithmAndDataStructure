package com.leetcode.anzai.subject_1_20;

import java.util.Arrays;

/**
 * ��ӽ�������֮��
 * https://leetcode-cn.com/problems/3sum-closest/
 */
public class Subject16 {

    /**
     *
     ����һ������ n ������������ nums �� һ��Ŀ��ֵ target���ҳ� nums �е�����������ʹ�����ǵĺ��� target ��ӽ����������������ĺ͡��ٶ�ÿ������ֻ����Ψһ�𰸡�

     ���磬�������� nums = [-1��2��1��-4], �� target = 1.

     �� target ��ӽ����������ĺ�Ϊ 2. (-1 + 2 + 1 = 2).
     *
     */

    /**
     * ��ͨ����
     *
     * @param nums
     * @param target
     * @return
     */
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int ans = nums[0] + nums[1] + nums[2];
        for(int i=0;i<nums.length;i++) {
            int start = i+1, end = nums.length - 1;
            while(start < end) {
                int sum = nums[start] + nums[end] + nums[i];
                if(Math.abs(target - sum) < Math.abs(target - ans))
                    ans = sum;
                if(sum > target)
                    end--;
                else if(sum < target)
                    start++;
                else
                    return ans;
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        int[] strs = new int[]{1, 2, 3};
        Subject16 subject = new Subject16();
        System.out.println(subject.threeSumClosest(strs, 7));
    }
}
