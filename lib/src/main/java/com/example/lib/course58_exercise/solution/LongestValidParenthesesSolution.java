package com.example.lib.course58_exercise.solution;

import java.util.Stack;

/**
 * ���Ч������
 * https://leetcode-cn.com/problems/longest-valid-parentheses/
 */

public class LongestValidParenthesesSolution {
//
//    ����һ��ֻ���� '(' �� ')' ���ַ������ҳ���İ�����Ч���ŵ��Ӵ��ĳ��ȡ�
//
//    ʾ�� 1:
//
//    ����: "(()"
//    ���: 2
//    ����: ���Ч�����Ӵ�Ϊ "()"
//    ʾ�� 2:
//
//    ����: ")()())"
//    ���: 4
//    ����: ���Ч�����Ӵ�Ϊ "()()"
//
//    ����: "(()())"
//    ���: 6
//    ����: ���Ч�����Ӵ�Ϊ "(()())"

    /**
     * �ٷ����
     * �����ַ����У������������������� leftleft �� rightright �����ȣ����Ǵ����ұ����ַ���������������ÿ�� ��(������������ leftleft ��������
     * ����������ÿ�� ��)�� ���������� rightright ��������ÿ�� leftleft �������� rightright ���������ʱ�����Ǽ��㵱ǰ��Ч�ַ����ĳ��ȣ�
     * ���Ҽ�¼ĿǰΪֹ�ҵ�������ַ�������� rightright �������� leftleft ��������ʱ�����ǽ� leftleft �� rightright ������ͬʱ��� 0 ��
     * �����������Ǵ��ҵ�����һ�����ƵĹ����������������ɼ�������Ч���ŵĳ���
     *
     * @param s
     * @return
     */
    public int longestValidParentheses(String s) {
        int left = 0, right = 0, maxlength = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
            if (left == right) {
                maxlength = Math.max(maxlength, 2 * right);
            } else if (right >= left) {
                left = right = 0;
            }
        }
        left = right = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
            if (left == right) {
                maxlength = Math.max(maxlength, 2 * left);
            } else if (left >= right) {
                left = right = 0;
            }
        }
        return maxlength;
    }

    /**
     * ����Ե�ȫ��������ʣ�µ�����м�������
     *
     * @param s
     * @return
     */
    public int longestValidParentheses1(String s) {
        if (s == null || "".equals(s))
            return 0;

        Stack<Character> stack = new Stack<>(); // ��¼����
        Stack<Integer> leftIndex = new Stack<>(); // ��¼���ŵ��±�
        char[] charList = s.toCharArray();
        int maxCount = 0;

        for (int i = 0; i < charList.length; i++) {
            char str = charList[i];
            if (')' == str) { // ������
                if (!stack.isEmpty()) {

                    char pre = stack.pop();
                    if (pre == '(') { // ����һ��
                        leftIndex.pop();
                    } else {
                        stack.push(pre); // �ӻ�ȥ
                        stack.push(str);
                        leftIndex.push(i);
                    }
                } else {
                    stack.push(str);
                    leftIndex.push(i);
                }

            } else { // ������
                stack.push(str);
                leftIndex.push(i);
            }
        }

        // �൱��������һ��������֮��ʣ�µ�ͨ����������м�εľ��룬����".)..(..(."3 6 13 14
        int nextIndex = charList.length; // ��λ
        while (!leftIndex.isEmpty()) {
            int currentIndex = leftIndex.pop();
            int count = nextIndex - currentIndex;
            if (count > maxCount)
                maxCount = count;
            nextIndex = currentIndex;
        }

        if (nextIndex > maxCount) // ���һ�������⴦����Ҫ��һ��Ϊ������ļ�һ
            maxCount = nextIndex + 1;
        return maxCount - 1;  // ������Ҫ��һ������5��2֮������λ������5-2=3

    }

    public static void main(String[] args) {
        LongestValidParenthesesSolution solution = new LongestValidParenthesesSolution();
        System.out.print("" + solution.longestValidParentheses("(()"));
    }
}
