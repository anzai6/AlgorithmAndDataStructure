package com.leetcode.anzai.subject_41_60;

/**
 * Pow(x, n)
 * https://leetcode-cn.com/problems/powx-n/
 */
public class Subject50 {

    /**
     *
     ʵ��?pow(x, n)?�������� x �� n ���ݺ�����

     ʾ�� 1:

     ����: 2.00000, 10
     ���: 1024.00000
     ʾ��?2:

     ����: 2.10000, 3
     ���: 9.26100
     ʾ��?3:

     ����: 2.00000, -2
     ���: 0.25000
     ����: 2-2 = 1/22 = 1/4 = 0.25
     ˵��:

     -100.0 <?x?< 100.0
     n?�� 32 λ�з�������������ֵ��Χ��?[?2^31,?2^31?? 1] ��
     *
     */

    /**
     * �ݹ����
     *
     * @param x
     * @param n
     * @return
     */
    public double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        }
        int symbol = 1;
        if (n < 0) {
            n = n == Integer.MIN_VALUE ? Integer.MAX_VALUE : -n; //�п�������ˣ�Ҫע��
            x = 1 / x;
            symbol = -1;
        }

        double result = myPowInternal(x, n);

        return symbol == -1 && n == Integer.MAX_VALUE ? result * x : result;
    }

    /**
     * �ݹ��ڲ����ã�ʹ�ö����۵���
     *
     * @param x
     * @param n
     * @return
     */
    public double myPowInternal(double x, int n) {
        System.out.println("myPowInternal");
        if (n == 1) {
            return x;
        }
        int i = n / 2;
        double result1 = myPowInternal(x, i);
        // result2 ��ȡֵ�ǹؼ���������result1��ֵ���Ż�����ͬ����ĺ�ʱ
        double result2;
        if (i == (n - i)) {
            result2 = result1;
        } else {
            result2 = result1 * x;
        }

        return result1 * result2;
    }

    /**
     * ��ͨ�˷�����ʱ��
     *
     * @param x
     * @param n
     * @return
     */
    public double myPow1(double x, int n) {
        if (n == 0) {
            return 1;
        }
        int symbol = 1;
        if (n < 0) {
            n = -n;
            symbol = -1;
        }
        double result = x;
        for (int i = 1; i < n; i++) {
            result *= x;
        }

        return symbol == -1 ? 1 / result : result;
    }

    public static void main(String[] args) {
        Subject50 subject = new Subject50();
        System.out.println(subject.myPow(2.0000, -2));
    }

}
