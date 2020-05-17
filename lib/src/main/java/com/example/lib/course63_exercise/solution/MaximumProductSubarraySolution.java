package com.example.lib.course63_exercise.solution;

/**
 * �˻����������
 * https://leetcode-cn.com/problems/maximum-product-subarray/
 */
public class MaximumProductSubarraySolution {

    /**
     *
     ����һ���������� nums���ҳ�һ�������г˻��������������У����������ٰ���һ��������

     ʾ�� 1:
     ����: [2,3,-2,4]
     ���: 6
     ����:������ [2,3] �����˻� 6��

     ʾ�� 2:
     ����: [-2,0,-1]
     ���: 0
     ����:�������Ϊ 2, ��Ϊ [-2,-1] ���������顣

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
     * �������н��
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
                product *= nums[j]; // ���κ�ǰ��������۳�
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
