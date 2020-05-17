package com.leetcode.anzai.subject_81_100;

import java.util.Stack;

/**
 * 柱状图中最大的矩形
 * https://leetcode-cn.com/problems/largest-rectangle-in-histogram/
 */
public class Subject84 {

    /**
     *
     给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。

     求在该柱状图中，能够勾勒出来的矩形的最大面积。


     Subject84_1.png


     以上是柱状图的示例，其中每个柱子的宽度为 1，给定的高度为  [2,1,5,6,2,3]。


     Subject84_2.png


     图中阴影部分为所能勾勒出的最大矩形面积，其面积为  10  个单位。



     示例:

     输入: [2,1,5,6,2,3]
     输出: 10

     *
     */

    /**
     * 初步思想，没什么思路，直觉应该是回溯算法或者动态规划,但想不出来，看解题才知道完全像错了，是用栈，但依旧算不好理解
     *
     * @param heights
     * @return
     */
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int maxarea = 0;
        for (int i = 0; i < heights.length; ++i) {
            while (stack.peek() != -1 && heights[stack.peek()] >= heights[i]) {
                // 形成矩形的最左边坐标是stack.peek()，最右边是i，而且不包括stack.peek()和i，只是它们中间的部分
                maxarea = Math.max(maxarea, heights[stack.pop()] * (i - stack.peek() - 1));
            }
            stack.push(i);
        }
        while (stack.peek() != -1) {
            // 这里跟上面公式的区别是到达数组尾部了，没有了下一位数，形成的矩形的最右边可以看做是heights.length
            maxarea = Math.max(maxarea, heights[stack.pop()] * (heights.length - stack.peek() - 1));
        }
        return maxarea;
    }

    public static void main(String[] args) {
        int[] heights = new int[]{2, 1, 5, 6, 3, 3};
//        heights = new int[]{2,  3};

        Subject84 subject = new Subject84();
        System.out.println(subject.largestRectangleArea(heights));
    }

}
