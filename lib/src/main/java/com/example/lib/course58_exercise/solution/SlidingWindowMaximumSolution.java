package com.example.lib.course58_exercise.solution;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 滑动窗口最大值
 * https://leetcode-cn.com/problems/sliding-window-maximum/
 */

public class SlidingWindowMaximumSolution {

    /**
     *

     给定一个数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。
     你只可以看到在滑动窗口 k 内的数字。滑动窗口每次只向右移动一位。

     返回滑动窗口最大值。

     示例:

     输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
     输出: [3,3,5,5,6,7]
     解释:

     滑动窗口的位置                最大值
     ---------------               -----
     [1  3  -1] -3  5  3  6  7       3
     1 [3  -1  -3] 5  3  6  7       3
     1  3 [-1  -3  5] 3  6  7       5
     1  3  -1 [-3  5  3] 6  7       5
     1  3  -1  -3 [5  3  6] 7       6
     1  3  -1  -3  5 [3  6  7]      7
     注意：

     你可以假设 k 总是有效的，1 ≤ k ≤ 输入数组的大小，且输入数组不为空。

     进阶：

     你能在线性时间复杂度内解决此题吗？

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
