package com.leetcode.anzai.subject_21_40;

import java.util.ArrayList;
import java.util.List;

/**
 * ��������
 * https://leetcode-cn.com/problems/generate-parentheses/
 */
public class Subject22 {

    /**
     *
     ����?n?�����������ŵĶ���������д��һ��������ʹ���ܹ��������п��ܵĲ�����Ч��������ϡ�

     ���磬����?n = 3�����ɽ��Ϊ��

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
     * ���õݹ�
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
     * �ݹ�
     *
     * @param n         ���Ŷ���
     * @param i         ��ǰ�Ѿ�ƥ���˼����ַ�
     * @param list
     * @param sb        �����ַ���
     * @param leftCount ��δƥ����ַ�"("�ĸ��������Ȳ��ܳ���n
     */
    private void generateParenthesisInternal(int n, int i, List<String> list, StringBuilder sb, int leftCount) {
        if (i == n) { // ��������
            if (leftCount == 0)
                list.add(sb.toString());
            return;
        }
        if (leftCount + i < n) { // "("�ĸ�����û����n��ʱ
            // ���"("
            sb.append('(');
            generateParenthesisInternal(n, i, list, sb, leftCount + 1);
            sb.deleteCharAt(sb.length() - 1); // ɾ�����һ������һ���ܹؼ�

            if (leftCount > 0) { // ��"("�������")"
                // ���"("
                sb.append(')');
                generateParenthesisInternal(n, i + 1, list, sb, leftCount - 1);
                sb.deleteCharAt(sb.length() - 1); // ɾ�����һ������һ���ܹؼ�
            }
        } else {
            if (leftCount > 0) { // ��"("�������")"
                // ���"("
                sb.append(')');
                generateParenthesisInternal(n, i + 1, list, sb, leftCount - 1);
                sb.deleteCharAt(sb.length() - 1); // ɾ�����һ������һ���ܹؼ�
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
