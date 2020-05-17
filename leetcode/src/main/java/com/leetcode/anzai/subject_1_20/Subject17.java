package com.leetcode.anzai.subject_1_20;

import java.util.ArrayList;
import java.util.List;

/**
 * �绰�������ĸ���
 * https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/
 */
public class Subject17 {

    /**
     *
     ����һ������������?2-9?���ַ����������������ܱ�ʾ����ĸ��ϡ�

     �������ֵ���ĸ��ӳ�����£���绰������ͬ����ע�� 1 ����Ӧ�κ���ĸ��

     Subject17.png

     ʾ��:

     ���룺"23"
     �����["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
     ˵��:
     ��������Ĵ��ǰ��ֵ������еģ��������������ѡ��������˳��
     *
     */

    /**
     * @param digits
     * @return
     */
    public List<String> letterCombinations(String digits) {
        List<String> list = new ArrayList<>();
        if (digits == null || digits.length() == 0)
            return list;
        letterCombinationsInternal(digits, 0, list, new StringBuilder());
        return list;
    }

    /**
     * �ݹ�
     *
     * @param digits
     * @param i
     * @param list
     * @param sb
     */
    private void letterCombinationsInternal(String digits, int i, List<String> list, StringBuilder sb) {
        String charStr = numDicts[digits.charAt(i) - '2'];
        for (int j = 0; j < charStr.length(); j++) {
            char value = charStr.charAt(j);
            sb.append(value);
            if (i == digits.length() - 1) {
                list.add(sb.toString());
            } else {
                letterCombinationsInternal(digits, i + 1, list, sb);
            }
            sb.deleteCharAt(sb.length() - 1); // ɾ�����һλ�������ǹؼ�
        }
    }

    static String[] numDicts = new String[]{"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public static void main(String[] args) {
        Subject17 subject = new Subject17();
        List<String> list = subject.letterCombinations("23");
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }

    }
}
