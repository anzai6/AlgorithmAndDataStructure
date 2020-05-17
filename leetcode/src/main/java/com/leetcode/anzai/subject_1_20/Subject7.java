package com.leetcode.anzai.subject_1_20;

/**
 * ������ת
 * https://leetcode-cn.com/problems/reverse-integer/
 */
public class Subject7 {

    /**
     *
     ����һ�� 32 λ���з�������������Ҫ�����������ÿλ�ϵ����ֽ��з�ת��

     ʾ��?1:

     ����: 123
     ���: 321
     ?ʾ�� 2:

     ����: -123
     ���: -321
     ʾ�� 3:

     ����: 120
     ���: 21
     ע��:

     �������ǵĻ���ֻ�ܴ洢���� 32 λ���з���������������ֵ��ΧΪ?[?231,? 231?? 1]�������������裬�����ת�����������ô�ͷ��� 0��
     *
     */


    /**
     * ��ͨ�ⷨ
     * @param x
     * @return
     */
    public int reverse(int x) {
        String data = x + "";
        StringBuilder sb = new StringBuilder();
        //��һλ��������
        int first = 0;
        if (data.charAt(0) == '-' || data.charAt(0) == '+') {
            sb.append(data.charAt(0));
            first = 1;
        }
        for (int i = data.length() - 1; i >= first; i--) {
            sb.append(data.charAt(i));
        }
        long result = Long.parseLong(sb.toString());
        if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE)
            return 0;
        return (int) result;
    }


    public static void main(String[] args) {
        Subject7 subject = new Subject7();
        System.out.println(subject.reverse(Integer.MAX_VALUE));
    }
}
