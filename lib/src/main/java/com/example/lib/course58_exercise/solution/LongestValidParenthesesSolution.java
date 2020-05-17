package com.example.lib.course58_exercise.solution;

import java.util.Stack;

/**
 * 最长有效的括号
 * https://leetcode-cn.com/problems/longest-valid-parentheses/
 */

public class LongestValidParenthesesSolution {
//
//    给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。
//
//    示例 1:
//
//    输入: "(()"
//    输出: 2
//    解释: 最长有效括号子串为 "()"
//    示例 2:
//
//    输入: ")()())"
//    输出: 4
//    解释: 最长有效括号子串为 "()()"
//
//    输入: "(()())"
//    输出: 6
//    解释: 最长有效括号子串为 "(()())"

    /**
     * 官方解答：
     * 在这种方法中，我们利用两个计数器 leftleft 和 rightright 。首先，我们从左到右遍历字符串，对于遇到的每个 ‘(’，我们增加 leftleft 计算器，
     * 对于遇到的每个 ‘)’ ，我们增加 rightright 计数器。每当 leftleft 计数器与 rightright 计数器相等时，我们计算当前有效字符串的长度，
     * 并且记录目前为止找到的最长子字符串。如果 rightright 计数器比 leftleft 计数器大时，我们将 leftleft 和 rightright 计数器同时变回 0 。
     * 接下来，我们从右到左做一遍类似的工作。两遍下来即可计算出最长有效括号的长度
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
     * 把配对的全部消掉，剩下的求出中间间隔即可
     *
     * @param s
     * @return
     */
    public int longestValidParentheses1(String s) {
        if (s == null || "".equals(s))
            return 0;

        Stack<Character> stack = new Stack<>(); // 记录括号
        Stack<Integer> leftIndex = new Stack<>(); // 记录括号的下标
        char[] charList = s.toCharArray();
        int maxCount = 0;

        for (int i = 0; i < charList.length; i++) {
            char str = charList[i];
            if (')' == str) { // 右括号
                if (!stack.isEmpty()) {

                    char pre = stack.pop();
                    if (pre == '(') { // 消掉一组
                        leftIndex.pop();
                    } else {
                        stack.push(pre); // 加回去
                        stack.push(str);
                        leftIndex.push(i);
                    }
                } else {
                    stack.push(str);
                    leftIndex.push(i);
                }

            } else { // 左括号
                stack.push(str);
                leftIndex.push(i);
            }
        }

        // 相当于消消乐一样，消掉之后剩下的通过减法求出中间段的距离，比如".)..(..(."3 6 13 14
        int nextIndex = charList.length; // 高位
        while (!leftIndex.isEmpty()) {
            int currentIndex = leftIndex.pop();
            int count = nextIndex - currentIndex;
            if (count > maxCount)
                maxCount = count;
            nextIndex = currentIndex;
        }

        if (nextIndex > maxCount) // 最后一个，特殊处理，需要加一，为了下面的减一
            maxCount = nextIndex + 1;
        return maxCount - 1;  // 这里需要减一，比如5和2之间间隔两位，但是5-2=3

    }

    public static void main(String[] args) {
        LongestValidParenthesesSolution solution = new LongestValidParenthesesSolution();
        System.out.print("" + solution.longestValidParentheses("(()"));
    }
}
