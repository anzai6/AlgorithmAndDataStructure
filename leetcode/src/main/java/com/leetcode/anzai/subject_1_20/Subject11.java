package com.leetcode.anzai.subject_1_20;

/**
 * 盛最多水的容器
 * https://leetcode-cn.com/problems/container-with-most-water/
 */
public class Subject11 {

    /**
     *
     给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点?(i,?ai) 。在坐标内画 n 条垂直线，垂直线 i?的两个端点分别为?(i,?ai) 和 (i, 0)。找出其中的两条线，使得它们与?x?轴共同构成的容器可以容纳最多的水。

     说明：你不能倾斜容器，且?n?的值至少为 2。

     subject_11.jpg

     图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为?49。

     ?

     示例:

     输入: [1,8,6,2,5,4,8,3,7]
     输出: 49
     *
     */

    /**
     * 官方解法：左右尽头双指针，小的指针往中间移动，直到找到最大区域
     * 注意：是小的指针往中间移动，因为往中间移动宽度会减少，所以需要移动的是小指针，这样高度才可能变大，
     * 如果移动的是大指针，那最大高度就只能是小指针的值，所以是无效的
     *
     * @param height
     * @return
     */
    public int maxArea(int[] height) {
        if (height == null || height.length < 2)
            return 0;
        int maxArea = Integer.MIN_VALUE;
        int low = 0; // 左边的指针
        int high = height.length - 1; // 右边的指针
        while (low < high) {
            int lowValue = height[low];
            int highValue = height[high];
            int minValue = lowValue;
            int interval = high - low;
            if (lowValue >= highValue) {
                minValue = highValue;
                high--;
            } else {
                low++;
            }
            int area = interval * minValue;
            if (area > maxArea)
                maxArea = area;
        }
        return maxArea;
    }


    /**
     * 普通解法：全遍历
     *
     * @param height
     * @return
     */
    public int maxArea1(int[] height) {
        if (height == null || height.length < 2)
            return 0;
        int maxArea = Integer.MIN_VALUE;
        for (int i = 0; i < height.length - 1; i++) {
            for (int j = i + 1; j < height.length; j++) {
                int area = (j - i) * Math.min(height[i], height[j]);
                if (area > maxArea)
                    maxArea = area;
            }
        }
        return maxArea;
    }


    public static void main(String[] args) {
        int[] height = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};
        Subject11 subject = new Subject11();
        System.out.println(subject.maxArea(height));
    }
}
