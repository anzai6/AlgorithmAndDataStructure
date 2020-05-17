package com.example.lib.course63_exercise.solution;

/**
 * 乘积最大子序列
 * https://leetcode-cn.com/problems/maximum-product-subarray/
 */
public class MaximumProductSubarraySolution {

    /**
     *
     给定一个整数数组 nums，找出一个序列中乘积最大的连续子序列（该序列至少包含一个数）。

     示例 1:
     输入: [2,3,-2,4]
     输出: 6
     解释:子数组 [2,3] 有最大乘积 6。

     示例 2:
     输入: [-2,0,-1]
     输出: 0
     解释:结果不能为 2, 因为 [-2,-1] 不是子数组。

     *
     */

    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int max = nums[0], min = nums[0], res = nums[0];
        for(int i = 1; i < nums.length; i++){
            if(nums[i] < 0){
                int tmp = max;
                max = min;
                min = tmp;
            }
            max = Math.max(nums[i], max * nums[i]);
            min = Math.min(nums[i], min * nums[i]);
            res = Math.max(max, res);
        }
        return res;
    }

    /**
     * 遍历所有结果
     * @param nums
     * @return
     */
    public int maxProduct1(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int len = nums.length;

        int maxProduct = nums[0];

        for (int i = 1; i < len; i++) {
            int product = 1;
            for (int j = i; j >= 0; j--) {
                product *= nums[j]; // 依次和前面的数字累乘
                if (product > maxProduct)
                    maxProduct = product;
            }
        }

        return maxProduct;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, -5, -2, -4, 3};
//        int[] nums = new int[]{3,-1,4};
//        int[] nums = new int[]{-2,0,-1};
//        int[] nums = new int[]{2, 3, -2, 4};
        MaximumProductSubarraySolution solution = new MaximumProductSubarraySolution();
        System.out.println(solution.maxProduct(nums) + "");
    }
}
