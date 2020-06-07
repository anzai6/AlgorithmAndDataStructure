package com.example.lib.course60_exercise.solution;

/**
 * Reverse String ����ת�ַ�����
 * https://leetcode-cn.com/problems/reverse-string/
 */
public class ReverseStringSolution {

    /**
     *
     ��дһ���������������ǽ�������ַ�����ת�����������ַ������ַ����� char[] ����ʽ������

     ��Ҫ�����������������Ŀռ䣬�����ԭ���޸��������顢ʹ�� O(1) �Ķ���ռ�����һ���⡣

     ����Լ��������е������ַ����� ASCII ����еĿɴ�ӡ�ַ���

     ʾ�� 1��

     ���룺["h","e","l","l","o"]
     �����["o","l","l","e","h"]
     ʾ�� 2��

     ���룺["H","a","n","n","a","h"]
     �����["h","a","n","n","a","H"]

     *
     */


    /**
     * ��ת�ַ���
     *
     * @param s
     */
    public void reverseString(char[] s) {
        if (s == null || s.length == 0)
            return;
        int len = s.length;
        int low = 0;
        int high = len - 1;
        while (low < high) {
            char item = s[low];
            s[low] = s[high];
            s[high] = item;
            low++;
            high--;
        }
    }
}
