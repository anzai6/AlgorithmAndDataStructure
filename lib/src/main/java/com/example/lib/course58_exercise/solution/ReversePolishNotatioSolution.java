package com.example.lib.course58_exercise.solution;

import java.util.Stack;

/**
 * �沨�����ʽ��ֵ
 * https://leetcode-cn.com/problems/evaluate-reverse-polish-notation/
 */

public class ReversePolishNotatioSolution {

    /**
     *

     �����沨����ʾ��������ʽ��ֵ��

     ��Ч����������� +, -, *, / ��ÿ��������������������Ҳ��������һ���沨�����ʽ��

     ˵����

     ��������ֻ�����������֡�
     �����沨�����ʽ������Ч�ġ����仰˵�����ʽ�ܻ�ó���Ч��ֵ�Ҳ����ڳ���Ϊ 0 �������
     ʾ�� 1��

     ����: ["2", "1", "+", "3", "*"]
     ���: 9
     ����: ((2 + 1) * 3) = 9
     ʾ�� 2��

     ����: ["4", "13", "5", "/", "+"]
     ���: 6
     ����: (4 + (13 / 5)) = 6
     ʾ�� 3��

     ����: ["10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"]
     ���: 22
     ����:
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
            if (isOperationStr(str)) { // �����
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
