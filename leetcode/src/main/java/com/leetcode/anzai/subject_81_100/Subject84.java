package com.leetcode.anzai.subject_81_100;

import java.util.Stack;

/**
 * ��״ͼ�����ľ���
 * https://leetcode-cn.com/problems/largest-rectangle-in-histogram/
 */
public class Subject84 {

    /**
     *
     ���� n ���Ǹ�������������ʾ��״ͼ�и������ӵĸ߶ȡ�ÿ�����ӱ˴����ڣ��ҿ��Ϊ 1 ��

     ���ڸ���״ͼ�У��ܹ����ճ����ľ��ε���������


     Subject84_1.png


     ��������״ͼ��ʾ��������ÿ�����ӵĿ��Ϊ 1�������ĸ߶�Ϊ  [2,1,5,6,2,3]��


     Subject84_2.png


     ͼ����Ӱ����Ϊ���ܹ��ճ�������������������Ϊ  10  ����λ��



     ʾ��:

     ����: [2,1,5,6,2,3]
     ���: 10

     *
     */

    /**
     * ����˼�룬ûʲô˼·��ֱ��Ӧ���ǻ����㷨���߶�̬�滮,���벻�������������֪����ȫ����ˣ�����ջ���������㲻�����
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
                // �γɾ��ε������������stack.peek()�����ұ���i�����Ҳ�����stack.peek()��i��ֻ�������м�Ĳ���
                maxarea = Math.max(maxarea, heights[stack.pop()] * (i - stack.peek() - 1));
            }
            stack.push(i);
        }
        while (stack.peek() != -1) {
            // ��������湫ʽ�������ǵ�������β���ˣ�û������һλ�����γɵľ��ε����ұ߿��Կ�����heights.length
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
