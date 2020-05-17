package com.leetcode.anzai.subject_21_40;

/**
 * 两数相除
 * https://leetcode-cn.com/problems/divide-two-integers/
 */
public class Subject29 {

    /**
     *
     给定两个整数，被除数?dividend?和除数?divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。

     返回被除数?dividend?除以除数?divisor?得到的商。

     示例?1:

     输入: dividend = 10, divisor = 3
     输出: 3
     示例?2:

     输入: dividend = 7, divisor = -3
     输出: -2
     说明:

     被除数和除数均为 32 位有符号整数。
     除数不为?0。
     假设我们的环境只能存储 32 位有符号整数，其数值范围是 [?231,? 231?? 1]。本题中，如果除法结果溢出，则返回 231?? 1。
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

        // 绝对值
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
