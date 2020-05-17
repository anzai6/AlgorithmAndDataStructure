package com.leetcode.anzai.subject_1_20;

/**
 * ������
 * https://leetcode-cn.com/problems/palindrome-number/
 */
public class Subject9 {

    /**
     *
     �ж�һ�������Ƿ��ǻ���������������ָ���򣨴������ң��͵��򣨴������󣩶�����һ����������

     ʾ�� 1:

     ����: 121
     ���: true
     ʾ��?2:

     ����: -121
     ���: false
     ����: �������Ҷ�, Ϊ -121 �� ���������, Ϊ 121- �����������һ����������
     ʾ�� 3:

     ����: 10
     ���: false
     ����: ���������, Ϊ 01 �����������һ����������
     ����:

     ���ܲ�������תΪ�ַ�����������������
     *
     */

    /**
     * ��תΪ�ַ����İ취
     *
     * @param x
     * @return
     */
    public boolean isPalindrome(int x) {
        if (x < 0)
            return false;
        if (x >= 0 && x <= 9)
            return true;

        int newValue = 0;
        int oldValue = x;
        while (true) {
            int last = oldValue % 10; // ��λ��
            if (newValue < Integer.MAX_VALUE / 10
                    || (newValue == Integer.MAX_VALUE / 10 && last <= Integer.MAX_VALUE % 10))
                newValue = newValue * 10 + last;
            else return false;
            if (oldValue >= 10)
                oldValue = oldValue / 10;
            else
                break;
        }
        return newValue == x;
    }


    /**
     * תΪ�ַ����İ취
     *
     * @param x
     * @return
     */
    public boolean isPalindrome1(int x) {
        String data = x + "";
        if (data.length() == 1)
            return true;
        int low = 0;
        int high = data.length() - 1;
        while (low <= high) {
            if (data.charAt(low) == data.charAt(high)) {
                low++;
                high--;
            } else {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        Subject9 subject = new Subject9();
        System.out.println(subject.isPalindrome(Integer.MAX_VALUE));
    }
}
