package com.leetcode.anzai.subject_81_100;

import java.util.Stack;

/**
 * 最大矩形
 * https://leetcode-cn.com/problems/maximal-rectangle/
 */
public class Subject85 {

    /**
     *
     给定一个仅包含 0 和 1 的二维二进制矩阵，找出只包含 1 的最大矩形，并返回其面积。

     示例:

     输入:
     [
     ["1","0","1","0","0"],
     ["1","0","1","1","1"],
     ["1","1","1","1","1"],
     ["1","0","0","1","0"]
     ]
     输出: 6
     *
     */

    /**
     * 没想出来，看题解跟84题联系起来，将每一行当做一个柱状图的横轴数组，然后统计高度（比如例子中的数据，当前行的值是0高度就是0，是1则等于同列前一行的值加一）
     * 通过84题栈思维求出最大的矩形面积，然后去所有行中最大值
     *
     * @param matrix
     * @return
     */
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        int maxArea = Integer.MIN_VALUE;
        int[] heights = new int[matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (i == 0) { // 第一行直接赋值
                    heights[j] = matrix[i][j] - '0';
                } else {
                    // 当前行的值是 '0' 高度就是0，是 '1' 则等于同列上一行的值加一
                    heights[j] = matrix[i][j] == '0' ? 0 : ++heights[j];
                }
            }
            int area = largestRectangleArea(heights);
            if (area > maxArea) {
                maxArea = area;
            }
        }

        return maxArea;
    }

    /**
     * 84题的题解
     *
     * @param heights
     * @return
     */
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int maxArea = 0;
        for (int i = 0; i < heights.length; ++i) {
            while (stack.peek() != -1 && heights[stack.peek()] >= heights[i]) {
                // 形成矩形的最左边坐标是stack.peek()，最右边是i，而且不包括stack.peek()和i，只是它们中间的部分
                maxArea = Math.max(maxArea, heights[stack.pop()] * (i - stack.peek() - 1));
            }
            stack.push(i);
        }
        while (stack.peek() != -1) {
            // 这里跟上面公式的区别是到达数组尾部了，没有了下一位数，形成的矩形的最右边可以看做是heights.length
            maxArea = Math.max(maxArea, heights[stack.pop()] * (heights.length - stack.peek() - 1));
        }
        return maxArea;
    }

    public static void main(String[] args) {
        char[][] matrix = new char[][]{
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}};

        Subject85 subject = new Subject85();
        System.out.println(subject.maximalRectangle(matrix));
    }

}
