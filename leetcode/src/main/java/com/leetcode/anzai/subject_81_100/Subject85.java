package com.leetcode.anzai.subject_81_100;

import java.util.Stack;

/**
 * ������
 * https://leetcode-cn.com/problems/maximal-rectangle/
 */
public class Subject85 {

    /**
     *
     ����һ�������� 0 �� 1 �Ķ�ά�����ƾ����ҳ�ֻ���� 1 �������Σ��������������

     ʾ��:

     ����:
     [
     ["1","0","1","0","0"],
     ["1","0","1","1","1"],
     ["1","1","1","1","1"],
     ["1","0","0","1","0"]
     ]
     ���: 6
     *
     */

    /**
     * û�������������84����ϵ��������ÿһ�е���һ����״ͼ�ĺ������飬Ȼ��ͳ�Ƹ߶ȣ����������е����ݣ���ǰ�е�ֵ��0�߶Ⱦ���0����1�����ͬ��ǰһ�е�ֵ��һ��
     * ͨ��84��ջ˼ά������ľ��������Ȼ��ȥ�����������ֵ
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
                if (i == 0) { // ��һ��ֱ�Ӹ�ֵ
                    heights[j] = matrix[i][j] - '0';
                } else {
                    // ��ǰ�е�ֵ�� '0' �߶Ⱦ���0���� '1' �����ͬ����һ�е�ֵ��һ
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
     * 84������
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
                // �γɾ��ε������������stack.peek()�����ұ���i�����Ҳ�����stack.peek()��i��ֻ�������м�Ĳ���
                maxArea = Math.max(maxArea, heights[stack.pop()] * (i - stack.peek() - 1));
            }
            stack.push(i);
        }
        while (stack.peek() != -1) {
            // ��������湫ʽ�������ǵ�������β���ˣ�û������һλ�����γɵľ��ε����ұ߿��Կ�����heights.length
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
