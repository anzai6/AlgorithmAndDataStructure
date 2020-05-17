package com.example.lib.course58_exercise.solution;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * �����������ֵ
 * https://leetcode-cn.com/problems/sliding-window-maximum/
 */

public class SlidingWindowMaximumSolution {

    /**
     *

     ����һ������ nums����һ����СΪ k �Ļ������ڴ������������ƶ�����������Ҳࡣ
     ��ֻ���Կ����ڻ������� k �ڵ����֡���������ÿ��ֻ�����ƶ�һλ��

     ���ػ����������ֵ��

     ʾ��:

     ����: nums = [1,3,-1,-3,5,3,6,7], �� k = 3
     ���: [3,3,5,5,6,7]
     ����:

     �������ڵ�λ��                ���ֵ
     ---------------               -----
     [1  3  -1] -3  5  3  6  7       3
     1 [3  -1  -3] 5  3  6  7       3
     1  3 [-1  -3  5] 3  6  7       5
     1  3  -1 [-3  5  3] 6  7       5
     1  3  -1  -3 [5  3  6] 7       6
     1  3  -1  -3  5 [3  6  7]      7
     ע�⣺

     ����Լ��� k ������Ч�ģ�1 �� k �� ��������Ĵ�С�����������鲻Ϊ�ա�

     ���ף�

     ����������ʱ�临�Ӷ��ڽ��������

     */

    /**
     * @param nums
     * @param k
     * @return
     */

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k > nums.length || k <= 0)
            return new int[0];
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (o1 < o2)
                    return 1;
                else if (o1 > o2)
                    return -1;
                return 0;
            }
        });
        int len = nums.length;
        int[] results = new int[len - k + 1];
        for (int i = 0; i < len; i++) {
            queue.add(nums[i]);
            if (i >= k)
                queue.remove(nums[i - k]);
            if (i >= k - 1)
                results[i - k + 1] = queue.peek();
        }

        return results;
    }

    public static void main(String[] args) {
        SlidingWindowMaximumSolution slidingWindowMaximumSolution = new SlidingWindowMaximumSolution();
        int[] data = new int[]{1};
        int[] results = slidingWindowMaximumSolution.maxSlidingWindow(data, 1);
        for (int i = 0; i < results.length; i++) {
            System.out.print(" " + results[i]);
        }
    }
}
