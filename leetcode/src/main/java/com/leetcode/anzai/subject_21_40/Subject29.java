package com.leetcode.anzai.subject_21_40;

/**
 * �������
 * https://leetcode-cn.com/problems/divide-two-integers/
 */
public class Subject29 {

    /**
     *
     ��������������������?dividend?�ͳ���?divisor�������������Ҫ��ʹ�ó˷��������� mod �������

     ���ر�����?dividend?���Գ���?divisor?�õ����̡�

     ʾ��?1:

     ����: dividend = 10, divisor = 3
     ���: 3
     ʾ��?2:

     ����: dividend = 7, divisor = -3
     ���: -2
     ˵��:

     �������ͳ�����Ϊ 32 λ�з���������
     ������Ϊ?0��
     �������ǵĻ���ֻ�ܴ洢 32 λ�з�������������ֵ��Χ�� [?231,? 231?? 1]�������У�����������������򷵻� 231?? 1��
     *Subject30
     */

    /**
     * @param dividend
     * @param divisor
     * @return
     */
    public int divide(int dividend, int divisor) {
        if (divisor == 0)
            return dividend;
        if (dividend == 0)
            return 0;
        if (divisor == 1)
            return dividend;
        if (divisor == -1) {
            if (dividend == Integer.MIN_VALUE)
                return Integer.MAX_VALUE;
            return -dividend;
        }

        // ����ֵ
        long absoluteDividend = Math.abs((long) dividend);
        long absoluteDivisor = Math.abs((long)divisor);

        if (absoluteDividend < absoluteDivisor)
            return 0;
        int add = 0;
        int i = 0;
        for (; i < absoluteDividend; i++) {
            if (Integer.MAX_VALUE - absoluteDivisor < add) {
                if(dividend == Integer.MIN_VALUE)
                    i++;
                break;
            }
            add += absoluteDivisor;
            if (add == absoluteDividend) {
                i++;
                break;
            } else if (add > absoluteDividend) {
                break;
            }
        }

        if ((dividend < 0 && divisor < 0) || (dividend > 0 && divisor > 0))
            return i;
        return -i;
    }

    public static void main(String[] args) {
        Subject29 subject = new Subject29();
        System.out.print(subject.divide(-2147483648, 2));

    }

}
