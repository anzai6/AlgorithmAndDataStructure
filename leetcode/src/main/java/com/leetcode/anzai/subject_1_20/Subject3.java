package com.leetcode.anzai.subject_1_20;

import java.util.HashMap;

/**
 * ���ظ��ַ�����Ӵ�
 * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 */
public class Subject3 {

    /**
     * ����һ���ַ����������ҳ����в������ظ��ַ��� ��Ӵ� �ĳ��ȡ�
     * <p>
     * ʾ�� 1:
     * ����: "abcabcbb"
     * ���: 3
     * ����: ��Ϊ���ظ��ַ�����Ӵ��� "abc"�������䳤��Ϊ 3��
     * <p>
     * ʾ�� 2:
     * ����: "bbbbb"
     * ���: 1
     * ����: ��Ϊ���ظ��ַ�����Ӵ��� "b"�������䳤��Ϊ 1��
     * <p>
     * ʾ�� 3:
     * ����: "pwwkew"
     * ���: 3
     * ����: ��Ϊ���ظ��ַ�����Ӵ��� "wke"�������䳤��Ϊ 3��
     * ��ע�⣬��Ĵ𰸱����� �Ӵ� �ĳ��ȣ�"pwke" ��һ�������У������Ӵ���
     */

    /**
     * �Ľ��棺
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        if (s == null)
            return 0;
        int maxLen = 0;
        HashMap<Character, Integer> hashMap = new HashMap();
        int i = 0;
        int begin = 0; // ���
        while (i < s.length()) {
            char value = s.charAt(i);
            if (hashMap.containsKey(value) && hashMap.get(value) >= begin) { // ��������ͬ���ַ�
                if (maxLen < i - begin)
                    maxLen = i - begin;
                begin = hashMap.get(value) + 1; // �µ���㣺��ǰ����ͬ���ַ���ǰһλ���¿�ʼ����
            } else {
                hashMap.put(value, i);
                ++i;
                if (maxLen < i - begin)
                    maxLen = i - begin;
            }
        }

        return maxLen;
    }

    /**
     * ��ͼ��ķ��������α����Ž�HashMap
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring1(String s) {
        if (s == null)
            return 0;
        int maxLen = 0;
        HashMap<Character, Integer> hashMap = new HashMap();
        int i = 0;
        while (i < s.length()) {
            char value = s.charAt(i);
            if (hashMap.containsKey(value)) { // ��������ͬ���ַ�
                if (maxLen < hashMap.size())
                    maxLen = hashMap.size();
                i = hashMap.get(value) + 1; // ����ͬ���ַ���ǰһλ���¿�ʼ����
                hashMap.clear();
            } else {
                hashMap.put(value, i);
                ++i;
                if (maxLen < hashMap.size())
                    maxLen = hashMap.size();
            }
        }

        return maxLen;
    }

    public static void main(String[] args) {
        Subject3 subject = new Subject3();
        System.out.println(subject.lengthOfLongestSubstring(" a"));
    }
}
