package com.leetcode.anzai.subject_1_20;

/**
 * ������Ӵ�
 * https://leetcode-cn.com/problems/longest-palindromic-substring/
 */
public class Subject5 {

    /**
     *
     ����һ���ַ��� s���ҵ� s ����Ļ����Ӵ�������Լ���?s ����󳤶�Ϊ 1000��

     ʾ�� 1��

     ����: "babad"
     ���: "bab"
     ע��: "aba" Ҳ��һ����Ч�𰸡�
     ʾ�� 2��

     ����: "cbbd"
     ���: "bb"

     ����: "cbcacbcb"
     ���: "cbcacbc"

     ����: "cbcacbcbcbcacb"
     ���: "bcacbcbcbcacb"

     ����: "cbcacbcbbcbcacb"
     ���: "bcacbcbbcbcacb"
     *
     */


    /**
     * �����汾����ÿһ���ַ�Ϊ�м����������ɢ���ҳ����Ļ����Ӵ�
     *
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        if (s == null || "".equals(s) || s.length() == 1)
            return s;
        char[] list = s.toCharArray();
        int maxLow = 0; // ������Ӵ��������
        int maxHigh = 0; // ������Ӵ��յ�����
        int maxLen = 0; // ������Ӵ�����
        for (int i = 0; i < list.length - 1; i++) {
            char center = list[i];
            int low = 0;
            int high = 0;

            // ż�������Ӵ�
            if (list[i + 1] == center) { // ��ǰһλ�� center ���,���磺bb
                low = i - 1;
                high = i + 2;
                while (low >= 0 && high <= list.length - 1) {
                    if (list[low] == list[high]) {
                        --low;
                        ++high;
                    } else
                        break;
                }
                int len = high - low - 1;
                if (len > maxLen) {
                    maxLen = len;
                    maxLow = low + 1;
                    maxHigh = high - 1;
                }
            }

            // ���������Ӵ�
            low = i - 1;
            high = i + 1;
            while (low >= 0 && high <= list.length - 1) {
                if (list[low] == list[high]) {
                    --low;
                    ++high;
                } else
                    break;
            }
            int len = high - low - 1;
            if (len > maxLen) {
                maxLen = len;
                maxLow = low + 1;
                maxHigh = high - 1;
            }
        }

        return s.substring(maxLow, maxHigh + 1);
    }


    public static void main(String[] args) {
        Subject5 subject = new Subject5();
        System.out.println(subject.longestPalindrome("cbcacbcbbcbcacb"));
    }
}
