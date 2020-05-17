package com.leetcode.anzai.subject_81_100;

import java.util.HashMap;

/**
 * �����ַ���
 * https://leetcode-cn.com/problems/scramble-string/
 */
public class Subject87 {

    /**
     *
     ����һ���ַ��� s1�����ǿ��԰����ݹ�طָ�������ǿ����ַ������Ӷ������ʾΪ��������

     ��ͼ���ַ��� s1 = "great" ��һ�ֿ��ܵı�ʾ��ʽ��

     great
     /      \
     gr      eat
     /  \    /   \
     g   r  e    at
     / \
     a   t
     ����������ַ����Ĺ����У����ǿ�����ѡ�κ�һ����Ҷ�ڵ㣬Ȼ�󽻻����������ӽڵ㡣

     ���磬���������ѡ��Ҷ�ڵ� "gr" ���������������ӽڵ㣬������������ַ��� "rgeat" ��
     rgeat
     /       \
     rg       eat
     /  \    /    \
     r   g  e     at
     / \
     a   t
     ���ǽ� "rgeat�� ���� "great" ��һ�������ַ�����

     ͬ���أ�������Ǽ��������ڵ� "eat" �� "at" ���ӽڵ㣬���������һ���µ������ַ��� "rgtae" ��

     rgtae
     /      \
     rg       tae
     / \      /  \
     r   g    ta  e
     / \
     t   a
     ���ǽ� "rgtae�� ���� "great" ��һ�������ַ�����

     ��������������ȵ��ַ��� s1 �� s2���ж� s2 �Ƿ��� s1 �������ַ�����

     ʾ�� 1:

     ����: s1 = "great", s2 = "rgeat"
     ���: true
     ʾ�� 2:

     ����: s1 = "abcde", s2 = "caebd"
     ���: false
     *
     */

    /**
     * ����˼·���ݹ�ⷨ�����ڶ���һ��Ϊ�������ֵģ����Կ��Խ������ַ�����һ��Ϊ����
     * Ȼ�������Ƚϣ�ע�ⲻֹ��ͬ�������Ƚϣ����ҲҪ�ȣ�Ȼ���ж��Ƿ���ĳ������ͬ��
     * <p>
     * �գ���ɶԵȷ��ˣ�ԭ����������ֵ�.....
     * �޸�Ϊ���������и���и�
     *
     * @param s1
     * @param s2
     * @return
     */
    public boolean isScramble(String s1, String s2) {
        if (s1 == null || s2 == null) {
            return false;
        }
        HashMap<String, Boolean> hashMap = new HashMap<>();
        return isScrambleRecursive(s1, s2, hashMap);
    }

    /**
     * �ݹ�ⷨ����ʵ�֣����ڳ���ʱ��������Ҫ���뱸��¼���������ɺ�����
     * �������������롰�ж������ַ���ÿ����ĸ���ֵĴ����Ƿ�һ�¡����Ż���Ч��������ͬʱ���ȥ������¼����
     *
     * @param s1
     * @param s2
     * @return
     */
    public boolean isScrambleRecursive(String s1, String s2, HashMap<String, Boolean> hashMap) {
        if (s1.length() != s2.length()) {
            return false;
        }
        if (s1.length() == 1) {
            return s1.equals(s2);
        }

        String key = new StringBuilder(s1).append("#").append(s2).toString();
        if (hashMap.containsKey(key)) {
            return hashMap.get(key);
        }

        //�ж������ַ���ÿ����ĸ���ֵĴ����Ƿ�һ��
        int[] letters = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            letters[s1.charAt(i) - 'a']++;
            letters[s2.charAt(i) - 'a']--;
        }
        //��������ַ�������ĸ���ֲ�һ��ֱ�ӷ��� false
        for (int i = 0; i < 26; i++) {
            if (letters[i] != 0) {
                hashMap.put(key, false);
                return false;
            }
        }

        // �� i Ϊ�ָ�㣬ע����������
        for (int i = 1; i < s1.length(); i++) {
            // �и���� s2 ͷ��
            if (isScrambleRecursive(s1.substring(0, i), s2.substring(0, i), hashMap)
                    && isScrambleRecursive(s1.substring(i), s2.substring(i), hashMap)) {
                hashMap.put(key, true);
                return true;
            }
            // �и���� s2 β��
            if (isScrambleRecursive(s1.substring(0, i), s2.substring(s2.length() - i), hashMap)
                    && isScrambleRecursive(s1.substring(i), s2.substring(0, s2.length() - i), hashMap)) {
                hashMap.put(key, true);
                return true;
            }
        }
        hashMap.put(key, false);
        return false;
    }


    public static void main(String[] args) {
        String s1 = "great";
        String s2 = "rgeat";
//        s1 = "great";
//        s2 = "rgtae";
//        s1 = "abcde";
//        s2 = "caebd";
//        s1 = "abab";
//        s2 = "aabb";
        Subject87 subject = new Subject87();
        System.out.print(subject.isScramble(s1, s2));
    }

}
