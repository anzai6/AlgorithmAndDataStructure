package com.leetcode.anzai.subject_61_80;

import java.util.HashMap;

/**
 * ��С�����Ӵ�
 * https://leetcode-cn.com/problems/minimum-window-substring/
 */
public class Subject76 {

    /**
     *
     ����һ���ַ��� S��һ���ַ��� T�������ַ��� S �����ҳ������� T ������ĸ����С�Ӵ���

     ʾ����

     ����: S = "ADOBECODEBANC", T = "ABC"
     ���: "BANC"
     ˵����

     ��� S �в����������Ӵ����򷵻ؿ��ַ��� ""��
     ��� S �д����������Ӵ������Ǳ�֤����Ψһ�Ĵ𰸡�
     *
     */

    /**
     * �������Ѻ͹ٷ����ʹ�û������ڣ���������һ���������ָ�룬һ��������ʱ����һ������
     * �����˼·�ǣ�
     * 1.����ָ�� left �� right ��0��ʼ��
     * 2.��ָ�� right �����ƶ�ֱ�� [left, right] ������ַ������� t �ַ�����
     * 3.ֹͣ right �ƶ���Ȼ�� left ��ָ�������ƶ���ֱ�� [left, right] �պò����� t �ַ������м䲻�ϸ������������������С�Ӵ���
     * 4.�ظ����� 2 �� 3 ֱ�� right ָ�뵽�� s �ַ������յ㡣
     *
     * @param s
     * @param t
     * @return
     */
    public String minWindow(String s, String t) {
        if (s == null || s.length() == 0 || t == null
                || t.length() == 0 || t.length() > s.length()) {
            return "";
        }

        // T �ַ����������ַ������� subHashMap��
        HashMap<Character, Integer> targetHashMap = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            targetHashMap.put(t.charAt(i), targetHashMap.getOrDefault(t.charAt(i), 0) + 1);
        }

        int left = 0;
        int right = 0; // ��ָ��
        int count = 0;  //  [left, right] ����������� t ���ַ����ĸ������� count == t.length() ʱ�������㸲���Ӵ�Ҫ��
        // sourceHashMap: T �ַ������ַ��� S �е� [left, right] λ��ȫ��¼
        HashMap<Character, Integer> sourceHashMap = new HashMap<>();

        int minSubStrLen = Integer.MAX_VALUE;
        int subStrStarIndex = -1;
        while (right < s.length()) {
            if (targetHashMap.containsKey(s.charAt(right))) {
                int rightCount = sourceHashMap.getOrDefault(s.charAt(right), 0);
                sourceHashMap.put(s.charAt(right), ++rightCount);
                // ע�⣬�����Զ�װ�䣬����ʹ��Integer == Integer ���� 127 �ǲ������ģ�����Ҫ�� .intValue() ���Ƚ�
                if (rightCount == targetHashMap.get(s.charAt(right))) {
                    count++;
                }

                while (count == targetHashMap.size()) { // ���㸲���Ӵ�Ҫ���ǰ���£������ƶ� left ָ��
                    if ((right - left) < minSubStrLen) {
                        subStrStarIndex = left;
                        minSubStrLen = right - left;
                    }
                    // �����ƶ� left ָ��
                    if (sourceHashMap.containsKey(s.charAt(left))) {
                        int leftCount = sourceHashMap.get(s.charAt(left));
                        sourceHashMap.put(s.charAt(left), leftCount - 1);
                        if (leftCount == targetHashMap.get(s.charAt(left)).intValue()) {
                            count--;
                        }
                    }
                    left++;
                }
            }
            right++;
        }

        return subStrStarIndex == -1 ? "" : s.substring(subStrStarIndex, subStrStarIndex + minSubStrLen + 1);
    }


    public static void main(String[] args) {
//        String s = "ADOBECODEBANC";
//        String t = "ABC";
//        String s = "ABCODEBANC";
//        String t = "ABC";
        String s = "AA";
        String t = "AA";
        Subject76 subject = new Subject76();
        System.out.println(subject.minWindow(s, t));
    }

}
