package com.leetcode.anzai.subject_41_60;

/**
 * 接雨水
 * https://leetcode-cn.com/problems/trapping-rain-water/
 */
public class Subject42 {

    /**
     *
     给定?n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。

     Subject42.png

     上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。?感谢 Marcos 贡献此图。

     示例:

     输入: [0,1,0,2,1,0,1,3,2,1,2,1]
     输出: 6
     *
     */

    /**
     * 先从左往右遍历，然后从右往左遍历
     * 主要是要知道最大值的位置，以他为中间点，左边从左往右遍历,右边从右往左遍历,这样就能算出所有的体积
     *
     * @param height
     * @return
     */
    public int trap(int[] height) {
        if (height == null || height.length == 0)
            return 0;
        int totalVolume = 0; // 总体积
        int maxValueIndex = 0; // 数组中最大值的下标

        // 从头到尾遍历
        for (int i = 0; i < height.length; ) {
            int startEdge = height[i];
            int currentVolume = 0;
            int j = i + 1;
            for (; j < height.length; j++) {
                int endEdge = height[j];
                if (endEdge >= startEdge) { // 遇到大于等于自己的边
                    if (j - 1 == i) {
                        startEdge = endEdge;
                        i = j;
                        continue;
                    } else {
                        i = j;
                        totalVolume += currentVolume;
                        break;
                    }
                } else { // 遇到小于自己的边
                    currentVolume += (startEdge - endEdge);
                }
            }
            maxValueIndex = i;
            if (j == height.length)
                break;
        }

        // 反过来从尾到头遍历,主要是有些还没有计算的，比如 3,1,2 必须从尾到头才能计算
        for (int i = height.length - 1; i >= maxValueIndex; ) {
            int startEdge = height[i];
            int currentVolume = 0;
            int j = i - 1;
            for (; j >= maxValueIndex; j--) {
                int endEdge = height[j];
                if (endEdge >= startEdge) { // 遇到大于等于自己的边
                    if (j - 1 == i) {
                        i = j;
                        continue;
                    } else {
                        i = j;
                        totalVolume += currentVolume;
                        break;
                    }
                } else { // 遇到小于自己的边
                    currentVolume += (startEdge - endEdge);
                }
            }
            if (j == maxValueIndex - 1)
                break;
        }

        return totalVolume;
    }


    public static void main(String[] args) {
        int[] candidates = new int[]{};
        Subject42 subject = new Subject42();
        System.out.println(subject.trap(candidates));
    }

}
