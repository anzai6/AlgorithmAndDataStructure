package com.leetcode.anzai.subject_21_40;

/**
 * ʵ��strStr()
 * https://leetcode-cn.com/problems/implement-strstr/
 */
public class Subject28 {

    /**
     *
     ʵ��?strStr()?������

     ����һ��?haystack �ַ�����һ�� needle �ַ������� haystack �ַ������ҳ� needle �ַ������ֵĵ�һ��λ�� (��0��ʼ)����������ڣ��򷵻�? -1��

     ʾ�� 1:

     ����: haystack = "hello", needle = "ll"
     ���: 2
     ʾ�� 2:

     ����: haystack = "aaaaa", needle = "bba"
     ���: -1
     ˵��:

     ��?needle?�ǿ��ַ���ʱ������Ӧ������ʲôֵ�أ�����һ���������кܺõ����⡣

     ���ڱ�����ԣ���?needle?�ǿ��ַ���ʱ����Ӧ������ 0 ������C���Ե�?strstr()?�Լ� Java��?indexOf()?���������
     *
     */

    /**
     * @param haystack
     * @param needle
     * @return
     */
    public int strStr(String haystack, String needle) {
        if (needle == null || haystack == null)
            return -1;
        if (needle.length() == 0)
            return 0;
        if (haystack.length() == 0)
            return -1;
        int index = -1;
        for (int i = 0; i < haystack.length() - needle.length() + 1; i++) {
            int j = 0;
            for (; j < needle.length(); j++) {
                if (haystack.charAt(i + j) != needle.charAt(j))
                    break;
            }
            if (j == needle.length()) {
                index = i;
                break;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        Subject28 subject = new Subject28();
        System.out.print(subject.strStr("aaaaa", "bba"));
    }
}
