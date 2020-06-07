package com.example.lib.course58_exercise.solution;

import java.util.Stack;

/**
 * 逆波兰表达式求值
 * https://leetcode-cn.com/problems/evaluate-reverse-polish-notation/
 */

public class ReversePolishNotatioSolution {

    /**
     *

     根据逆波兰表示法，求表达式的值。

     有效的运算符包括 +, -, *, / 。每个运算对象可以是整数，也可以是另一个逆波兰表达式。

     说明：

     整数除法只保留整数部分。
     给定逆波兰表达式总是有效的。换句话说，表达式总会得出有效数值且不存在除数为 0 的情况。
     示例 1：

     输入: ["2", "1", "+", "3", "*"]
     输出: 9
     解释: ((2 + 1) * 3) = 9
     示例 2：

     输入: ["4", "13", "5", "/", "+"]
     输出: 6
     解释: (4 + (13 / 5)) = 6
     示例 3：

     输入: ["10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"]
     输出: 22
     解释:
     ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
     = ((10 * (6 / (12 * -11))) + 17) + 5
     = ((10 * (6 / -132)) + 17) + 5
     = ((10 * 0) + 17) + 5
     = (0 + 17) + 5
     = 17 + 5
     = 22

     *
     *
     */


    /**
     * @param tokens
     * @return
     */
    public int evalRPN(String[] tokens) {
        if (tokens == null || tokens.length == 0)
            return -1;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
            String str = tokens[i];
            if (isOperationStr(str)) { // 运算符
                Integer strNum2 = stack.pop();
                Integer strNum1 = stack.pop();
                stack.push(numOperation(strNum1, strNum2, str));
            } else {
                stack.push(Integer.parseInt(str));
            }
        }
        return stack.pop();
    }

    private Integer numOperation(Integer num1, Integer num2, String operationStr) {
        if ("-".equals(operationStr)) {
            return num1 - num2;
        } else if ("+".equals(operationStr)) {
            return num1 + num2;
        } else if ("*".equals(operationStr)) {
            return num1 * num2;
        } else if ("/".equals(operationStr)) {
            return num1 / num2;
        }
        return 0;
    }

    public boolean isOperationStr(String str) {
        return "-".equals(str) || "+".equals(str) || "*".equals(str) || "/".equals(str);
    }
}
