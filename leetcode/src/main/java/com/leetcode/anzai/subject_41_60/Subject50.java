package com.leetcode.anzai.subject_41_60;

/**
 * Pow(x, n)
 * https://leetcode-cn.com/problems/powx-n/
 */
public class Subject50 {

    /**
     *
     实现?pow(x, n)?，即计算 x 的 n 次幂函数。

     示例 1:

     输入: 2.00000, 10
     输出: 1024.00000
     示例?2:

     输入: 2.10000, 3
     输出: 9.26100
     示例?3:

     输入: 2.00000, -2
     输出: 0.25000
     解释: 2-2 = 1/22 = 1/4 = 0.25
     说明:

     -100.0 <?x?< 100.0
     n?是 32 位有符号整数，其数值范围是?[?2^31,?2^31?? 1] 。
     *
     */

    /**
     * 递归调用
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
            n = n == Integer.MIN_VALUE ? Integer.MAX_VALUE : -n; //有可能溢出了，要注意
            x = 1 / x;
            symbol = -1;
        }

        double result = myPowInternal(x, n);

        return symbol == -1 && n == Integer.MAX_VALUE ? result * x : result;
    }

    /**
     * 递归内部调用：使用二分折叠发
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
        // result2 的取值是关键：利用了result1的值，优化了相同计算的耗时
        double result2;
        if (i == (n - i)) {
            result2 = result1;
        } else {
            result2 = result1 * x;
        }

        return result1 * result2;
    }

    /**
     * 普通乘法：超时了
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
