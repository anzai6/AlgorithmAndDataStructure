package com.example.lib.course58_exercise.solution;

import java.util.HashMap;
import java.util.Stack;

/**
 * ��Ч������
 * https://leetcode-cn.com/problems/valid-parentheses/
 */

public class ValidParenthesesSolution {

//    ����һ��ֻ���� '('��')'��'{'��'}'��'['��']' ���ַ������ж��ַ����Ƿ���Ч��
//
//    ��Ч�ַ��������㣺
//
//    �����ű�������ͬ���͵������űպϡ�
//    �����ű�������ȷ��˳��պϡ�
//    ע����ַ����ɱ���Ϊ����Ч�ַ�����

    /**
     * ���ѸĽ���
     * @param s
     * @return
     */
    public boolean isValid(String s) {
        // �����Լ������ſ�ͷ�Ŀ϶������ϱ�׼�����ų�
        if (s.length() % 2 == 1 || s.startsWith(")") || s.startsWith("}") || s.startsWith("]")) {
            return false;
        }
        Stack<Character> stack = new Stack<>();
        for (int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            }
            if (c == ')' && stack.peek()== '(') {
                stack.pop();
            } else if (c == '}' && stack.peek() == '{') {
                stack.pop();
            } else if (c == ']' && stack.peek() == '[') {
                stack.pop();
            }
        }
        return stack.size() == 0;
    }

    public boolean isValid1(String s) {
        if (s == null)
            return false;
        if ("".equals(s))
            return true;

        HashMap<String, String> mHashMap = new HashMap<>();
        mHashMap.put("(", ")");
        mHashMap.put("[", "]");
        mHashMap.put("{", "}");
        Stack<String> stack = new Stack<>();
        char[] charList = s.toCharArray();

        for (int i = 0; i < charList.length; i++) {
            String str = charList[i] + "";
            if (mHashMap.containsKey(str)) { // ������
                stack.push(str);
            } else {
                if(stack.isEmpty())
                    return false;
                String result = stack.pop();
                if (!str.equals(mHashMap.get(result))) return false;

            }
        }
        if (stack.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        ValidParenthesesSolution solution = new ValidParenthesesSolution();
        System.out.print("" + solution.isValid("{[]}"));
    }
}
