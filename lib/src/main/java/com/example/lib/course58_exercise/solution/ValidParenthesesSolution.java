package com.example.lib.course58_exercise.solution;

import java.util.HashMap;
import java.util.Stack;

/**
 * 有效的括号
 * https://leetcode-cn.com/problems/valid-parentheses/
 */

public class ValidParenthesesSolution {

//    给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
//
//    有效字符串需满足：
//
//    左括号必须用相同类型的右括号闭合。
//    左括号必须以正确的顺序闭合。
//    注意空字符串可被认为是有效字符串。

    /**
     * 网友改进版
     * @param s
     * @return
     */
    public boolean isValid(String s) {
        // 奇数以及右括号开头的肯定不符合标准，先排除
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
            if (mHashMap.containsKey(str)) { // 左括号
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
