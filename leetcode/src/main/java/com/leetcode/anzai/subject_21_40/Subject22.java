package com.leetcode.anzai.subject_21_40;

import java.util.ArrayList;
import java.util.List;

/**
 * 括号生成
 * https://leetcode-cn.com/problems/generate-parentheses/
 */
public class Subject22 {

    /**
     *
     给出?n?代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。

     例如，给出?n = 3，生成结果为：

     [
     "((()))",
     "(()())",
     "(())()",
     "()(())",
     "()()()"
     ]
     *
     */

    /**
     * 采用递归
     *
     * @param n
     * @return
     */
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        if (n <= 0)
            return list;
        StringBuilder sb = new StringBuilder();
        generateParenthesisInternal(n, 0, list, sb, 0);
        return list;
    }

    /**
     * 递归
     *
     * @param n         括号对数
     * @param i         当前已经匹配了几对字符
     * @param list
     * @param sb        保存字符串
     * @param leftCount 尚未匹配的字符"("的个数，长度不能超过n
     */
    private void generateParenthesisInternal(int n, int i, List<String> list, StringBuilder sb, int leftCount) {
        if (i == n) { // 对数够了
            if (leftCount == 0)
                list.add(sb.toString());
            return;
        }
        if (leftCount + i < n) { // "("的个数还没到达n个时
            // 添加"("
            sb.append('(');
            generateParenthesisInternal(n, i, list, sb, leftCount + 1);
            sb.deleteCharAt(sb.length() - 1); // 删除最后一个，这一步很关键

            if (leftCount > 0) { // 有"("才能添加")"
                // 添加"("
                sb.append(')');
                generateParenthesisInternal(n, i + 1, list, sb, leftCount - 1);
                sb.deleteCharAt(sb.length() - 1); // 删除最后一个，这一步很关键
            }
        } else {
            if (leftCount > 0) { // 有"("才能添加")"
                // 添加"("
                sb.append(')');
                generateParenthesisInternal(n, i + 1, list, sb, leftCount - 1);
                sb.deleteCharAt(sb.length() - 1); // 删除最后一个，这一步很关键
            }
        }
    }


    public static void main(String[] args) {
        Subject22 subject = new Subject22();
        List<String> list = subject.generateParenthesis(4);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i) + " ");
        }
    }
}
